package com.gohsdk.net;

// TODO: 改用 volley
public class GohNet {

 /*   private static final OkHttpClient client = new OkHttpClient();


    public static void post(GohBaseApi api, Map<String, String> params, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(api.getUrl())
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    callback.onResponse(responseBody.string());
                } else {
                    callback.onError(response.code(), new IOException("response body null!"));
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.onError(-1, e);
            }
        });
    }
*/
    /*public static void post(GohBaseApi api, String json, Callback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
//        RequestBody requestBody = RequestBody.create( MediaType.get("application/json; charset=utf-8"),json);

        Request request = new Request.Builder()
                .url(api.getUrl())
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    callback.onResponse(responseBody.string());
                } else {
                    callback.onError(response.code(), new IOException("response body null!"));
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                callback.onError(-1, e);
            }
        });
    }
*/
    public interface Callback {

        void onResponse(String response);

        default void onError(int responseCode, Exception e) {
        }
    }
}
