package io.starteos.jeos.net.response;

import java.util.List;

public class TableRowsResponse<T> extends BaseResponse {

    /**
     * more : false
     */

    private boolean more;
    private List<T> rows;

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

}
