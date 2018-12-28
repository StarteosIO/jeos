package io.starteos.jeos.net.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableRowsByScopeResponse extends BaseResponse {

    /**
     * rows : [{"core":"eosio.token","scope":"..........e","table":"accounts","payer":"lovestarteos","count":1},{"core":"eosio.token","scope":".........e.e","table":"accounts","payer":"e","count":1},{"core":"eosio.token","scope":"........ehbo5","table":"stat","payer":"eosio.token","count":1},{"core":"eosio.token","scope":".e.e.e.e","table":"accounts","payer":"niqinwoyixia","count":1},{"core":"eosio.token","scope":".e.e.e.e.e.e","table":"accounts","payer":"e","count":1},{"core":"eosio.token","scope":".e.o.s.i.o.e","table":"accounts","payer":"e","count":1},{"core":"eosio.token","scope":".esla.e","table":"accounts","payer":"e","count":1},{"core":"eosio.token","scope":"1","table":"accounts","payer":"wizznetwork1","count":1},{"core":"eosio.token","scope":"1.com","table":"accounts","payer":"qq.com","count":1},{"core":"eosio.token","scope":"1.io","table":"accounts","payer":"ge2dgnbqgtyy","count":1}]
     * more : 11..11..11.e
     */

    private String more;
    private List<RowsBean> rows;

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * core : eosio.token
         * scope : ..........e
         * table : accounts
         * payer : lovestarteos
         * count : 1
         */

        @SerializedName("core")
        private String codeX;
        private String scope;
        private String table;
        private String payer;
        private int count;

        public String getCodeX() {
            return codeX;
        }

        public void setCodeX(String codeX) {
            this.codeX = codeX;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public String getPayer() {
            return payer;
        }

        public void setPayer(String payer) {
            this.payer = payer;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
