package io.starteos.jeos.net.core;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import io.starteos.jeos.net.StartEOS;
import io.starteos.jeos.net.protocol.StartService;
import io.starteos.jeos.net.request.AbiBinToJsonRequest;
import io.starteos.jeos.net.request.AbiInfoRequest;
import io.starteos.jeos.net.request.AbiJsonToBinRequest;
import io.starteos.jeos.net.request.AccountInfoRequest;
import io.starteos.jeos.net.request.BalanceRequest;
import io.starteos.jeos.net.request.BlockHeaderStateRequest;
import io.starteos.jeos.net.request.BlockInfoRequest;
import io.starteos.jeos.net.request.CurrencyStatsRequest;
import io.starteos.jeos.net.request.KeyAccountRequest;
import io.starteos.jeos.net.request.ProducersRequest;
import io.starteos.jeos.net.request.PushTransactionRequest;
import io.starteos.jeos.net.request.RawAbiAndCodeRequest;
import io.starteos.jeos.net.request.RequiredKeysRequest;
import io.starteos.jeos.net.request.TableRowsByScopeRequest;
import io.starteos.jeos.net.request.TableRowsRequest;
import io.starteos.jeos.net.response.AbiBinToJsonResponse;
import io.starteos.jeos.net.response.AbiJsonToBinResponse;
import io.starteos.jeos.net.response.AbiResponse;
import io.starteos.jeos.net.response.AccountResponse;
import io.starteos.jeos.net.response.BalanceResponse;
import io.starteos.jeos.net.response.BaseResponse;
import io.starteos.jeos.net.response.BlockHeaderStateResponse;
import io.starteos.jeos.net.response.BlockResponse;
import io.starteos.jeos.net.response.CurrencyStatsResponse;
import io.starteos.jeos.net.response.InfoResponse;
import io.starteos.jeos.net.response.KeyAccountResponse;
import io.starteos.jeos.net.response.ProducersResponse;
import io.starteos.jeos.net.response.PushTransactionResponse;
import io.starteos.jeos.net.response.RawAbiAndCodeResponse;
import io.starteos.jeos.net.response.RequiredKeysResponse;
import io.starteos.jeos.net.response.TableRowsByScopeResponse;
import io.starteos.jeos.net.response.TableRowsResponse;
import io.starteos.jeos.transaction.PackedTransaction;

public class Json_Start implements StartEOS {

    protected final StartService startService;
    private final ScheduledExecutorService scheduledExecutorService;

    public Json_Start(StartService startService) {
        this(startService, null);
    }

    public Json_Start(StartService startService, ScheduledExecutorService scheduledExecutorService) {
        this.startService = startService;
        this.scheduledExecutorService = scheduledExecutorService == null ? Async.defaultExecutorService() : scheduledExecutorService;
    }

    @Override
    public Request<?, InfoResponse> info() {
        return new Request<>(startService, null, InfoResponse.class, "/v1/chain/get_info");
    }

    @Override
    public Request<BlockInfoRequest, BlockResponse> block(String block_num_or_id) {
        return new Request<>(startService, new BlockInfoRequest(block_num_or_id), BlockResponse.class, "/v1/chain/get_block");
    }

    @Override
    public Request<AccountInfoRequest, AccountResponse> accountInfo(String accountName) {
        return new Request<>(startService, new AccountInfoRequest(accountName), AccountResponse.class, "/v1/chain/get_account");
    }

    @Override
    public Request<AbiInfoRequest, AbiResponse> abiInfo(String contract_name) {
        return new Request<>(startService, new AbiInfoRequest(contract_name), AbiResponse.class, "/v1/chain/get_abi");
    }

    @Override
    public Request<RawAbiAndCodeRequest, RawAbiAndCodeResponse> rawAbiAndCode(String contract_name) {
        return new Request<>(startService, new RawAbiAndCodeRequest(contract_name), RawAbiAndCodeResponse.class, "/v1/chain/get_raw_code_and_abi");
    }

