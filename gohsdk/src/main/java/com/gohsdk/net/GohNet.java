package com.gohsdk.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gohsdk.utils.LogUtil;

import org.json.JSONObject;

import java.util.Map;

public class GohNet {

    private static RequestQueue queue;

    public static void init(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static void post(GohBaseApi api, JSONObject json, Callback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                api.getUrl(),
                json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error);
                    }
                });
        queue.add(jsonObjectRequest);
    }

    public static void post(GohBaseApi api, Map<String, String> map, Callback callback) {
        StringRequest postRequest = new StringRequest(
                Request.Method.POST,
                api.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                return map;
            }
        };
        queue.add(postRequest);
    }

    public interface Callback {

        void onResponse(JSONObject response);

        default void onError(Exception e) {
            LogUtil.e(e.getMessage());
        }
    }
}
