package com.gohsdk.utils;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;

import com.gohsdk.net.GohBaseApi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpUtil {

    private static final ExecutorService executor;  // 线程池
    private static final Handler mHandler;      // 切换线程用

    static {
        executor = Executors.newFixedThreadPool(5);
        mHandler = new Handler(Looper.getMainLooper());
    }

    public interface Callback {

        void onResponse(String response);

        default void onError(int responseCode, Exception e) {
        }
    }

    public static void get(final String requestUrl, final Map<String, String> params, final Callback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    Uri.Builder builder = Uri.parse(requestUrl).buildUpon();
                    if (params != null) {
                        for (Map.Entry<String, String> entry : params.entrySet()) {
                            builder.appendQueryParameter(entry.getKey(), entry.getValue());
                        }
                    }
                    String address = builder.toString();
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("GET");
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        handleResponse(callback, response.toString());
                    } else {
                        handleError(callback, responseCode, new Exception("Request Failed, Code: " + responseCode));
                    }
                } catch (Exception e) {
                    handleError(callback, 0, e);
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    public static void post(GohBaseApi api, final Map<String, String> params, final Callback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(api.getUrl());
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Accept-Encoding", "identity");
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    StringBuilder sb = new StringBuilder();
                    String body = null;
                    if (params != null) {
                        for (Map.Entry<String, String> entry : params.entrySet()) {
                            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                        }
                    }
                    if (sb.toString().endsWith("&")) {
                        sb.deleteCharAt(sb.length() - 1);
                        body = sb.toString();
                    }
                    if (body != null) {
                        out.writeBytes(body);
                    }
                    out.flush();
                    out.close();
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        handleResponse(callback, response.toString());
                    } else {
                        handleError(callback, responseCode, new Exception("Request Failed, Code: " + responseCode));
                    }
                } catch (Exception e) {
                    handleError(callback, 0, e);
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    private static void handleResponse(final Callback callback, final String response) {
        if (callback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onResponse(response);
                }
            });
        }
    }

    private static void handleError(final Callback callback, final int code, final Exception e) {
        if (callback != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onError(code, e);
                }
            });
        }
    }

    public static void release() {
        mHandler.removeCallbacksAndMessages(null);
        executor.shutdown();
    }
}
