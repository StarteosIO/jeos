package io.starteos.jeos.net.response;

import java.util.List;

public class AbiResponse extends BaseResponse {

    /**
     * account_name : eosio.token
     * abi : {"version":"eosio::abi/1.0","types":[{"new_type_name":"account_name","type":"name"}],"structs":[{"name":"transfer","base":"","fields":[{"name":"from","type":"account_name"},{"name":"to","type":"account_name"},{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"create","base":"","fields":[{"name":"issuer","type":"account_name"},{"name":"maximum_supply","type":"asset"}]},{"name":"issue","base":"","fields":[{"name":"to","type":"account_name"},{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"retire","base":"","fields":[{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"close","base":"","fields":[{"name":"owner","type":"account_name"},{"name":"symbol","type":"symbol"}]},{"name":"account","base":"","fields":[{"name":"balance","type":"asset"}]},{"name":"currency_stats","base":"","fields":[{"name":"supply","type":"asset"},{"name":"max_supply","type":"asset"},{"name":"issuer","type":"account_name"}]}],"actions":[{"name":"transfer","type":"transfer","ricardian_contract":"## Transfer Terms & Conditions\n\nI, {{from}}, certify the following to be true to the best of my knowledge:\n\n1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\n2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\n3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\n\nI understand that funds transfers are not reversible after the {{transaction.delay}} seconds or other delay as configured by {{from}}'s permissions.\n\nIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\n"},{"name":"issue","type":"issue","ricardian_contract":""},{"name":"create","type":"create","ricardian_contract":""},{"name":"retire","type":"retire","ricardian_contract":""},{"name":"close","type":"close","ricardian_contract":""}],"tables":[{"name":"accounts","index_type":"i64","key_names":["currency"],"key_types":["uint64"],"type":"account"},{"name":"stat","index_type":"i64","key_names":["currency"],"key_types":["uint64"],"type":"currency_stats"}],"ricardian_clauses":[],"error_messages":[],"abi_extensions":[],"variants":[]}
     */

    private String account_name;
    private AbiBean abi;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public AbiBean getAbi() {
        return abi;
    }

    public void setAbi(AbiBean abi) {
        this.abi = abi;
    }

    public static class AbiBean {
        /**
         * version : eosio::abi/1.0
         * types : [{"new_type_name":"account_name","type":"name"}]
         * structs : [{"name":"transfer","base":"","fields":[{"name":"from","type":"account_name"},{"name":"to","type":"account_name"},{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"create","base":"","fields":[{"name":"issuer","type":"account_name"},{"name":"maximum_supply","type":"asset"}]},{"name":"issue","base":"","fields":[{"name":"to","type":"account_name"},{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"retire","base":"","fields":[{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]},{"name":"close","base":"","fields":[{"name":"owner","type":"account_name"},{"name":"symbol","type":"symbol"}]},{"name":"account","base":"","fields":[{"name":"balance","type":"asset"}]},{"name":"currency_stats","base":"","fields":[{"name":"supply","type":"asset"},{"name":"max_supply","type":"asset"},{"name":"issuer","type":"account_name"}]}]
         * actions : [{"name":"transfer","type":"transfer","ricardian_contract":"## Transfer Terms & Conditions\n\nI, {{from}}, certify the following to be true to the best of my knowledge:\n\n1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.\n2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.\n3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.\n\nI understand that funds transfers are not reversible after the {{transaction.delay}} seconds or other delay as configured by {{from}}'s permissions.\n\nIf this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.\n"},{"name":"issue","type":"issue","ricardian_contract":""},{"name":"create","type":"create","ricardian_contract":""},{"name":"retire","type":"retire","ricardian_contract":""},{"name":"close","type":"close","ricardian_contract":""}]
         * tables : [{"name":"accounts","index_type":"i64","key_names":["currency"],"key_types":["uint64"],"type":"account"},{"name":"stat","index_type":"i64","key_names":["currency"],"key_types":["uint64"],"type":"currency_stats"}]
         * ricardian_clauses : []
         * error_messages : []
         * abi_extensions : []
         * variants : []
         */

