package io.starteos.jeos.transaction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.starteos.jeos.crypto.util.HexUtils;
import io.starteos.jeos.raw.core.Action;
import io.starteos.jeos.utils.GsonAdapterFactory;
import org.junit.Test;

import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.exception.PermissionException;
import io.starteos.jeos.raw.Writer;

public class TransactionTest {

    @Test
    public void pack() throws NameConversionException, PermissionException {
        Transaction transaction = new Transaction();
        transaction.setDelay_sec(100);
        transaction.setExpiration("2018-12-13T13:22:24");
        transaction.setMax_cpu_usage_ms(100);
        transaction.setNet_usage_words(123123);
        Action action = Action.toAction("test", "test", "haichecker@owner", HexUtils.toBytes("62010101000000010000000000000001000162"));
        transaction.addAction(action);
        Writer writer = new Writer(255);
        transaction.pack(writer);
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new GsonAdapterFactory())
                .create();
        System.out.println(gson.toJson(transaction));
    }
}