    @Override
    public <T> Request<TableRowsRequest, TableRowsResponse<T>> tableRow(String scope, String code, String table, HashMap<String, Object> params) {
        TableRowsRequest tableRowsRequest = new TableRowsRequest(scope, code, table);
        if (params != null) {
            for (String s : params.keySet()) {
                try {
                    String first = String.valueOf(s.charAt(0));
                    Method method = tableRowsRequest.getClass().getMethod("set" + s.replaceFirst(first, first.toUpperCase()), Preconditions.checkNotNull(params.get(s)).getClass());
                    method.invoke(tableRowsRequest, params.get(s));
                } catch (NoSuchMethodException ignored) {
                } catch (IllegalAccessException ignored) {
                } catch (InvocationTargetException ignored) {
                } catch (NullPointerException ignored) {
                }
            }
        }
        TableRowsResponse<?> tTableRowsResponse = new TableRowsResponse<>();
        return (Request<TableRowsRequest, TableRowsResponse<T>>) new Request<>(startService, tableRowsRequest, tTableRowsResponse.getClass(), "/v1/chain/get_table_rows");
    }

    @Override
    public Request<BalanceRequest, BalanceResponse> balance(final String code, final String account, final String symbol) {
        Request<BalanceRequest, BalanceResponse> requestBalanceResponseRequest = new Request<>(startService, new BalanceRequest(code, account, symbol), BalanceResponse.class, "/v1/chain/get_currency_balance");
        requestBalanceResponseRequest.setCallBack(new Request.CallBack<BalanceResponse>() {
            @Override
            public BalanceResponse format(String data, Gson gson) {
                BalanceResponse balanceResponse = null;
                JsonElement j = new JsonParser().parse(data);
                if (j.isJsonObject() && j.getAsJsonObject().has("core")) {
                    balanceResponse = gson.fromJson(data, BalanceResponse.class);
                    balanceResponse.setAccount(account);
                    balanceResponse.setCode(code);
                    balanceResponse.setSymbol(symbol);
                    balanceResponse.setData(new ArrayList<String>());
                    return balanceResponse;
                }
                List<String> arr = gson.fromJson(data, new TypeToken<List<String>>() {
                }.getType());
                if (arr.isEmpty()) {
                    arr.add("0.0000 " + symbol);
                }
                balanceResponse = new BalanceResponse(code, account, symbol, arr);
                return balanceResponse;
            }
        });
        return requestBalanceResponseRequest;
    }

    @Override
    public Request<BlockHeaderStateRequest, BlockHeaderStateResponse> blockHeaderState(String block_num_or_id) {
        return new Request<>(startService, new BlockHeaderStateRequest(block_num_or_id), BlockHeaderStateResponse.class, "/v1/chain/get_block_header_state");
    }

    @Override
    public Request<TableRowsByScopeRequest, TableRowsByScopeResponse> tableRowsByScope(String code, HashMap<String, Object> params) {
        TableRowsByScopeRequest tableRowsByScopeRequest = new TableRowsByScopeRequest(code);
        if (params != null) {
            for (String s : params.keySet()) {
                try {
                    String first = String.valueOf(s.charAt(0));
                    Method method = tableRowsByScopeRequest.getClass().getMethod("set" + s.replaceFirst(first, first.toUpperCase()), Preconditions.checkNotNull(params.get(s).getClass()));
                    method.invoke(tableRowsByScopeRequest, params.get(s));
                } catch (NoSuchMethodException ignored) {
                } catch (IllegalAccessException ignored) {
                } catch (InvocationTargetException ignored) {
                } catch (NullPointerException ignored) {
                }
            }
        }
        return new Request<>(startService, tableRowsByScopeRequest, TableRowsByScopeResponse.class, "/v1/chain/get_table_by_scope");
    }

    @Override
    public Request<AbiJsonToBinRequest, AbiJsonToBinResponse> abiJsonToBin(String code, String action, Object args) {
        AbiJsonToBinRequest<Object> abiJsonToBinRequest = new AbiJsonToBinRequest<>(code, action, args);
        return new Request<AbiJsonToBinRequest, AbiJsonToBinResponse>(startService, abiJsonToBinRequest, AbiJsonToBinResponse.class, "/v1/chain/abi_json_to_bin");
    }


