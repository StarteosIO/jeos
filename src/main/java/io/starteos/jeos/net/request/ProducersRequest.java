package io.starteos.jeos.net.request;

public class ProducersRequest extends BaseRequest {
    private String limit;
    private String lower_bound;
    private boolean json = true;

    public ProducersRequest(String limit, String lower_bound) {
        this.limit = limit;
        this.lower_bound = lower_bound;
    }

    public String getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(String lower_bound) {
        this.lower_bound = lower_bound;
    }

    public boolean isJson() {
        return json;
    }

    public void setJson(boolean json) {
        this.json = json;
    }
}
