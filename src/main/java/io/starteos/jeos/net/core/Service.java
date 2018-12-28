package io.starteos.jeos.net.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import io.starteos.jeos.net.protocol.StartService;
import io.starteos.jeos.net.response.BaseResponse;
import io.starteos.jeos.utils.GsonAdapterFactory;

public abstract class Service implements StartService {
    protected final Gson gson;

    public Service() {
        gson = new GsonBuilder()
                .registerTypeAdapterFactory(new GsonAdapterFactory())
                .create();
    }

    protected abstract String performIO(String payload, String url) throws IOException;

    @Override
    public <T extends BaseResponse> T send(Request request, Class<T> resType, Request.CallBack<T> callBack) throws IOException {
        String payload = "";
        if (request.getRequest() != null) {
            payload = gson.toJson(request.getRequest());
        }

        String result = performIO(payload, request.getUrl());
        if (result != null) {
            if (callBack != null) {
                return callBack.format(result,gson);
            } else {
                return gson.fromJson(result, resType);
            }
        }
        return null;
    }

    @Override
    public <T extends BaseResponse> Future<T> sendAsync(final Request request, final Class<T> responseType, final Request.CallBack<T> callBack) {
        return Async.run(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return Service.this.send(request, responseType, callBack);
            }
        });
    }
}
