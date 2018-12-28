package io.starteos.jeos.net.response;

public class AbiBinToJsonResponse<T> extends BaseResponse {
    private T args;


    public T getArgs() {
        return args;
    }

    public void setArgs(T args) {
        this.args = args;
    }
}
