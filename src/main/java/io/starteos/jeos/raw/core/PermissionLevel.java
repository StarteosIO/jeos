package io.starteos.jeos.raw.core;

import com.google.common.base.Preconditions;
import com.google.gson.annotations.Expose;
import io.starteos.jeos.Name;
import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.raw.Pack;

public class PermissionLevel implements Pack.Packer {
    private Name actor;
     private Name permission;

     public static PermissionLevel create(String permission) throws NameConversionException {
         String[] p = permission.split("@");
         Preconditions.checkArgument(p.length == 2,String.format("permission :%s Error",permission));
         return new PermissionLevel(new Name(p[0]),new Name(p[1]));
     }

     public static PermissionLevel create(String actor,String permission)
     {
         try {
             return create(String.format("%s@%s",actor,permission));
         } catch (NameConversionException e) {
             e.printStackTrace();
         }
         return null;
     }

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
