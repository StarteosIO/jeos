package io.starteos.jeos.net.request;

public class AbiInfoRequest extends BaseRequest {
    public AbiInfoRequest(String account_name) {
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
