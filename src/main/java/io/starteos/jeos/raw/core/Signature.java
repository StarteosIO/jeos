package io.starteos.jeos.raw.core;

import io.starteos.jeos.crypto.ec.CurveParam;
import io.starteos.jeos.crypto.ec.EosEcUtil;
import io.starteos.jeos.raw.Pack;

public class Signature implements Pack.Packer {
    private String sig;
    public Signature(String sig)
    {
        this.sig = sig;
    }
    @Override
    public void pack(Pack.Writer writer) {
        String[] parts = EosEcUtil.safeSplitEosCryptoString(sig);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid private key format: " + sig);
        }

        if ("SIG".equals(parts[0]) == false) {
            throw new IllegalArgumentException("Signature Key has invalid prefix: " + sig);
        }

        if (parts[2] == null || parts[2].length() == 0) {
            throw new IllegalArgumentException("Signature has no data: " + sig);
        }
        CurveParam curveParam = EosEcUtil.getCurveParamFrom(parts[1]);
        byte[] rawBytes = EosEcUtil.getBytesIfMatchedRipemd160(parts[2], parts[1], null);
        writer.putUint(curveParam.getCurveParamType() == CurveParam.SECP256_K1 ? 0 : 1);
        writer.putBytes(rawBytes);
    }
}
