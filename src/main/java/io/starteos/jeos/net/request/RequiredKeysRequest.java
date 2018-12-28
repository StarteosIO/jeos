package io.starteos.jeos.net.request;

import com.google.gson.JsonElement;

import java.util.List;

public class RequiredKeysRequest extends BaseRequest {
    private JsonElement transaction;
    private List<String> available_keys;

    public RequiredKeysRequest(JsonElement transaction, List<String> available_keys) {
        this.transaction = transaction;
        this.available_keys = available_keys;
    }

    public JsonElement getTransaction() {
        return transaction;
    }

    public void setTransaction(JsonElement transaction) {
        this.transaction = transaction;
    }

    public List<String> getAvailable_keys() {
        return available_keys;
    }

    public void setAvailable_keys(List<String> available_keys) {
        this.available_keys = available_keys;
    }
}
