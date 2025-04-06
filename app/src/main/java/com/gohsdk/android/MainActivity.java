package com.gohsdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gohsdk.core.GohSDK;
import com.gohsdk.core.IPlatformCallback;
import com.gohsdk.ui.GohUserCenterDialog;
import com.gohsdk.ui.dialog.GohLoginDialog;
import com.gohsdk.ui.view.GohFloatingBall;
import com.gohsdk.utils.LogUtil;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_init).setOnClickListener(this);
        findViewById(R.id.btn_user_center).setOnClickListener(this);
        findViewById(R.id.btn_float_ball).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_init) {
            GohSDK.get().init(this, new IPlatformCallback() {
                @Override
                public void onInit(int code, Bundle bundle) {

                }

                @Override
                public void onLogin(int code, Bundle bundle) {

                }

                @Override
                public void onPay(int code, Bundle bundle) {

                }

                @Override
                public void onLogout(int code, Bundle bundle) {

                }
            });
        } else if (view.getId() == R.id.btn_login) {
            GohLoginDialog dialog = new GohLoginDialog(this);
            dialog.show();
        } else if (view.getId() == R.id.btn_user_center) {
            doJsonRequest();
        } else if (view.getId() == R.id.btn_float_ball) {
            GohFloatingBall ball = new GohFloatingBall();
            ball.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GohUserCenterDialog dialog = new GohUserCenterDialog(v.getContext());
                    dialog.show();
                }
            });
            ball.show();
        }
    }

    private void doRequest() {
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(this);

        // 创建 StringRequest 请求对象
        StringRequest postRequest = new StringRequest(
                Request.Method.POST,
                "http://user.gzfenghou.cn/ApiInit.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // 请求成功时的回调
                        LogUtil.d("Response: " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 请求失败时的回调
                        LogUtil.e("Error: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                // 添加 POST 请求的参数
                Map<String, String> params = new HashMap<>();
                params.put("gid", "1");
                return params;
            }
        };

        // 将请求添加到队列
        queue.add(postRequest);
    }

    private void doJsonRequest(){
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject json = new JSONObject();
        try {
            json.put("gid",1);
        }catch (Exception e){
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://user.gzfenghou.cn/ApiInit.php",
                json,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // 处理响应
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // 处理错误
                    }
                });
        queue.add(jsonObjectRequest);
    }
}