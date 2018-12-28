package io.starteos.jeos.net.response;

import java.util.List;

public class KeyAccountResponse extends BaseResponse {
    private List<String> account_names;

    public List<String> getAccount_names() {
        return account_names;
    }

    public void setAccount_names(List<String> account_names) {
        this.account_names = account_names;
    }
}
