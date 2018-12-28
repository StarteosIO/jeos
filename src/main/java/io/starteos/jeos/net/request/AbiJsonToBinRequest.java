package io.starteos.jeos.net.request;

public class AbiJsonToBinRequest<T> extends BaseRequest {

    /**
     * core : eosio.token
     * action : transfer
     * args : {"from":"string.x","memo":"Starteos.io","quantity":"7.0000 EOS","to":"object.x"}
     */

    private String code;
    private String action;
    private T args;

    public AbiJsonToBinRequest(String code, String action, T args) {
        this.code = code;
        this.action = action;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getArgs() {
        return args;
    }

    public void setArgs(T args) {
        this.args = args;
    }


}