        private String version;
        private List<TypesBean> types;
        private List<StructsBean> structs;
        private List<ActionsBean> actions;
        private List<TablesBean> tables;
        private List<?> ricardian_clauses;
        private List<?> error_messages;
        private List<?> abi_extensions;
        private List<?> variants;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public List<TypesBean> getTypes() {
            return types;
        }

        public void setTypes(List<TypesBean> types) {
            this.types = types;
        }

        public List<StructsBean> getStructs() {
            return structs;
        }

        public void setStructs(List<StructsBean> structs) {
            this.structs = structs;
        }

        public List<ActionsBean> getActions() {
            return actions;
        }

        public void setActions(List<ActionsBean> actions) {
            this.actions = actions;
        }

        public List<TablesBean> getTables() {
            return tables;
        }

        public void setTables(List<TablesBean> tables) {
            this.tables = tables;
        }

        public List<?> getRicardian_clauses() {
            return ricardian_clauses;
        }

        public void setRicardian_clauses(List<?> ricardian_clauses) {
            this.ricardian_clauses = ricardian_clauses;
        }

        public List<?> getError_messages() {
            return error_messages;
        }

        public void setError_messages(List<?> error_messages) {
            this.error_messages = error_messages;
        }

        public List<?> getAbi_extensions() {
            return abi_extensions;
        }

        public void setAbi_extensions(List<?> abi_extensions) {
            this.abi_extensions = abi_extensions;
        }

        public List<?> getVariants() {
            return variants;
        }

        public void setVariants(List<?> variants) {
            this.variants = variants;
        }

        public static class TypesBean {
            /**
             * new_type_name : account_name
             * type : name
             */

            private String new_type_name;
            private String type;

            public String getNew_type_name() {
                return new_type_name;
            }

            public void setNew_type_name(String new_type_name) {
                this.new_type_name = new_type_name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class StructsBean {
            /**
             * name : transfer
             * base :
             * fields : [{"name":"from","type":"account_name"},{"name":"to","type":"account_name"},{"name":"quantity","type":"asset"},{"name":"memo","type":"string"}]
             */

            private String name;
            private String base;
            private List<FieldsBean> fields;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBase() {
                return base;
            }

            public void setBase(String base) {
                this.base = base;
            }

            public List<FieldsBean> getFields() {
                return fields;
            }

            public void setFields(List<FieldsBean> fields) {
                this.fields = fields;
            }

            public static class FieldsBean {
                /**
                 * name : from
                 * type : account_name
                 */

                private String name;
                private String type;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }

        public static class ActionsBean {
            /**
             * name : transfer
             * type : transfer
             * ricardian_contract : ## Transfer Terms & Conditions

             I, {{from}}, certify the following to be true to the best of my knowledge:

             1. I certify that {{quantity}} is not the proceeds of fraudulent or violent activities.
             2. I certify that, to the best of my knowledge, {{to}} is not supporting initiation of violence against others.
             3. I have disclosed any contractual terms & conditions with respect to {{quantity}} to {{to}}.

             I understand that funds transfers are not reversible after the {{transaction.delay}} seconds or other delay as configured by {{from}}'s permissions.

             If this action fails to be irreversibly confirmed after receiving goods or services from '{{to}}', I agree to either return the goods or services or resend {{quantity}} in a timely manner.

             */

            private String name;
            private String type;
            private String ricardian_contract;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRicardian_contract() {
                return ricardian_contract;
            }

            public void setRicardian_contract(String ricardian_contract) {
                this.ricardian_contract = ricardian_contract;
            }
        }

        public static class TablesBean {
            /**
             * name : accounts
             * index_type : i64
             * key_names : ["currency"]
             * key_types : ["uint64"]
             * type : account
             */

            private String name;
            private String index_type;
            private String type;
            private List<String> key_names;
            private List<String> key_types;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIndex_type() {
                return index_type;
            }

            public void setIndex_type(String index_type) {
                this.index_type = index_type;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<String> getKey_names() {
                return key_names;
            }

            public void setKey_names(List<String> key_names) {
                this.key_names = key_names;
            }

            public List<String> getKey_types() {
                return key_types;
            }

            public void setKey_types(List<String> key_types) {
                this.key_types = key_types;
            }
        }
    }
}
