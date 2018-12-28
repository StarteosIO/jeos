package io.starteos.jeos.net.core;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.Future;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.starteos.jeos.net.protocol.StartService;
import io.starteos.jeos.net.request.BaseRequest;
import io.starteos.jeos.net.response.BaseResponse;

public class Request<S extends BaseRequest, T extends BaseResponse> {
    private StartService startService;
    private Class<T> resType;
    private S request;
    private String url;
    private CallBack<T> callBack;


    public interface CallBack<T extends BaseResponse> {
        public T format(String data, Gson gson);
    }

    public Request(StartService startService, S request, Class<T> type, String url) {
        this.startService = startService;
        this.url = url;
        this.resType = type;
        this.request = request;
    }

    public T send() throws IOException {
        return startService.send(this, resType, callBack);
    }

    public Future<T> sendAsync() {
        return startService.sendAsync(this, resType, callBack);
    }

    public Flowable<T> rxJava() {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                emitter.onNext(Request.this.send());
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR);
    }

    protected S getRequest() {
        return request;
    }

    protected String getUrl() {
        return url;
    }

    /**
     * 如果出现跨链，并且连接不同的情况下可以调用此函数
     *
     * @param url 新的连接
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 内部使用，进行多种Json格式解析
     * @param callBack  c
     */
    protected void setCallBack(CallBack<T> callBack) {
        this.callBack = callBack;
    }
}
