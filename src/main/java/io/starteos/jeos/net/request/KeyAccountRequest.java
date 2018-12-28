package io.starteos.jeos.net.request;

public class KeyAccountRequest extends BaseRequest {
    private String public_key;

    public KeyAccountRequest(String public_key) {
        this.public_key = public_key;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }
}
