package io.starteos.jeos.net.response;

import com.google.gson.annotations.Expose;

import java.util.List;

public class BalanceResponse extends BaseResponse {
    @Expose
    private String codez;
    private String account;
    private String symbol;
    private List<String> data;

    public BalanceResponse(String code, String account, String symbol, List<String> data) {
        this.codez = code;
        this.account = account;
        this.symbol = symbol;
        this.data = data;
    }

    public String getCodeThis() {
        return codez;
    }

    public void setCode(String code) {
        this.codez = code;
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

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
