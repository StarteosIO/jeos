package io.starteos.jeos.raw.core;

import com.google.gson.annotations.Expose;
import io.starteos.jeos.Name;
import io.starteos.jeos.raw.Pack;

public class PermissionLevel implements Pack.Packer {
    private Name actor;
     private Name permission;

    public PermissionLevel(Name a, Name p) {
        actor = a;
        permission = p;
    }


    @Override
    public void pack(Pack.Writer writer) {
        actor.pack(writer);
        permission.pack(writer);
    }
}
