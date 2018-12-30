package io.starteos.jeos.raw.core;

import com.google.common.base.Preconditions;
import io.starteos.jeos.crypto.ec.CurveParam;
import io.starteos.jeos.crypto.ec.EosEcUtil;
import io.starteos.jeos.raw.Pack;

public class TypeSignature implements Pack.Packer {
    private String sig;
    public TypeSignature(String sig)
    {
        this.sig = sig;
    }
    @Override
    public void pack(Pack.Writer writer) {
        String[] parts = EosEcUtil.safeSplitEosCryptoString(sig);
        Preconditions.checkArgument(parts.length >= 3,"Invalid private key format: " + sig);
        Preconditions.checkArgument("SIG".equals(parts[0]),"Signature Key has invalid prefix: " + sig);
        Preconditions.checkArgument(!(parts[2] == null || parts[2].length() == 0),"Signature has no data: " + sig);
        CurveParam curveParam = EosEcUtil.getCurveParamFrom(parts[1]);
        byte[] rawBytes = EosEcUtil.getBytesIfMatchedRipemd160(parts[2], parts[1], null);
        writer.putUint(curveParam.getCurveParamType() == CurveParam.SECP256_K1 ? 0 : 1);
        writer.putBytes(rawBytes);
    }
}
