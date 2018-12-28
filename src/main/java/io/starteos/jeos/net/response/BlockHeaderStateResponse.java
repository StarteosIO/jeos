package io.starteos.jeos.net.response;

import java.util.List;

public class BlockHeaderStateResponse extends BaseResponse {

    /**
     * id : 01f2665291d8c8d299e8e4f2e8ce550bdb59091afa736110cc7c370cbf15ac6f
     * block_num : 32663122
     * header : {"timestamp":"2018-12-18T01:59:21.000","producer":"zbeosbp11111","confirmed":0,"previous":"01f26651fa10fe3a1c2c3f7553fbf7b539a62210315dbb1c66739d8ad82a1a95","transaction_mroot":"b8c364cbf21f89e5ed5dcac42d4dc5d82c07733137b50bacabb1d22380f045d4","action_mroot":"f5d284a8d9e786e9f3639c60ac72fca2dc5b48d944b2d0930de5e51be33e2d01","schedule_version":594,"header_extensions":[],"producer_signature":"SIG_K1_KWjub2qeuyHyboghk6Ax1TSdop7SLJv6A2PrAcBdQkUMgrkwzcMtCF27HM489Dhqaq2gTpDDQA5bag7pw7QJXFx3TTX9rt"}
     * dpos_proposed_irreversible_blocknum : 32662962
     * dpos_irreversible_blocknum : 32662794
     * bft_irreversible_blocknum : 0
     * pending_schedule_lib_num : 32623454
     * pending_schedule_hash : ec73483b94574400077e235bbf4ed076243eb28c13d0adcdc9d580bd68bbfa6e
     * pending_schedule : {"version":594,"producers":[]}
     * active_schedule : {"version":594,"producers":[{"producer_name":"atticlabeosb","block_signing_key":"EOS7u1N2MuJj3BVTBgyb8BT3oQ41NNLHuaxcbGuYU6uuNBh1KUPck"},{"producer_name":"bitfinexeos1","block_signing_key":"EOS4tkw7LgtURT3dvG3kQ4D1sg3aAtPDymmoatpuFkQMc7wzZdKxc"},{"producer_name":"cochainworld","block_signing_key":"EOS5QDSQyh96SmktA28dteEchc1QCVdqKYG4YVDHGGATMYxqy33wi"},{"producer_name":"eos42freedom","block_signing_key":"EOS4tw7vH62TcVtMgm2tjXzn9hTuHEBbGPUK2eos42ssY7ip4LTzu"},{"producer_name":"eosauthority","block_signing_key":"EOS4va3CTmAcAAXsT26T3EBWqYHgQLshyxsozYRgxWm9tjmy17pVV"},{"producer_name":"eosbeijingbp","block_signing_key":"EOS5dGpcEhwB4VEhhXEcqtZs9EQj5HeetuXDnsAGVHMXHAFdMjbdj"},{"producer_name":"eosbixinboot","block_signing_key":"EOS7QC1XfAtkYeLjbHQjcDWVqUsxuSJ3YRhNyG93VAv2u3uHopGVp"},{"producer_name":"eoscanadacom","block_signing_key":"EOS7eycxAbCtKyfoJc8uRZcmt1AmArjXcz8aonLUTzahk5rHc18NJ"},{"producer_name":"eoscannonchn","block_signing_key":"EOS73cTi9V7PNg4ujW5QzoTfRSdhH44MPiUJkUV6m3oGwj7RX7kML"},{"producer_name":"eosdacserver","block_signing_key":"EOS6VkageCqyz1X97n7E1JyjPoZu8HEX6CVujY5ABzk3fPyV3vzZK"},{"producer_name":"eosflytomars","block_signing_key":"EOS6Agpfp38bTyRjJDmB4Qb1EpQSq7wnEAsALXgXE7KFSzKjokkFD"},{"producer_name":"eoshuobipool","block_signing_key":"EOS5XKswW26cR5VQeDGwgNb5aixv1AMcKkdDNrC59KzNSBfnH6TR7"},{"producer_name":"eoslaomaocom","block_signing_key":"EOS8QgURqo875qu3a8vgZ58qBeu2cTehe9zAWRfpdCXAQipicu1Fi"},{"producer_name":"eosliquideos","block_signing_key":"EOS4v1n2j5kXbCum8LLEc8zQLpeLK9rKVFmsUgLCWgMDN38P6PcrW"},{"producer_name":"eosnationftw","block_signing_key":"EOS8PkNNBYU1xnbcjBUNm1mT6N68QiGvCDgPT97rqurLBEjDanSXK"},{"producer_name":"eosnewyorkio","block_signing_key":"EOS6GVX8eUqC1gN1293B3ivCNbifbr1BT6gzTFaQBXzWH9QNKVM4X"},{"producer_name":"eosriobrazil","block_signing_key":"EOS7RioGoHQnhv2fJEiciP9Q7J8JgfJYFcyofVkmCqMop8Q1PzgqP"},{"producer_name":"eosswedenorg","block_signing_key":"EOS7SGSBsWhSob6TEric6u3TGodcc1uXFcqSrquJ3Etuqcbb3VnNY"},{"producer_name":"jedaaaaaaaaa","block_signing_key":"EOS6nB9Ar5sghWjqk27bszCiA9zxQtXZCaAaEkf2nwUm9iP5MEJTT"},{"producer_name":"starteosiobp","block_signing_key":"EOS4wZZXm994byKANLuwHD6tV3R3Mu3ktc41aSVXCBaGnXJZJ4pwF"},{"producer_name":"zbeosbp11111","block_signing_key":"EOS7rhgVPWWyfMqjSbNdndtCK8Gkza3xnDbUupsPLMZ6gjfQ4nX81"}]}
     * blockroot_merkle : {"_active_nodes":["01f26651fa10fe3a1c2c3f7553fbf7b539a62210315dbb1c66739d8ad82a1a95","6eed13a22cee06b56449142f0b091bc76cb8a4456b85f82786d89ca4d681c35f","410878d1ec5a5ab3bfb6635db9a69b7b306fb0bf6799280275ec64885211e740","7b74e9128663654044052ee19028314e0e5f1e1568021865efd3c16e2413012a","f03fe60c3dfc4495cd10fd98e0ab43320098ba3f3b2cb396f9a396bcf741c9ef","3970b5f35e55c6c7c3327a407a57d8ad38cf119a5676c333f9128eb14b32af26","8991e467cec1cf1be6eb5e1cff8d4e757a02952d5413367d9a6909b5b70bc6d7","0367e35546f36c160aaa83dda2a8f3fd7db39c544ffba35d31ff55b73749606f","7299b85b9f0ea346cfa1a192f172f253a4387f0bf5f2edc6a579d21777f172e7","f3f8edbcfdc8eaaa29a81d1971872be90550fd499a9da9f7b2f3aae40608bf5c","c3e7ef17b6e1ad90f2363e5b4a107890d928850cf52d80ebaac9300558cf0a15","e19c967daaa989d236da04373355638a6411fa182966bed2e7b9dc5e478c659e","630857f9168c33e6063dd00ab3ad49d57f08b44175a70e07b66a63bc6d0f991e","889fa1864fdea73752b51afd50e33ee807821b555da3b107740c3c1bce32cad8"],"_node_count":32663121}
     * producer_to_last_produced : [["atticlabeosb",32662890],["bitfinexeos1",32662902],["cochainworld",32662914],["eos42freedom",32662926],["eosauthority",32662938],["eosbeijingbp",32662950],["eosbixinboot",32662962],["eoscanadacom",32662974],["eoscannonchn",32662986],["eosdacserver",32662998],["eosflytomars",32663010],["eoshuobipool",32663021],["eoslaomaocom",32663031],["eosliquideos",32663043],["eosnationftw",32663055],["eosnewyorkio",32663067],["eosriobrazil",32663079],["eosswedenorg",32663091],["jedaaaaaaaaa",32663103],["starteosiobp",32663115],["zbeosbp11111",32663122]]
     * producer_to_last_implied_irb : [["atticlabeosb",32662723],["bitfinexeos1",32662735],["cochainworld",32662747],["eos42freedom",32662759],["eosauthority",32662770],["eosbeijingbp",32662782],["eosbixinboot",32662794],["eoscanadacom",32662806],["eoscannonchn",32662818],["eosdacserver",32662830],["eosflytomars",32662842],["eoshuobipool",32662854],["eoslaomaocom",32662866],["eosliquideos",32662878],["eosnationftw",32662890],["eosnewyorkio",32662902],["eosriobrazil",32662914],["eosswedenorg",32662926],["jedaaaaaaaaa",32662938],["starteosiobp",32662950],["zbeosbp11111",32662962]]
     * block_signing_key : EOS7rhgVPWWyfMqjSbNdndtCK8Gkza3xnDbUupsPLMZ6gjfQ4nX81
     * confirm_count : [1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,11,11,11,11,11,11,11,12,12,12,12,12,12,12,12,12,12,12,12,13,13,13,13,13,13,13,13,13,13,13,13,14,14,14,14,14,14,14]
     * confirmations : []
     */

