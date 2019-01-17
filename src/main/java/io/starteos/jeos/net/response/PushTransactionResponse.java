package io.starteos.jeos.net.response;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

public class PushTransactionResponse extends BaseResponse {

    /**
     * transaction_id : c0e4b4da74a74b69c734b425e0c2ab331aba5e32a0a7df83cde37a04479e31c6
     * processed : {"id":"c0e4b4da74a74b69c734b425e0c2ab331aba5e32a0a7df83cde37a04479e31c6","block_num":2438915,"block_time":"2018-12-18T09:49:59.000","receipt":{"status":"executed","cpu_usage_us":1848,"net_usage_words":17},"elapsed":1848,"net_usage":136,"scheduled":false}
     */

    private String transaction_id;
    private ProcessedBean processed;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public ProcessedBean getProcessed() {
        return processed;
    }

    public void setProcessed(ProcessedBean processed) {
        this.processed = processed;
    }

    public static class ProcessedBean {
        /**
         * id : c0e4b4da74a74b69c734b425e0c2ab331aba5e32a0a7df83cde37a04479e31c6
         * block_num : 2438915
         * block_time : 2018-12-18T09:49:59.000
         * receipt : {"status":"executed","cpu_usage_us":1848,"net_usage_words":17}
         * elapsed : 1848
         * net_usage : 136
         * scheduled : false
         */

        private String id;
        private long block_num;
        private String block_time;
        private ReceiptBean receipt;
        private long elapsed;
        private long net_usage;
        private boolean scheduled;
        private List<Traces> action_traces;

        public List<Traces> getAction_traces() {
            return action_traces;
        }

