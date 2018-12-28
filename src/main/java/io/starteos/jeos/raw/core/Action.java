package io.starteos.jeos.raw.core;

import io.starteos.jeos.Name;
import io.starteos.jeos.crypto.util.HexUtils;
import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.exception.PermissionException;
import io.starteos.jeos.raw.Pack;

import java.util.ArrayList;
import java.util.List;



public class Action implements Pack.Packer {
    private Name account;
    private Name name;
    private List<PermissionLevel> authorization;
    private String data;

    public static Action toAction(String account, String name, String authorization, byte[] data) throws NameConversionException, PermissionException {
        Action action = new Action();
        action.account = new Name(account);
        action.name = new Name(name);
        action.authorization = new ArrayList<>();
        String[] authorizations = authorization.split("@");
        if (authorizations.length != 2) {
            throw new PermissionException("Permission Error " + authorization);
        }
        action.authorization.add(new PermissionLevel(new Name(authorizations[0]), new Name(authorizations[1])));
        action.data = HexUtils.toHex(data);
        return action;
    }

    public static Action toAction(String account, String name, String authorization, String data) throws NameConversionException, PermissionException {
        return toAction(account, name, authorization, HexUtils.toBytes(data));
    }

    public Name getAccount() {
        return account;
    }

    public void setAccount(Name account) {
        this.account = account;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<PermissionLevel> getAuthorization() {
        return authorization;
    }

    public void setAuthorization(List<PermissionLevel> authorization) {
        this.authorization = authorization;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void pack(Pack.Writer writer) {
        account.pack(writer);
        name.pack(writer);
        writer.putList(authorization);
        byte[] temps = HexUtils.toBytes(data);
        writer.putUint(temps.length);
        if (temps.length != 0) {
            writer.putBytes(temps);
        }
    }
}
