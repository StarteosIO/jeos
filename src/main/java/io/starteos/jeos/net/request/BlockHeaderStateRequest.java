package io.starteos.jeos.net.request;

public class BlockHeaderStateRequest extends BaseRequest {
    private String block_num_or_id;

    public BlockHeaderStateRequest(String block_num_or_id) {
        this.block_num_or_id = block_num_or_id;
    }
}
