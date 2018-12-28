package io.starteos.jeos.net.request;

import java.util.List;

public class PushTransactionRequest extends BaseRequest {
    private List<String> signatures;
    private String compression;
    private String packed_context_free_data;
    private String packed_trx;

    public PushTransactionRequest(List<String> signatures, String compression, String packed_context_free_data, String packed_trx) {
        this.signatures = signatures;
        this.compression = compression;
        this.packed_context_free_data = packed_context_free_data;
        this.packed_trx = packed_trx;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public String isCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getPacked_context_free_data() {
        return packed_context_free_data;
    }

    public void setPacked_context_free_data(String packed_context_free_data) {
        this.packed_context_free_data = packed_context_free_data;
    }

    public String getPacked_trx() {
        return packed_trx;
    }

    public void setPacked_trx(String packed_trx) {
        this.packed_trx = packed_trx;
    }
}
