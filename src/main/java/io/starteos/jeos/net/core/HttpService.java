package io.starteos.jeos.net.core;

import java.io.IOException;

import io.starteos.jeos.net.response.BaseResponse;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpService extends Service {
    private OkHttpClient okHttpClient;
    private String baseUrl;
    public static final MediaType JSON_MEDIA_TYPE
            = MediaType.parse("application/json; charset=utf-8");

    public HttpService(String baseUrl) {
        this(baseUrl, null);
    }

    public HttpService(String baseUrl, OkHttpClient okHttpClient) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .build();
        }
        this.baseUrl = baseUrl;
        this.okHttpClient = okHttpClient;
    }

    @Override
    protected String performIO(String payload, String url) throws IOException {
        RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, payload);
        Request request = new Request.Builder()
                .url(baseUrl + url)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
//        if (response.isSuccessful()) {
        ResponseBody responseBody = response.body();
        if (responseBody != null) {
            String str = responseBody.string();
            response.close();
            return str;
        } else {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setCode(404);
            baseResponse.setMessage("data is null");
            response.close();
            return gson.toJson(baseResponse);
        }
//        }
//        System.out.println(response.body().string());
    }
}
