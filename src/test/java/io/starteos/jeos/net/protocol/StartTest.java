package io.starteos.jeos.net.protocol;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import io.starteos.jeos.Name;
import io.starteos.jeos.crypto.ec.EosPrivateKey;
import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.exception.PermissionException;
import io.starteos.jeos.net.response.*;
import io.starteos.jeos.raw.Writer;
import io.starteos.jeos.raw.core.Action;
import io.starteos.jeos.transaction.PackedTransaction;
import io.starteos.jeos.transaction.SignedTransaction;
import io.starteos.jeos.transaction.type.ChainTypeId;
import io.starteos.jeos.utils.GsonAdapterFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import io.reactivex.functions.Consumer;
import io.starteos.jeos.net.StartEOS;
import io.starteos.jeos.net.StartFactory;
import io.starteos.jeos.net.core.HttpService;
import io.starteos.jeos.net.core.Request;
import io.starteos.jeos.net.request.AbiBinToJsonRequest;
import io.starteos.jeos.net.request.TableRowsRequest;

public class StartTest {

    private StartEOS startEOS = null;
    private Gson gson;

    @Before
    public void init() {
        startEOS = StartFactory.build(new HttpService("https://api-mainnet.starteos.io"));
        gson = new GsonBuilder().registerTypeAdapterFactory(new GsonAdapterFactory()).create();
    }

    public static void main(String[] args) throws IOException {
        StartTest startTest = new StartTest();
        startTest.init();
        startTest.tableRow();
    }

    @Test
    public void info() throws IOException {
        System.out.println("Start get info...");
        InfoResponse infoResponse = startEOS.info().send();
        System.out.println(infoResponse.getServer_version());


    }

    @Test
    public void block() {
    }

    @Test
    public void accountInfo() throws IOException {
        System.out.println("Start get accounts...");
        AccountResponse accountResponse = startEOS.accountInfo("starteosiobp").send();
        (accountResponse.isError() ? System.err : System.out).println(accountResponse.isError() ? Arrays.toString(accountResponse.getError().getDetails().toArray()) : gson.toJson(accountResponse));

    }

    @Test
    public void abiInfo() {
    }

    @Test
    public void rawAbiAndCode() throws IOException {
        System.out.println("Start get abi and core...");
        RawAbiAndCodeResponse abiAndCodeResponse = startEOS.rawAbiAndCode("eosio.token").send();
        (abiAndCodeResponse.isError() ? System.err : System.out).println(abiAndCodeResponse.isError() ? Arrays.toString(abiAndCodeResponse.getError().getDetails().toArray()) : gson.toJson(abiAndCodeResponse));
    }

    @Test
    public void tableRow() throws IOException {
        System.out.println("Start get table rows...");
        HashMap<String,Object> params = new HashMap<>();
        params.put("limit",1);
        Request<TableRowsRequest, TableRowsResponse<String>> request = startEOS.tableRow("eosio", "eosio", "rammarket", params);
        TableRowsResponse<String> tableRowsResponse = request.send();
        (tableRowsResponse.isError() ? System.err : System.out).println(tableRowsResponse.isError() ? Arrays.toString(tableRowsResponse.getError().getDetails().toArray()) : gson.toJson(tableRowsResponse));

    }

    @Test
    public void balance() throws IOException {
        System.out.println("Start get balance...");
        BalanceResponse balanceResponse = startEOS.balance("eosio.token", "bosfreetouse", "BOS")
                .send();
        (balanceResponse.isError() ? System.err : System.out).println(balanceResponse.isError() ? Arrays.toString(balanceResponse.getError().getDetails().toArray()) : Arrays.toString(balanceResponse.getData().toArray()));
    }

