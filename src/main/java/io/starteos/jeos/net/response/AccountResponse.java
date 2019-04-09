package io.starteos.jeos.net.response;

import java.util.List;

public class AccountResponse extends BaseResponse {

    /**
     * account_name : 11111vs22222
     * head_block_num : 32504974
     * head_block_time : 2018-12-17T03:57:05.500
     * privileged : false
     * last_code_update : 2018-12-15T01:09:06.500
     * created : 2018-06-29T14:30:06.000
     * core_liquid_balance : 188.2637 EOS
     * ram_quota : 355469
     * net_weight : 30021
     * cpu_weight : 22000021
     * net_limit : {"used":3245,"available":2418075,"max":2421320}
     * cpu_limit : {"used":7012,"available":795986,"max":802998}
     * ram_usage : 324322
     * permissions : [{"perm_name":"active","parent":"owner","required_auth":{"threshold":1,"keys":[{"key":"EOS7CRCTamVP2WtLfZgtkR5QsCKQdpaeeFsQ2rvNbRmmY56osH8Lu","weight":1}],"accounts":[{"permission":{"actor":"11111vs22222","permission":"eosio.core"},"weight":1}],"waits":[]}},{"perm_name":"owner","parent":"","required_auth":{"threshold":1,"keys":[{"key":"EOS7CRCTamVP2WtLfZgtkR5QsCKQdpaeeFsQ2rvNbRmmY56osH8Lu","weight":1}],"accounts":[],"waits":[]}}]
     * total_resources : {"owner":"11111vs22222","net_weight":"3.0021 EOS","cpu_weight":"2200.0021 EOS","ram_bytes":354069}
     * self_delegated_bandwidth : {"from":"11111vs22222","to":"11111vs22222","net_weight":"3.0021 EOS","cpu_weight":"2200.0021 EOS"}
     * refund_request : {"owner":"11111vs22222","request_time":"2018-12-16T00:04:09","net_amount":"0.0000 EOS","cpu_amount":"2000.0000 EOS"}
     * voter_info : {"owner":"11111vs22222","proxy":"starteos.io","producers":[],"staked":139035042,"last_vote_weight":"73872573430702.53125000000000000","proxied_vote_weight":"0.00000000000000000","is_proxy":0}
     */

    private String account_name;
    private long head_block_num;
    private String head_block_time;
    private boolean privileged;
    private String last_code_update;
    private String created;
    private String core_liquid_balance;
    private long ram_quota;
    private long net_weight;
    private long cpu_weight;
    private NetLimitBean net_limit;
    private CpuLimitBean cpu_limit;
    private long ram_usage;
    private TotalResourcesBean total_resources;
    private SelfDelegatedBandwidthBean self_delegated_bandwidth;
    private RefundRequestBean refund_request;
    private VoterInfoBean voter_info;
    private List<PermissionsBean> permissions;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public long getHead_block_num() {
        return head_block_num;
    }

    public void setHead_block_num(long head_block_num) {
        this.head_block_num = head_block_num;
    }

    public String getHead_block_time() {
        return head_block_time;
    }

