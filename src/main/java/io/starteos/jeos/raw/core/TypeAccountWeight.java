package io.starteos.jeos.raw.core;

import io.starteos.jeos.raw.Pack;

public class TypeAccountWeight implements Pack.Packer {
    private PermissionLevel permissionLevel;
    private short weight;

    public TypeAccountWeight(PermissionLevel permissionLevel, short weight) {
        this.permissionLevel = permissionLevel;
        this.weight = weight;
    }

    @Override
    public void pack(Pack.Writer writer) {
        permissionLevel.pack(writer);
        writer.putShort(weight);
    }
}
