package io.starteos.jeos.net.request;

public class RawAbiAndCodeRequest extends BaseRequest {
    public RawAbiAndCodeRequest(String account_name) {
        this.account_name = account_name;
    }

    /**
     * account_name : starteosio
     */

    private String account_name;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
}