        public void setAction_traces(List<Traces> action_traces) {
            this.action_traces = action_traces;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public long getBlock_num() {
            return block_num;
        }

        public void setBlock_num(long block_num) {
            this.block_num = block_num;
        }

        public String getBlock_time() {
            return block_time;
        }

        public void setBlock_time(String block_time) {
            this.block_time = block_time;
        }

        public ReceiptBean getReceipt() {
            return receipt;
        }

        public void setReceipt(ReceiptBean receipt) {
            this.receipt = receipt;
        }

        public long getElapsed() {
            return elapsed;
        }

        public void setElapsed(long elapsed) {
            this.elapsed = elapsed;
        }

        public long getNet_usage() {
            return net_usage;
        }

        public void setNet_usage(long net_usage) {
            this.net_usage = net_usage;
        }

        public boolean isScheduled() {
            return scheduled;
        }

        public void setScheduled(boolean scheduled) {
            this.scheduled = scheduled;
        }

        public static class ReceiptBean {
            /**
             * status : executed
             * cpu_usage_us : 1848
             * net_usage_words : 17
             */

            private String status;
            private long cpu_usage_us;
            private long net_usage_words;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public long getCpu_usage_us() {
                return cpu_usage_us;
            }

            public void setCpu_usage_us(long cpu_usage_us) {
                this.cpu_usage_us = cpu_usage_us;
            }

            public long getNet_usage_words() {
                return net_usage_words;
            }

            public void setNet_usage_words(long net_usage_words) {
                this.net_usage_words = net_usage_words;
            }
        }

        public static class Traces {

            /**
             * receipt : {"receiver":"eosio.token","act_digest":"99ef0c6e1c405168173b13195619b629c2aa8c78bae3a6967a225ae302007cf7","global_sequence":2439391,"recv_sequence":125,"auth_sequence":[["eosio",2439084]],"code_sequence":1,"abi_sequence":1}
             * act : {"account":"eosio.token","name":"transfer","authorization":[{"actor":"eosio","permission":"active"}],"data":{"from":"eosio","to":"contract.e","quantity":"0.0001 EOS","memo":"qqqq"},"hex_data":"0000000000ea305500800219999b2745010000000000000004454f53000000000471717171"}
             * context_free : false
             * elapsed : 299
             * console :
             * trx_id : c0e4b4da74a74b69c734b425e0c2ab331aba5e32a0a7df83cde37a04479e31c6
             * block_num : 2438915
             * block_time : 2018-12-18T09:49:59.000
             * account_ram_deltas : []
             */

            private ReceiptBean receipt;
            private Act act;
            private boolean context_free;
            private long elapsed;
            private String console;
            private String trx_id;
            private long block_num;
            private String block_time;
            private List<?> account_ram_deltas;
            private List<Traces> inline_traces;

            public ReceiptBean getReceipt() {
                return receipt;
            }

            public void setReceipt(ReceiptBean receipt) {
                this.receipt = receipt;
            }

            public Act getAct() {
                return act;
            }

            public void setAct(Act act) {
                this.act = act;
            }

            public boolean isContext_free() {
                return context_free;
            }

            public void setContext_free(boolean context_free) {
                this.context_free = context_free;
            }

            public long getElapsed() {
                return elapsed;
            }

            public void setElapsed(long elapsed) {
                this.elapsed = elapsed;
            }

            public String getConsole() {
                return console;
            }

            public void setConsole(String console) {
                this.console = console;
            }

            public String getTrx_id() {
                return trx_id;
            }

            public void setTrx_id(String trx_id) {
                this.trx_id = trx_id;
            }

            public long getBlock_num() {
                return block_num;
            }

            public void setBlock_num(long block_num) {
                this.block_num = block_num;
            }

            public String getBlock_time() {
                return block_time;
            }

            public void setBlock_time(String block_time) {
                this.block_time = block_time;
            }

            public List<?> getAccount_ram_deltas() {
                return account_ram_deltas;
            }

            public void setAccount_ram_deltas(List<?> account_ram_deltas) {
                this.account_ram_deltas = account_ram_deltas;
            }

            public List<Traces> getInline_traces() {
                return inline_traces;
            }

            public void setInline_traces(List<Traces> inline_traces) {
                this.inline_traces = inline_traces;
            }

            public static class ReceiptBean {
                /**
                 * receiver : eosio.token
                 * act_digest : 99ef0c6e1c405168173b13195619b629c2aa8c78bae3a6967a225ae302007cf7
                 * global_sequence : 2439391
                 * recv_sequence : 125
                 * auth_sequence : [["eosio",2439084]]
                 * code_sequence : 1
                 * abi_sequence : 1
                 */

                private String receiver;
                private String act_digest;
                private long global_sequence;
                private long recv_sequence;
                private long code_sequence;
                private long abi_sequence;
                private List<List<String>> auth_sequence;

                public String getReceiver() {
                    return receiver;
                }

                public void setReceiver(String receiver) {
                    this.receiver = receiver;
                }

                public String getAct_digest() {
                    return act_digest;
                }

                public void setAct_digest(String act_digest) {
                    this.act_digest = act_digest;
                }

                public long getGlobal_sequence() {
                    return global_sequence;
                }

                public void setGlobal_sequence(long global_sequence) {
                    this.global_sequence = global_sequence;
                }

                public long getRecv_sequence() {
                    return recv_sequence;
                }

                public void setRecv_sequence(long recv_sequence) {
                    this.recv_sequence = recv_sequence;
                }

                public long getCode_sequence() {
                    return code_sequence;
                }

                public void setCode_sequence(long code_sequence) {
                    this.code_sequence = code_sequence;
                }

                public long getAbi_sequence() {
                    return abi_sequence;
                }

                public void setAbi_sequence(long abi_sequence) {
                    this.abi_sequence = abi_sequence;
                }

                public List<List<String>> getAuth_sequence() {
                    return auth_sequence;
                }

                public void setAuth_sequence(List<List<String>> auth_sequence) {
                    this.auth_sequence = auth_sequence;
                }
            }
            public static class Act{

                /**
                 * account : eosio.token
                 * name : transfer
                 * authorization : [{"actor":"eosio","permission":"active"}]
                 * data : {"from":"eosio","to":"contract.e","quantity":"0.0001 EOS","memo":"qqqq"}
                 * hex_data : 0000000000ea305500800219999b2745010000000000000004454f53000000000471717171
                 */

                private String account;
                private String name;
                private JsonElement data;
                private String hex_data;
                private List<AuthorizationBean> authorization;

                public String getAccount() {
                    return account;
                }

                public void setAccount(String account) {
                    this.account = account;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public JsonElement getData() {
                    return data;
                }

                public void setData(JsonElement data) {
                    this.data = data;
                }

                public String getHex_data() {
                    return hex_data;
                }

                public void setHex_data(String hex_data) {
                    this.hex_data = hex_data;
                }

                public List<AuthorizationBean> getAuthorization() {
                    return authorization;
                }

                public void setAuthorization(List<AuthorizationBean> authorization) {
                    this.authorization = authorization;
                }



                public static class AuthorizationBean {
                    /**
                     * actor : eosio
                     * permission : active
                     */

                    private String actor;
                    private String permission;

                    public String getActor() {
                        return actor;
                    }

                    public void setActor(String actor) {
                        this.actor = actor;
                    }

                    public String getPermission() {
                        return permission;
                    }

                    public void setPermission(String permission) {
                        this.permission = permission;
                    }
                }
            }

        }
    }
}
