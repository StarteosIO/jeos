package io.starteos.jeos.net.response;

public class CurrencyStatsResponse extends BaseResponse {

    /**
     * supply : 1025315110.6149 EOS
     * max_supply : 10000000000.0000 EOS
     * issuer : eosio
     */

    private String supply;
    private String max_supply;
    private String issuer;

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public String getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(String max_supply) {
        this.max_supply = max_supply;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
