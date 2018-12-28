package io.starteos.jeos.transaction.type;

import io.starteos.jeos.crypto.digest.Sha256;

public class ChainTypeId {
    private final Sha256 mId;

    public ChainTypeId() {
        mId = Sha256.ZERO_HASH;
    }

    byte [] getSha256FromHexStr(String str){
        int len = str.length();
        byte [] bytes = new byte[32];
        for(int i=0;i<len;i+=2){
            String strIte = str.substring(i, i+2);
            Integer n =Integer.parseInt(strIte, 16) & 0xFF;
            bytes[i/2] = n.byteValue();
        }
        return bytes;
    }
    public ChainTypeId(String str){
        mId = new Sha256(getSha256FromHexStr(str));
    }

    public byte[] getBytes() {
        return mId.getBytes();
    }
}
