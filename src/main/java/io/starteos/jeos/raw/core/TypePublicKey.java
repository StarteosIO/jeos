package io.starteos.jeos.raw.core;

import io.starteos.jeos.crypto.ec.EosPublicKey;
import io.starteos.jeos.raw.Pack;

public class TypePublicKey implements Pack.Packer {
    private EosPublicKey eosPublicKey;
    public TypePublicKey(EosPublicKey eosPublicKey)
    {
        this.eosPublicKey = eosPublicKey;
    }
    public TypePublicKey(String pub)
    {
        this.eosPublicKey = new EosPublicKey(pub);
    }
    @Override
    public void pack(Pack.Writer writer) {
        writer.putUint( eosPublicKey.isCurveParamK1() ? 0 : 1 );

        writer.putBytes( eosPublicKey.getBytes());
    }
}
