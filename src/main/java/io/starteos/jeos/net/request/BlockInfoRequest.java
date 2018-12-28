package io.starteos.jeos.net.request;

public class BlockInfoRequest extends BaseRequest {
    private String block_num_or_id;

    public BlockInfoRequest(String block_num_or_id) {
        this.block_num_or_id = block_num_or_id;
    }
}
