package io.starteos.jeos.raw;

import io.starteos.jeos.crypto.util.HexUtils;
import org.junit.Test;


public class WriterTest {
    @Test
    public void test() {
//        62010101000000010000000000000001000162
//        62010101000000010000000000000001000162
        byte[] s = HexUtils.toBytes("62010101000000010000000000000001000162");
        Writer writer = new Writer(255);
        writer.putBytes("b".getBytes());
        writer.put((byte) 1);
        writer.putUint(123123);
        writer.putInt(1);
        writer.putLong(1L);
        writer.putShort((short) 1);
        writer.putString("b");
        System.out.println(HexUtils.toHex(writer.toBytes()));
//        Reader reader = new Reader(s);
//
//        System.out.println(new String(reader.getBytes("b".getBytes().length)));
//        System.out.println(reader.get());
//        System.out.println(reader.getUInt());
//        System.out.println(reader.getInt());
//        System.out.println(reader.getLong());
//        System.out.println(reader.getShort());
//        long size = reader.getUInt();
//        System.out.println(size);
//        System.out.println(new String(reader.getBytes((int) size)));
    }

}