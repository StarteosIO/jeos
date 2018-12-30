package io.starteos.jeos.raw.core;

import io.starteos.jeos.raw.Pack;

public class TypeWaitsWeight implements Pack.Packer {
    private long wait_sec;
    private short weight;

    public TypeWaitsWeight(long wait_sec, short weight) {
        this.wait_sec = wait_sec;
        this.weight = weight;
    }

    @Override
    public void pack(Pack.Writer writer) {
        writer.putInt((int) wait_sec);
        writer.putShort(weight);
    }
}