    @Override
    public <T> Request<AbiBinToJsonRequest, AbiBinToJsonResponse<T>> abiBinToJson(String code, String action, String binargs) {
        AbiBinToJsonResponse<T> res = new AbiBinToJsonResponse<>();
        return (Request<AbiBinToJsonRequest, AbiBinToJsonResponse<T>>) new Request<>(startService, new AbiBinToJsonRequest(code, action, binargs), res.getClass(), "/v1/chain/abi_bin_to_json");
    }

    @Override
    public Request<RequiredKeysRequest, RequiredKeysResponse> getRequiredKeys(String transaction, List<String> available_keys) {
        JsonElement jsonElement = new JsonParser().parse(transaction);
        Preconditions.checkArgument(jsonElement.isJsonObject(), "transaction is not jsonObject");
        Request<RequiredKeysRequest, RequiredKeysResponse> request = new Request<>(startService, new RequiredKeysRequest(jsonElement, available_keys), RequiredKeysResponse.class, "/v1/chain/get_required_keys");
        request.setCallBack(new Request.CallBack<RequiredKeysResponse>() {
            @Override
            public RequiredKeysResponse format(String data, Gson gson) {
                RequiredKeysResponse requiredKeysResponse = null;
//                JsonElement j = new JsonParser().parse(data);
//                if (j.isJsonObject() && j.getAsJsonObject().has("required_keys")) {
//                    requiredKeysResponse = gson.fromJson(data, RequiredKeysResponse.class);
//                    requiredKeysResponse.setAvailable_keys(new ArrayList<String>());
//                    return requiredKeysResponse;
//                }
                requiredKeysResponse = gson.fromJson(data,RequiredKeysResponse.class);
                return requiredKeysResponse;
            }
        });
        return request;
    }

    @Override
    public Request<CurrencyStatsRequest, CurrencyStatsResponse> getCurrencyStats(String code, final String symbol) {
        Request<CurrencyStatsRequest, CurrencyStatsResponse> request = new Request<>(startService, new CurrencyStatsRequest(code, symbol), CurrencyStatsResponse.class, "/v1/chain/get_currency_stats");
        request.setCallBack(new Request.CallBack<CurrencyStatsResponse>() {
            @Override
            public CurrencyStatsResponse format(String data, Gson gson) {
                JsonElement jsonElement = new JsonParser().parse(data);
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has(symbol) && jsonObject.get(symbol).isJsonObject()) {
                        String tempData = jsonObject.getAsJsonObject(symbol).toString();
                        return gson.fromJson(tempData, CurrencyStatsResponse.class);
                    }
                }
                CurrencyStatsResponse currencyStatsResponse = new CurrencyStatsResponse();
                currencyStatsResponse.setMessage("data null");
                BaseResponse.ErrorBean errorBean = new BaseResponse.ErrorBean();
                errorBean.setDetails(new ArrayList<BaseResponse.ErrorBean.DetailsBean>());
                currencyStatsResponse.setError(errorBean);
                return currencyStatsResponse;
            }
        });
        return request;
    }

    @Override
    public Request<ProducersRequest, ProducersResponse> getProducers(String limit, String lower_bound) {
        return new Request<>(startService, new ProducersRequest(limit, lower_bound), ProducersResponse.class, "/v1/chain/get_producers");
    }

    @Override
    public Request<PushTransactionRequest, PushTransactionResponse> pushTransaction(PackedTransaction packedTransaction) {
        return pushTransaction(packedTransaction.getSignatures(), packedTransaction.getCompression(), packedTransaction.getPacked_context_free_data(), packedTransaction.getPacked_trx());
    }

    @Override
    public Request<PushTransactionRequest, PushTransactionResponse> pushTransaction(List<String> signatures, String compression, String packed_context_free_data, String packed_trx) {
        return new Request<>(startService, new PushTransactionRequest(signatures, compression, packed_context_free_data, packed_trx), PushTransactionResponse.class, "/v1/chain/push_transaction");
    }

    @Override
    public Request<KeyAccountRequest, KeyAccountResponse> getKeyAccounts(String public_key) {
        return new Request<>(startService, new KeyAccountRequest(public_key), KeyAccountResponse.class, "/v1/history/get_key_accounts");
    }
}
