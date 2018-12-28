package io.starteos.jeos.net.request;

public class BalanceRequest extends BaseRequest {
    private String code;
    private String account;
    private String symbol;

    public BalanceRequest(String code, String account, String symbol) {
        this.code = code;
        this.account = account;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
