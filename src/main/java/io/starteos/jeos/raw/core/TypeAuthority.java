package io.starteos.jeos.raw.core;

import io.starteos.jeos.raw.Pack;

import java.util.ArrayList;
import java.util.List;

public class TypeAuthority implements Pack.Packer {
    private int threshold;
    private long delay_sec = 0;
    private List<TypeKeyWeight> keys;
    private List<TypeAccountWeight> accounts;
    private List<TypeWaitsWeight> waits;


    public static TypeAuthority create(TypeKeyWeight keyWeight)
    {
        List<TypeKeyWeight> typeKeyWeights = new ArrayList<>();
        typeKeyWeights.add(keyWeight);
        return create(typeKeyWeights);
    }

    public static TypeAuthority create(List<TypeKeyWeight> keys){
        List<TypeAccountWeight> accountWeights = new ArrayList<>();
        List<TypeWaitsWeight> typeWaitsWeights = new ArrayList<>();
        return create(1,1,keys,accountWeights,typeWaitsWeights);
    }

    public static  TypeAuthority create(int threshold,long delay_sec,List<TypeKeyWeight> keys,List<TypeAccountWeight> accounts,List<TypeWaitsWeight> waits)
    {
        return new TypeAuthority(threshold, delay_sec, keys, accounts, waits);
    }

    public TypeAuthority(int threshold,long delay_sec,List<TypeKeyWeight> keys,List<TypeAccountWeight> accounts,List<TypeWaitsWeight> waits)
    {
        this.keys = keys;
        this.accounts = accounts;
        this.waits = waits;
        this.threshold = threshold;
        this.delay_sec = delay_sec;
    }

    @Override
    public void pack(Pack.Writer writer) {
        writer.putInt(threshold);
        writer.putList(keys);
        writer.putList(accounts);
        writer.putList(waits);
    }
}
