package com.gohsdk.utils;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpUtil {

    private static final ExecutorService executor;  // 线程池
    private static final Handler mHandler;      // 切换线程用

    static {
        executor = Executors.newFixedThreadPool(5);
        mHandler = new Handler();
    }

    public interface Callback {

        void onResponse(String response);

        void onError(int responseCode, Exception e);
    }

    public static void doGet(final String requestUrl, final Map<String, String> params, final Callback callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    String address = requestUrl;
                    if (params != null) {
                        StringBuilder sb = new StringBuilder();
                        Set<Map.Entry<String, String>> sets = params.entrySet();
                        for (Map.Entry<String, String> entry : sets) {
                            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                        }
                        address += "?" + sb.substring(0, sb.length() - 1);
                    }
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
                    if (responseCode == 200) {
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
}
