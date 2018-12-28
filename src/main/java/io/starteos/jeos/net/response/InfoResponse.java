package io.starteos.jeos.net.response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InfoResponse extends BaseResponse {

    /**
     * server_version : 59626f1e
     * chain_id : cf057bbfb72640471fd910bcb67639c22df9f92470936cddc1ade0e2f2e7dc4f
     * head_block_num : 2222978
     * last_irreversible_block_num : 2222977
     * last_irreversible_block_id : 0021eb810b276d8f0094939e6e18386d7a39c9b6dc15b92431582d64ded13b44
     * head_block_id : 0021eb82a03d33b90cef0903031e0eb0502f8e53492ab0ff81cc897a1463d55a
     * head_block_time : 2018-12-17T03:50:30.500
     * head_block_producer : eosio
     * virtual_block_cpu_limit : 200000000
     * virtual_block_net_limit : 1048576000
     * block_cpu_limit : 199900
     * block_net_limit : 1048576
     * server_version_string : v1.4.4
     */

    private String server_version;
    private String chain_id;
    private int head_block_num;
    private int last_irreversible_block_num;
    private String last_irreversible_block_id;
    private String head_block_id;
    private String head_block_time;
    private String head_block_producer;
    private int virtual_block_cpu_limit;
    private int virtual_block_net_limit;
    private int block_cpu_limit;
    private int block_net_limit;
    private String server_version_string;

    public String getServer_version() {
        return server_version;
    }
    public String getTimeAfterHeadBlockTime(int diffInMilSec) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date date = sdf.parse( this.head_block_time);

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add( Calendar.MILLISECOND, diffInMilSec);
            date = c.getTime();

            return sdf.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return this.head_block_time;
        }
    }
    public void setServer_version(String server_version) {
        this.server_version = server_version;
    }

    public String getChain_id() {
        return chain_id;
    }

    public void setChain_id(String chain_id) {
        this.chain_id = chain_id;
    }

    public int getHead_block_num() {
        return head_block_num;
    }

    public void setHead_block_num(int head_block_num) {
        this.head_block_num = head_block_num;
    }

    public int getLast_irreversible_block_num() {
        return last_irreversible_block_num;
    }

    public void setLast_irreversible_block_num(int last_irreversible_block_num) {
        this.last_irreversible_block_num = last_irreversible_block_num;
    }

    public String getLast_irreversible_block_id() {
        return last_irreversible_block_id;
    }

    public void setLast_irreversible_block_id(String last_irreversible_block_id) {
        this.last_irreversible_block_id = last_irreversible_block_id;
    }

    public String getHead_block_id() {
        return head_block_id;
    }

    public void setHead_block_id(String head_block_id) {
        this.head_block_id = head_block_id;
    }

    public String getHead_block_time() {
        return head_block_time;
    }

    public void setHead_block_time(String head_block_time) {
        this.head_block_time = head_block_time;
    }

    public String getHead_block_producer() {
        return head_block_producer;
    }

    public void setHead_block_producer(String head_block_producer) {
        this.head_block_producer = head_block_producer;
    }

    public int getVirtual_block_cpu_limit() {
        return virtual_block_cpu_limit;
    }

    public void setVirtual_block_cpu_limit(int virtual_block_cpu_limit) {
        this.virtual_block_cpu_limit = virtual_block_cpu_limit;
    }

    public int getVirtual_block_net_limit() {
        return virtual_block_net_limit;
    }

    public void setVirtual_block_net_limit(int virtual_block_net_limit) {
        this.virtual_block_net_limit = virtual_block_net_limit;
    }

    public int getBlock_cpu_limit() {
        return block_cpu_limit;
    }

    public void setBlock_cpu_limit(int block_cpu_limit) {
        this.block_cpu_limit = block_cpu_limit;
    }

    public int getBlock_net_limit() {
        return block_net_limit;
    }

    public void setBlock_net_limit(int block_net_limit) {
        this.block_net_limit = block_net_limit;
    }

    public String getServer_version_string() {
        return server_version_string;
    }

    public void setServer_version_string(String server_version_string) {
        this.server_version_string = server_version_string;
    }
}
