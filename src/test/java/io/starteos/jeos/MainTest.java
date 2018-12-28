package io.starteos.jeos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.starteos.jeos.crypto.digest.Sha256;
import io.starteos.jeos.crypto.ec.EosPrivateKey;
import io.starteos.jeos.crypto.util.HexUtils;
import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.net.StartEOS;
import io.starteos.jeos.net.StartFactory;
import io.starteos.jeos.net.core.HttpService;
import io.starteos.jeos.net.response.InfoResponse;
import io.starteos.jeos.net.response.PushTransactionResponse;
import io.starteos.jeos.net.response.RequiredKeysResponse;
import io.starteos.jeos.raw.Writer;
import io.starteos.jeos.raw.core.Action;
import io.starteos.jeos.raw.core.PermissionLevel;
import io.starteos.jeos.raw.core.Signature;
import io.starteos.jeos.raw.core.TypePublicKey;
import io.starteos.jeos.transaction.*;
import io.starteos.jeos.transaction.type.ChainTypeId;
import io.starteos.jeos.utils.GsonAdapterFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) throws IOException, NameConversionException {
        EosPrivateKey eosPrivateKey = new EosPrivateKey("5Jg3KtArcxdsk2opXpyBNqKeZ7ah9SFLPg2Xx8vHFGCnfRGffkD");
        StartEOS startEOS = StartFactory.build(new HttpService("http://bos-testnet.mytokenpocket.vip:8890"));
        InfoResponse infoResponse = startEOS.info().send();

        SignedTransaction signedTransaction = new SignedTransaction();
        signedTransaction.setReferenceBlock(infoResponse.getHead_block_id());
        signedTransaction.setExpiration(infoResponse.getTimeAfterHeadBlockTime(30000));
        signedTransaction.setSignatures(new ArrayList<>());
        Action action = new Action();
        action.setName(new Name("create"));
        action.setAccount(new Name("bosredpacket"));

        Writer writer = new Writer(255);

        new Name("v5v5v5v5v5v5").pack(writer);
        TypePublicKey typePublicKey = new TypePublicKey(eosPrivateKey.getPublicKey());
        typePublicKey.pack(writer);
        typePublicKey.pack(writer);
        writer.putLong(1545706394999L);

        Writer writer1 = new Writer(255);
        writer1.putLong(1545706394999L);
        Signature signature = new Signature(eosPrivateKey.sign(Sha256.from(BigInteger.valueOf(1545706394999L).toByteArray())).toString());
        signature.pack(writer);

        ArrayList<PermissionLevel> arrayList = new ArrayList<>();
        arrayList.add(new PermissionLevel(new Name("bosfreetouse"),new Name("redpacket")));
        action.setAuthorization(arrayList);



//        Writer writer1 = new Writer(255);
//        Name from = new Name("111111111oo1");
//        Name to = new Name("111111111ooo");
//        Symbol symbol = new Symbol("0.0001 BOS");
//        String memo = "a";
//
//        from.pack(writer1);
//        to.pack(writer1);
//        symbol.pack(writer1);
//        writer1.putString(memo);


        action.setData(HexUtils.toHex(writer.toBytes()));

        signedTransaction.addAction(action);

        ArrayList<String> pub = new ArrayList<>();
        pub.add(eosPrivateKey.getPublicKey().toString());
        RequiredKeysResponse requiredKeysResponse = startEOS.getRequiredKeys(new GsonBuilder().registerTypeAdapterFactory(new GsonAdapterFactory()).serializeNulls().create().toJson(signedTransaction),pub).send();

        signedTransaction.sign(eosPrivateKey,new ChainTypeId(infoResponse.getChain_id()));
        PushTransactionResponse pushTransactionResponse = startEOS.pushTransaction(new PackedTransaction(signedTransaction)).send();
        System.out.println(new Gson().toJson(pushTransactionResponse));

    }
}
