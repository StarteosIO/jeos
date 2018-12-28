package io.starteos.jeos.net.request;

public class TableRowsRequest extends BaseRequest {
    private String scope;
    private String code;
    private String table;

    public TableRowsRequest(String scope, String code, String table) {
        this.scope = scope;
        this.code = code;
        this.table = table;
    }

    private String table_key;
    private boolean json = true;
    private String lower_bound;
    private String upper_bound;
    private String key_type;
    private String encode_type = "dec";
    private String index_position;
    private int limit;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTable_key() {
        return table_key;
    }

    public void setTable_key(String table_key) {
        this.table_key = table_key;
    }

    public boolean isJson() {
        return json;
    }

    public void setJson(boolean json) {
        this.json = json;
    }

    public String getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(String lower_bound) {
        this.lower_bound = lower_bound;
    }

    public String getUpper_bound() {
        return upper_bound;
    }

    public void setUpper_bound(String upper_bound) {
        this.upper_bound = upper_bound;
    }

    public String getKey_type() {
        return key_type;
    }

    public void setKey_type(String key_type) {
        this.key_type = key_type;
    }

    public String getEncode_type() {
        return encode_type;
    }

    public void setEncode_type(String encode_type) {
        this.encode_type = encode_type;
    }

    public String getIndex_position() {
        return index_position;
    }

    public void setIndex_position(String index_position) {
        this.index_position = index_position;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
