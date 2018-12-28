package io.starteos.jeos.transaction;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import io.starteos.jeos.crypto.util.BitUtils;
import io.starteos.jeos.crypto.util.HexUtils;
import io.starteos.jeos.raw.Pack;

public class TransactionHeader implements Pack.Packer {
    private String expiration;
    private int ref_block_num;
    private long ref_block_prefix;
    private int net_usage_words;
    private int max_cpu_usage_ms;
    private int delay_sec;

    public TransactionHeader() {
    }

    public TransactionHeader(TransactionHeader o) {
        this.expiration = o.expiration;
        this.ref_block_num = o.ref_block_num;
        this.ref_block_prefix = o.ref_block_prefix;
        this.net_usage_words = o.net_usage_words;
        this.max_cpu_usage_ms = o.max_cpu_usage_ms;
        this.delay_sec = o.delay_sec;
    }

    public void setRef_block_prefix(long ref_block_prefix) {
        this.ref_block_prefix = ref_block_prefix;
    }

    public void setRef_block_num(int ref_block_num) {
        this.ref_block_num = ref_block_num;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setReferenceBlock(String refBlockIdAsSha256) {
        ref_block_num = new BigInteger(1, HexUtils.toBytes(refBlockIdAsSha256.substring(0, 8))).intValue();

        ref_block_prefix = //new BigInteger( 1, HexUtils.toBytesReversed( refBlockIdAsSha256.substring(16,24))).longValue();
                BitUtils.uint32ToLong(HexUtils.toBytes(refBlockIdAsSha256.substring(16, 24)), 0); // BitUtils treats bytes in little endian.
        // so, no need to reverse bytes.
    }

    public int getNet_usage_words() {
        return net_usage_words;
    }

    public void setNet_usage_words(int net_usage_words) {
        this.net_usage_words = net_usage_words;
    }

    public int getMax_cpu_usage_ms() {
        return max_cpu_usage_ms;
    }

    public void setMax_cpu_usage_ms(int max_cpu_usage_ms) {
        this.max_cpu_usage_ms = max_cpu_usage_ms;
    }

    public int getDelay_sec() {
        return delay_sec;
    }

    public void setDelay_sec(int delay_sec) {
        this.delay_sec = delay_sec;
    }

    private Date getExpirationAsDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    @Override
    public void pack(Pack.Writer writer) {
        int ms = (int) (getExpirationAsDate(expiration).getTime() / 1000);
        writer.putInt(ms);
        writer.putShort((short) (ref_block_num & 0xFFFF));
        writer.putInt((int) (ref_block_prefix & 0xFFFFFFFF));
        writer.putUint(net_usage_words);
        writer.putUint(max_cpu_usage_ms);
        writer.putUint(delay_sec);

    }
}
