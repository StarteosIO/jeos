package io.starteos.jeos.net.request;

public class AbiBinToJsonRequest extends BaseRequest {

    /**
     * core : eosio.token
     * action : transfer
     * binargs : 0000001db0e96ec60000001d64a4dea1701101000000000004454f53000000000b5374617274656f732e696f
     */

    private String code;
    private String action;
    private String binargs;

    public AbiBinToJsonRequest(String code, String action, String binargs) {
        this.code = code;
        this.action = action;
        this.binargs = binargs;
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

    public String getBinargs() {
        return binargs;
    }

    public void setBinargs(String binargs) {
        this.binargs = binargs;
    }

}
