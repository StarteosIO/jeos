package io.starteos.jeos.net.protocol;

import java.io.IOException;
import java.util.concurrent.Future;

import io.starteos.jeos.net.core.Request;
import io.starteos.jeos.net.response.BaseResponse;

public interface StartService {
    <T extends BaseResponse> T send(Request request, Class<T> resType, Request.CallBack<T> callBack) throws IOException;

    <T extends BaseResponse> Future<T> sendAsync(Request request, Class<T> responseType, Request.CallBack<T> callBack);
}