    @Test
    public void abiJsonToBin() throws IOException {
        System.out.println("Start abi Json To Bin...");
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("from", "string.x");
        stringStringHashMap.put("to", "object.x");
        stringStringHashMap.put("quantity", "1314520.0000 EOS");
        stringStringHashMap.put("memo", "Starteos.io");
        AbiJsonToBinResponse abiJsonToBinResponse = startEOS.abiJsonToBin("eosio.token", "transfer", stringStringHashMap).send();
        (abiJsonToBinResponse.isError() ? System.err : System.out).println(abiJsonToBinResponse.isError() ? Arrays.toString(abiJsonToBinResponse.getError().getDetails().toArray()) : gson.toJson(abiJsonToBinResponse));

    }

    @Test
    public void send() throws IOException, NameConversionException, PermissionException {
        ArrayList<Action> actions = new ArrayList<>();
        Writer writer = new Writer(255);
        try {
            Name name = new Name("auction3.eos");
            name.pack(writer);
            writer.putLong(1);
        } catch (NameConversionException e) {
            e.printStackTrace();
        }
        actions.add(Action.toAction("auction.e", "del", "auction.e@active", writer.toBytes()));
        InfoResponse infoResponse = startEOS.info().send();
        SignedTransaction signedTransaction = new SignedTransaction();
        signedTransaction.setReferenceBlock(infoResponse.getHead_block_id());
        signedTransaction.setSignatures(new ArrayList<>());
        signedTransaction.setExpiration(infoResponse.getTimeAfterHeadBlockTime(30000));
        BlockResponse blockResponse = startEOS.block(infoResponse.getHead_block_id()).send();
        signedTransaction.setRef_block_prefix(blockResponse.getRef_block_prefix());
        signedTransaction.setRef_block_num((int) blockResponse.getBlock_num());
        for (Action action : actions) {
            signedTransaction.addAction(action);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(new EosPrivateKey("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3").getPublicKey().toString());
        RequiredKeysResponse requiredKeysResponse = startEOS.getRequiredKeys(gson.toJson(signedTransaction), arrayList).send();
        System.out.println(gson.toJson(signedTransaction));
        signedTransaction.sign(new EosPrivateKey("5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3"), new ChainTypeId(infoResponse.getChain_id()));
        PackedTransaction packedTransaction = new PackedTransaction(signedTransaction);
        startEOS.pushTransaction(packedTransaction.getSignatures(), packedTransaction.getCompression(), packedTransaction.getPacked_context_free_data(), packedTransaction.getPacked_trx()).send();
//        a63c235c1701a9d8636300000000000000010000506052979136000000000000a24a01000050605297913600000000a8ed32321080a9026352979136010000000000000000
//        7c34235cc2f06bd0193300000000010000506052979136000000000000a24a01000050605297913600000000a8ed32321080a9026352979136010000000000000000
    }

    @Test
    public void abiBinToJson() throws IOException {
        System.out.println("Start bin to json...");
        Request<AbiBinToJsonRequest, AbiBinToJsonResponse<HashMap<String, String>>> request = startEOS.abiBinToJson("auction.e", "del", "80a90263529791360100000000000000");
        AbiBinToJsonResponse<HashMap<String, String>> abiBinToJsonResponse = request.send();
        (abiBinToJsonResponse.isError() ? System.err : System.out).println(abiBinToJsonResponse.isError() ? Arrays.toString(abiBinToJsonResponse.getError().getDetails().toArray()) : gson.toJson(abiBinToJsonResponse));
    }

    @Test
    public void getCurrencyStats() throws IOException {
        System.out.println("Start get currency stats");
        CurrencyStatsResponse currencyStatsResponse = startEOS.getCurrencyStats("eosio.token", "EOS").send();
        (currencyStatsResponse.isError() ? System.err : System.out).println(currencyStatsResponse.isError() ? Arrays.toString(currencyStatsResponse.getError().getDetails().toArray()) : gson.toJson(currencyStatsResponse));

    }

    @Test
    public void getKeyAccount() throws IOException {
        startEOS.getKeyAccounts("").rxJava()
                .subscribe(new Consumer<KeyAccountResponse>() {
                    @Override
                    public void accept(KeyAccountResponse keyAccountResponse) throws Exception {

                    }
                });

    }
}