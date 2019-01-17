package io.starteos.jeos;

import com.google.gson.Gson;
import io.starteos.jeos.crypto.ec.EosPrivateKey;
import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.exception.PermissionException;
import io.starteos.jeos.net.StartEOS;
import io.starteos.jeos.net.StartFactory;
import io.starteos.jeos.net.core.HttpService;
import io.starteos.jeos.net.response.AbiJsonToBinResponse;
import io.starteos.jeos.net.response.PushTransactionResponse;
import io.starteos.jeos.raw.core.Action;
import io.starteos.jeos.transaction.PackedTransaction;
import io.starteos.jeos.transaction.SignedTransaction;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void net_test() throws IOException, NameConversionException, PermissionException {
        // SpringApplication.run(AccountApplication.class, args);
        StartEOS eos = StartFactory.build(new HttpService("https://api-mainnet.starteos.io"));
        String prk = "5JV959zrgyKKNXb3yeDrwr1AHjCzwkaDYmCLMD94URKRzpvbiFP";
        // SignedTransaction s = new SignedTransaction();
        // s.addAction(Action.toAction("", "", "a@active", ""));
        HashMap<String, Object> map = new HashMap<>();
        map.put("from", "string.x");
        map.put("to", "double.x");
        map.put("memo", "X");
        map.put("quantity", "0.0001 AC");
        AbiJsonToBinResponse abi = eos.abiJsonToBin("aircoin.eos", "transfer", map).send();
        List<Action> actions = new ArrayList<>();
        actions.add(Action.toAction("aircoin.eos", "transfer", "string.x@active", abi.getBinargs()));
        PackedTransaction s = SignedTransaction.createTransactionSync(eos, actions, new EosPrivateKey(prk));
        PushTransactionResponse r = eos.pushTransaction(s).send();
        System.err.println(new Gson().toJson(r));
    }
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}