    public void setHead_block_time(String head_block_time) {
        this.head_block_time = head_block_time;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public String getLast_code_update() {
        return last_code_update;
    }

    public void setLast_code_update(String last_code_update) {
        this.last_code_update = last_code_update;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCore_liquid_balance() {
        return core_liquid_balance;
    }

    public void setCore_liquid_balance(String core_liquid_balance) {
        this.core_liquid_balance = core_liquid_balance;
    }

    public long getRam_quota() {
        return ram_quota;
    }

    public void setRam_quota(long ram_quota) {
        this.ram_quota = ram_quota;
    }

    public long getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(long net_weight) {
        this.net_weight = net_weight;
    }

    public long getCpu_weight() {
        return cpu_weight;
    }

    public void setCpu_weight(long cpu_weight) {
        this.cpu_weight = cpu_weight;
    }

    public NetLimitBean getNet_limit() {
        return net_limit;
    }

    public void setNet_limit(NetLimitBean net_limit) {
        this.net_limit = net_limit;
    }

    public CpuLimitBean getCpu_limit() {
        return cpu_limit;
    }

    public void setCpu_limit(CpuLimitBean cpu_limit) {
        this.cpu_limit = cpu_limit;
    }

    public long getRam_usage() {
        return ram_usage;
    }

    public void setRam_usage(long ram_usage) {
        this.ram_usage = ram_usage;
    }

    public TotalResourcesBean getTotal_resources() {
        return total_resources;
    }

    public void setTotal_resources(TotalResourcesBean total_resources) {
        this.total_resources = total_resources;
    }

    public SelfDelegatedBandwidthBean getSelf_delegated_bandwidth() {
        return self_delegated_bandwidth;
    }

    public void setSelf_delegated_bandwidth(SelfDelegatedBandwidthBean self_delegated_bandwidth) {
        this.self_delegated_bandwidth = self_delegated_bandwidth;
    }

    public RefundRequestBean getRefund_request() {
        return refund_request;
    }

    public void setRefund_request(RefundRequestBean refund_request) {
        this.refund_request = refund_request;
    }

    public VoterInfoBean getVoter_info() {
        return voter_info;
    }

    public void setVoter_info(VoterInfoBean voter_info) {
        this.voter_info = voter_info;
    }

    public List<PermissionsBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionsBean> permissions) {
        this.permissions = permissions;
    }

    public static class NetLimitBean {
        /**
         * used : 3245
         * available : 2418075
         * max : 2421320
         */

        private long used;
        private long available;
        private long max;

        public long getUsed() {
            return used;
        }

        public void setUsed(long used) {
            this.used = used;
        }

        public long getAvailable() {
            return available;
        }

        public void setAvailable(long available) {
            this.available = available;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }
    }

    public static class CpuLimitBean {
        /**
         * used : 7012
         * available : 795986
         * max : 802998
         */

        private long used;
        private long available;
        private long max;

        public long getUsed() {
            return used;
        }

        public void setUsed(long used) {
            this.used = used;
        }

        public long getAvailable() {
            return available;
        }

        public void setAvailable(long available) {
            this.available = available;
        }

        public long getMax() {
            return max;
        }

        public void setMax(long max) {
            this.max = max;
        }
    }

    public static class TotalResourcesBean {
        /**
         * owner : 11111vs22222
         * net_weight : 3.0021 EOS
         * cpu_weight : 2200.0021 EOS
         * ram_bytes : 354069
         */

        private String owner;
        private String net_weight;
        private String cpu_weight;
        private long ram_bytes;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getNet_weight() {
            return net_weight;
        }

        public void setNet_weight(String net_weight) {
            this.net_weight = net_weight;
        }

        public String getCpu_weight() {
            return cpu_weight;
        }

        public void setCpu_weight(String cpu_weight) {
            this.cpu_weight = cpu_weight;
        }

        public long getRam_bytes() {
            return ram_bytes;
        }

        public void setRam_bytes(long ram_bytes) {
            this.ram_bytes = ram_bytes;
        }
    }

    public static class SelfDelegatedBandwidthBean {
        /**
         * from : 11111vs22222
         * to : 11111vs22222
         * net_weight : 3.0021 EOS
         * cpu_weight : 2200.0021 EOS
         */

        private String from;
        private String to;
        private String net_weight;
        private String cpu_weight;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getNet_weight() {
            return net_weight;
        }

        public void setNet_weight(String net_weight) {
            this.net_weight = net_weight;
        }

        public String getCpu_weight() {
            return cpu_weight;
        }

        public void setCpu_weight(String cpu_weight) {
            this.cpu_weight = cpu_weight;
        }
    }

    public static class RefundRequestBean {
        /**
         * owner : 11111vs22222
         * request_time : 2018-12-16T00:04:09
         * net_amount : 0.0000 EOS
         * cpu_amount : 2000.0000 EOS
         */

        private String owner;
        private String request_time;
        private String net_amount;
        private String cpu_amount;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getRequest_time() {
            return request_time;
        }

        public void setRequest_time(String request_time) {
            this.request_time = request_time;
        }

        public String getNet_amount() {
            return net_amount;
        }

        public void setNet_amount(String net_amount) {
            this.net_amount = net_amount;
        }

        public String getCpu_amount() {
            return cpu_amount;
        }

        public void setCpu_amount(String cpu_amount) {
            this.cpu_amount = cpu_amount;
        }
    }

    public static class VoterInfoBean {
        /**
         * owner : 11111vs22222
         * proxy : starteos.io
         * producers : []
         * staked : 139035042
         * last_vote_weight : 73872573430702.53125000000000000
         * proxied_vote_weight : 0.00000000000000000
         * is_proxy : 0
         */

        private String owner;
        private String proxy;
        private long staked;
        private String last_vote_weight;
        private String proxied_vote_weight;
        private long is_proxy;
        private List<?> producers;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getProxy() {
            return proxy;
        }

        public void setProxy(String proxy) {
            this.proxy = proxy;
        }

        public long getStaked() {
            return staked;
        }

        public void setStaked(long staked) {
            this.staked = staked;
        }

        public String getLast_vote_weight() {
            return last_vote_weight;
        }

        public void setLast_vote_weight(String last_vote_weight) {
            this.last_vote_weight = last_vote_weight;
        }

        public String getProxied_vote_weight() {
            return proxied_vote_weight;
        }

        public void setProxied_vote_weight(String proxied_vote_weight) {
            this.proxied_vote_weight = proxied_vote_weight;
        }

        public long getIs_proxy() {
            return is_proxy;
        }

        public void setIs_proxy(long is_proxy) {
            this.is_proxy = is_proxy;
        }

        public List<?> getProducers() {
            return producers;
        }

        public void setProducers(List<?> producers) {
            this.producers = producers;
        }
    }

    public static class PermissionsBean {
        /**
         * perm_name : active
         * parent : owner
         * required_auth : {"threshold":1,"keys":[{"key":"EOS7CRCTamVP2WtLfZgtkR5QsCKQdpaeeFsQ2rvNbRmmY56osH8Lu","weight":1}],"accounts":[{"permission":{"actor":"11111vs22222","permission":"eosio.core"},"weight":1}],"waits":[]}
         */

        private String perm_name;
        private String parent;
        private RequiredAuthBean required_auth;

        public String getPerm_name() {
            return perm_name;
        }

        public void setPerm_name(String perm_name) {
            this.perm_name = perm_name;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public RequiredAuthBean getRequired_auth() {
            return required_auth;
        }

        public void setRequired_auth(RequiredAuthBean required_auth) {
            this.required_auth = required_auth;
        }

        public static class RequiredAuthBean {
            /**
             * threshold : 1
             * keys : [{"key":"EOS7CRCTamVP2WtLfZgtkR5QsCKQdpaeeFsQ2rvNbRmmY56osH8Lu","weight":1}]
             * accounts : [{"permission":{"actor":"11111vs22222","permission":"eosio.core"},"weight":1}]
             * waits : []
             */

            private long threshold;
            private List<KeysBean> keys;
            private List<AccountsBean> accounts;
            private List<?> waits;

            public long getThreshold() {
                return threshold;
            }

            public void setThreshold(long threshold) {
                this.threshold = threshold;
            }

            public List<KeysBean> getKeys() {
                return keys;
            }

            public void setKeys(List<KeysBean> keys) {
                this.keys = keys;
            }

            public List<AccountsBean> getAccounts() {
                return accounts;
            }

            public void setAccounts(List<AccountsBean> accounts) {
                this.accounts = accounts;
            }

            public List<?> getWaits() {
                return waits;
            }

            public void setWaits(List<?> waits) {
                this.waits = waits;
            }

            public static class KeysBean {
                /**
                 * key : EOS7CRCTamVP2WtLfZgtkR5QsCKQdpaeeFsQ2rvNbRmmY56osH8Lu
                 * weight : 1
                 */

                private String key;
                private long weight;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public long getWeight() {
                    return weight;
                }

                public void setWeight(long weight) {
                    this.weight = weight;
                }
            }

            public static class AccountsBean {
                /**
                 * permission : {"actor":"11111vs22222","permission":"eosio.core"}
                 * weight : 1
                 */

                private PermissionBean permission;
                private long weight;

                public PermissionBean getPermission() {
                    return permission;
                }

                public void setPermission(PermissionBean permission) {
                    this.permission = permission;
                }

                public long getWeight() {
                    return weight;
                }

                public void setWeight(long weight) {
                    this.weight = weight;
                }

                public static class PermissionBean {
                    /**
                     * actor : 11111vs22222
                     * permission : eosio.core
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
