package io.starteos.jeos.transaction;

import java.util.ArrayList;
import java.util.List;

import io.starteos.jeos.crypto.digest.Sha256;
import io.starteos.jeos.crypto.ec.EcDsa;
import io.starteos.jeos.crypto.ec.EcSignature;
import io.starteos.jeos.crypto.ec.EosPrivateKey;
import io.starteos.jeos.crypto.util.HexUtils;
import io.starteos.jeos.raw.Writer;
import io.starteos.jeos.transaction.type.ChainTypeId;

public class SignedTransaction extends Transaction {
    private List<String> signatures = null;

    private List<String> context_free_data = new ArrayList<>();

    public SignedTransaction() {
        super();
    }

    public SignedTransaction(SignedTransaction signedTransaction) {
        super(signedTransaction);
        this.signatures = deepCopyOnlyContainer(signedTransaction.signatures);
        this.context_free_data = deepCopyOnlyContainer(signedTransaction.context_free_data);
    }

    public List<String> getCtxFreeData() {
        return context_free_data;
    }

    private byte[] getCfdHash() {
        if (context_free_data.size() <= 0) {
            return Sha256.ZERO_HASH.getBytes();
        }

        Writer writer = new Writer(255);

        writer.putUint(context_free_data.size());

        for (String hexData : context_free_data) {
            byte[] rawData = HexUtils.toBytes(hexData);
            writer.putUint(rawData.length);
            writer.putBytes(rawData);
        }

        return Sha256.from(writer.toBytes()).getBytes();
    }

    private Sha256 getDigestForSignature(ChainTypeId chainId) {
        Writer writer = new Writer(255);

        // data layout to sign :
        // [ {chainId}, {Transaction( parent class )}, {hash of context_free_data} ]

        writer.putBytes(chainId.getBytes());
        pack(writer);
        writer.putBytes(getCfdHash());

        return Sha256.from(writer.toBytes());
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public List<String> getContext_free_data() {
        return context_free_data;
    }

    public void setContext_free_data(List<String> context_free_data) {
        this.context_free_data = context_free_data;
    }

    public void sign(EosPrivateKey privateKey, ChainTypeId chainId) {
        if (null == this.signatures) {
            this.signatures = new ArrayList<>();
        }

        EcSignature signature = EcDsa.sign(getDigestForSignature(chainId), privateKey);
        this.signatures.add(signature.toString());
    }
}