    private String id;
    private int block_num;
    private HeaderBean header;
    private int dpos_proposed_irreversible_blocknum;
    private int dpos_irreversible_blocknum;
    private int bft_irreversible_blocknum;
    private int pending_schedule_lib_num;
    private String pending_schedule_hash;
    private PendingScheduleBean pending_schedule;
    private ActiveScheduleBean active_schedule;
    private BlockrootMerkleBean blockroot_merkle;
    private String block_signing_key;
    private List<List<String>> producer_to_last_produced;
    private List<List<String>> producer_to_last_implied_irb;
    private List<Integer> confirm_count;
    private List<?> confirmations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBlock_num() {
        return block_num;
    }

    public void setBlock_num(int block_num) {
        this.block_num = block_num;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public int getDpos_proposed_irreversible_blocknum() {
        return dpos_proposed_irreversible_blocknum;
    }

    public void setDpos_proposed_irreversible_blocknum(int dpos_proposed_irreversible_blocknum) {
        this.dpos_proposed_irreversible_blocknum = dpos_proposed_irreversible_blocknum;
    }

    public int getDpos_irreversible_blocknum() {
        return dpos_irreversible_blocknum;
    }

    public void setDpos_irreversible_blocknum(int dpos_irreversible_blocknum) {
        this.dpos_irreversible_blocknum = dpos_irreversible_blocknum;
    }

    public int getBft_irreversible_blocknum() {
        return bft_irreversible_blocknum;
    }

    public void setBft_irreversible_blocknum(int bft_irreversible_blocknum) {
        this.bft_irreversible_blocknum = bft_irreversible_blocknum;
    }

    public int getPending_schedule_lib_num() {
        return pending_schedule_lib_num;
    }

    public void setPending_schedule_lib_num(int pending_schedule_lib_num) {
        this.pending_schedule_lib_num = pending_schedule_lib_num;
    }

    public String getPending_schedule_hash() {
        return pending_schedule_hash;
    }

    public void setPending_schedule_hash(String pending_schedule_hash) {
        this.pending_schedule_hash = pending_schedule_hash;
    }

    public PendingScheduleBean getPending_schedule() {
        return pending_schedule;
    }

    public void setPending_schedule(PendingScheduleBean pending_schedule) {
        this.pending_schedule = pending_schedule;
    }

    public ActiveScheduleBean getActive_schedule() {
        return active_schedule;
    }

    public void setActive_schedule(ActiveScheduleBean active_schedule) {
        this.active_schedule = active_schedule;
    }

    public BlockrootMerkleBean getBlockroot_merkle() {
        return blockroot_merkle;
    }

    public void setBlockroot_merkle(BlockrootMerkleBean blockroot_merkle) {
        this.blockroot_merkle = blockroot_merkle;
    }

    public String getBlock_signing_key() {
        return block_signing_key;
    }

    public void setBlock_signing_key(String block_signing_key) {
        this.block_signing_key = block_signing_key;
    }

    public List<List<String>> getProducer_to_last_produced() {
        return producer_to_last_produced;
    }

    public void setProducer_to_last_produced(List<List<String>> producer_to_last_produced) {
        this.producer_to_last_produced = producer_to_last_produced;
    }

    public List<List<String>> getProducer_to_last_implied_irb() {
        return producer_to_last_implied_irb;
    }

    public void setProducer_to_last_implied_irb(List<List<String>> producer_to_last_implied_irb) {
        this.producer_to_last_implied_irb = producer_to_last_implied_irb;
    }

    public List<Integer> getConfirm_count() {
        return confirm_count;
    }

    public void setConfirm_count(List<Integer> confirm_count) {
        this.confirm_count = confirm_count;
    }

    public List<?> getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(List<?> confirmations) {
        this.confirmations = confirmations;
    }

    public static class HeaderBean {
        /**
         * timestamp : 2018-12-18T01:59:21.000
         * producer : zbeosbp11111
         * confirmed : 0
         * previous : 01f26651fa10fe3a1c2c3f7553fbf7b539a62210315dbb1c66739d8ad82a1a95
         * transaction_mroot : b8c364cbf21f89e5ed5dcac42d4dc5d82c07733137b50bacabb1d22380f045d4
         * action_mroot : f5d284a8d9e786e9f3639c60ac72fca2dc5b48d944b2d0930de5e51be33e2d01
         * schedule_version : 594
         * header_extensions : []
         * producer_signature : SIG_K1_KWjub2qeuyHyboghk6Ax1TSdop7SLJv6A2PrAcBdQkUMgrkwzcMtCF27HM489Dhqaq2gTpDDQA5bag7pw7QJXFx3TTX9rt
         */

        private String timestamp;
        private String producer;
        private int confirmed;
        private String previous;
        private String transaction_mroot;
        private String action_mroot;
        private int schedule_version;
        private String producer_signature;
        private List<?> header_extensions;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public int getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(int confirmed) {
            this.confirmed = confirmed;
        }

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public String getTransaction_mroot() {
            return transaction_mroot;
        }

        public void setTransaction_mroot(String transaction_mroot) {
            this.transaction_mroot = transaction_mroot;
        }

        public String getAction_mroot() {
            return action_mroot;
        }

        public void setAction_mroot(String action_mroot) {
            this.action_mroot = action_mroot;
        }

        public int getSchedule_version() {
            return schedule_version;
        }

        public void setSchedule_version(int schedule_version) {
            this.schedule_version = schedule_version;
        }

        public String getProducer_signature() {
            return producer_signature;
        }

        public void setProducer_signature(String producer_signature) {
            this.producer_signature = producer_signature;
        }

        public List<?> getHeader_extensions() {
            return header_extensions;
        }

        public void setHeader_extensions(List<?> header_extensions) {
            this.header_extensions = header_extensions;
        }
    }

    public static class PendingScheduleBean {
        /**
         * version : 594
         * producers : []
         */

        private int version;
        private List<?> producers;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<?> getProducers() {
            return producers;
        }

        public void setProducers(List<?> producers) {
            this.producers = producers;
        }
    }

    public static class ActiveScheduleBean {
        /**
         * version : 594
         * producers : [{"producer_name":"atticlabeosb","block_signing_key":"EOS7u1N2MuJj3BVTBgyb8BT3oQ41NNLHuaxcbGuYU6uuNBh1KUPck"},{"producer_name":"bitfinexeos1","block_signing_key":"EOS4tkw7LgtURT3dvG3kQ4D1sg3aAtPDymmoatpuFkQMc7wzZdKxc"},{"producer_name":"cochainworld","block_signing_key":"EOS5QDSQyh96SmktA28dteEchc1QCVdqKYG4YVDHGGATMYxqy33wi"},{"producer_name":"eos42freedom","block_signing_key":"EOS4tw7vH62TcVtMgm2tjXzn9hTuHEBbGPUK2eos42ssY7ip4LTzu"},{"producer_name":"eosauthority","block_signing_key":"EOS4va3CTmAcAAXsT26T3EBWqYHgQLshyxsozYRgxWm9tjmy17pVV"},{"producer_name":"eosbeijingbp","block_signing_key":"EOS5dGpcEhwB4VEhhXEcqtZs9EQj5HeetuXDnsAGVHMXHAFdMjbdj"},{"producer_name":"eosbixinboot","block_signing_key":"EOS7QC1XfAtkYeLjbHQjcDWVqUsxuSJ3YRhNyG93VAv2u3uHopGVp"},{"producer_name":"eoscanadacom","block_signing_key":"EOS7eycxAbCtKyfoJc8uRZcmt1AmArjXcz8aonLUTzahk5rHc18NJ"},{"producer_name":"eoscannonchn","block_signing_key":"EOS73cTi9V7PNg4ujW5QzoTfRSdhH44MPiUJkUV6m3oGwj7RX7kML"},{"producer_name":"eosdacserver","block_signing_key":"EOS6VkageCqyz1X97n7E1JyjPoZu8HEX6CVujY5ABzk3fPyV3vzZK"},{"producer_name":"eosflytomars","block_signing_key":"EOS6Agpfp38bTyRjJDmB4Qb1EpQSq7wnEAsALXgXE7KFSzKjokkFD"},{"producer_name":"eoshuobipool","block_signing_key":"EOS5XKswW26cR5VQeDGwgNb5aixv1AMcKkdDNrC59KzNSBfnH6TR7"},{"producer_name":"eoslaomaocom","block_signing_key":"EOS8QgURqo875qu3a8vgZ58qBeu2cTehe9zAWRfpdCXAQipicu1Fi"},{"producer_name":"eosliquideos","block_signing_key":"EOS4v1n2j5kXbCum8LLEc8zQLpeLK9rKVFmsUgLCWgMDN38P6PcrW"},{"producer_name":"eosnationftw","block_signing_key":"EOS8PkNNBYU1xnbcjBUNm1mT6N68QiGvCDgPT97rqurLBEjDanSXK"},{"producer_name":"eosnewyorkio","block_signing_key":"EOS6GVX8eUqC1gN1293B3ivCNbifbr1BT6gzTFaQBXzWH9QNKVM4X"},{"producer_name":"eosriobrazil","block_signing_key":"EOS7RioGoHQnhv2fJEiciP9Q7J8JgfJYFcyofVkmCqMop8Q1PzgqP"},{"producer_name":"eosswedenorg","block_signing_key":"EOS7SGSBsWhSob6TEric6u3TGodcc1uXFcqSrquJ3Etuqcbb3VnNY"},{"producer_name":"jedaaaaaaaaa","block_signing_key":"EOS6nB9Ar5sghWjqk27bszCiA9zxQtXZCaAaEkf2nwUm9iP5MEJTT"},{"producer_name":"starteosiobp","block_signing_key":"EOS4wZZXm994byKANLuwHD6tV3R3Mu3ktc41aSVXCBaGnXJZJ4pwF"},{"producer_name":"zbeosbp11111","block_signing_key":"EOS7rhgVPWWyfMqjSbNdndtCK8Gkza3xnDbUupsPLMZ6gjfQ4nX81"}]
         */

        private int version;
        private List<ProducersBean> producers;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<ProducersBean> getProducers() {
            return producers;
        }

        public void setProducers(List<ProducersBean> producers) {
            this.producers = producers;
        }

        public static class ProducersBean {
            /**
             * producer_name : atticlabeosb
             * block_signing_key : EOS7u1N2MuJj3BVTBgyb8BT3oQ41NNLHuaxcbGuYU6uuNBh1KUPck
             */

            private String producer_name;
            private String block_signing_key;

            public String getProducer_name() {
                return producer_name;
            }

            public void setProducer_name(String producer_name) {
                this.producer_name = producer_name;
            }

            public String getBlock_signing_key() {
                return block_signing_key;
            }

            public void setBlock_signing_key(String block_signing_key) {
                this.block_signing_key = block_signing_key;
            }
        }
    }

    public static class BlockrootMerkleBean {
        /**
         * _active_nodes : ["01f26651fa10fe3a1c2c3f7553fbf7b539a62210315dbb1c66739d8ad82a1a95","6eed13a22cee06b56449142f0b091bc76cb8a4456b85f82786d89ca4d681c35f","410878d1ec5a5ab3bfb6635db9a69b7b306fb0bf6799280275ec64885211e740","7b74e9128663654044052ee19028314e0e5f1e1568021865efd3c16e2413012a","f03fe60c3dfc4495cd10fd98e0ab43320098ba3f3b2cb396f9a396bcf741c9ef","3970b5f35e55c6c7c3327a407a57d8ad38cf119a5676c333f9128eb14b32af26","8991e467cec1cf1be6eb5e1cff8d4e757a02952d5413367d9a6909b5b70bc6d7","0367e35546f36c160aaa83dda2a8f3fd7db39c544ffba35d31ff55b73749606f","7299b85b9f0ea346cfa1a192f172f253a4387f0bf5f2edc6a579d21777f172e7","f3f8edbcfdc8eaaa29a81d1971872be90550fd499a9da9f7b2f3aae40608bf5c","c3e7ef17b6e1ad90f2363e5b4a107890d928850cf52d80ebaac9300558cf0a15","e19c967daaa989d236da04373355638a6411fa182966bed2e7b9dc5e478c659e","630857f9168c33e6063dd00ab3ad49d57f08b44175a70e07b66a63bc6d0f991e","889fa1864fdea73752b51afd50e33ee807821b555da3b107740c3c1bce32cad8"]
         * _node_count : 32663121
         */

        private int _node_count;
        private List<String> _active_nodes;

        public int get_node_count() {
            return _node_count;
        }

        public void set_node_count(int _node_count) {
            this._node_count = _node_count;
        }

        public List<String> get_active_nodes() {
            return _active_nodes;
        }

        public void set_active_nodes(List<String> _active_nodes) {
            this._active_nodes = _active_nodes;
        }
    }
}
