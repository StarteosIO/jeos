package io.starteos.jeos.net.protocol;

import java.util.HashMap;
import java.util.List;

import io.starteos.jeos.net.core.Request;
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

public interface Start {

    Request<?, InfoResponse> info();

    Request<BlockInfoRequest, BlockResponse> block(String block_num_or_id);

    Request<AccountInfoRequest, AccountResponse> accountInfo(String account_name);

    Request<AbiInfoRequest, AbiResponse> abiInfo(String contract_name);

    Request<RawAbiAndCodeRequest, RawAbiAndCodeResponse> rawAbiAndCode(String contract_name);

    <T> Request<TableRowsRequest, TableRowsResponse<T>> tableRow(String scope, String code, String table, HashMap<String, Object> params);

    Request<BalanceRequest, BalanceResponse> balance(String code, String account, String symbol);

    Request<BlockHeaderStateRequest, BlockHeaderStateResponse> blockHeaderState(String block_num_or_id);

    Request<TableRowsByScopeRequest, TableRowsByScopeResponse> tableRowsByScope(String code, HashMap<String, Object> params);

    Request<AbiJsonToBinRequest, AbiJsonToBinResponse> abiJsonToBin(String code, String action, Object args);

    <T> Request<AbiBinToJsonRequest, AbiBinToJsonResponse<T>> abiBinToJson(String code, String action, String binargs);

    Request<RequiredKeysRequest, RequiredKeysResponse> getRequiredKeys(String transaction, List<String> available_keys);

    Request<CurrencyStatsRequest, CurrencyStatsResponse> getCurrencyStats(String code, String symbol);

    Request<ProducersRequest, ProducersResponse> getProducers(String limit, String lower_bound);

    Request<PushTransactionRequest, PushTransactionResponse> pushTransaction(PackedTransaction packedTransaction);

    Request<PushTransactionRequest, PushTransactionResponse> pushTransaction(List<String> signatures, String compression, String packed_context_free_data, String packed_trx);

    Request<KeyAccountRequest, KeyAccountResponse> getKeyAccounts(String public_key);
}
