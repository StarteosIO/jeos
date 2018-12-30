package io.starteos.jeos.raw.core;

import com.google.common.base.Preconditions;
import io.starteos.jeos.crypto.ec.EosPublicKey;
import io.starteos.jeos.raw.Pack;

public class TypeKeyWeight implements Pack.Packer {
    private TypePublicKey key;
    private int weight;

    public static TypeKeyWeight create(String pub,int weight){
        return new TypeKeyWeight(new TypePublicKey(new EosPublicKey(pub)),weight);
    }

    public TypeKeyWeight(TypePublicKey publicKey,int weight)
    {
        this.key = publicKey;
        this.weight = weight;
        Preconditions.checkArgument(weight > 0,"weight Error");
    }
    @Override
    public void pack(Pack.Writer writer) {
        key.pack(writer);
        writer.putInt(weight);
    }
}
