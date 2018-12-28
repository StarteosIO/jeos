package io.starteos.jeos.raw;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class Reader implements Pack.Reader {
    private ByteBuffer byteBuffer;

    public Reader(byte[] data) {
        byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
//        byteBuffer.order();
    }

    @Override
    public byte get() {
        return byteBuffer.get();
    }

    @Override
    public Short getShort() {
        return byteBuffer.getShort();
    }

    @Override
    public int getInt() {
        return byteBuffer.getInt();
    }

    @Override
    public long getLong() {
        return byteBuffer.getLong();
    }

    @Override
    public byte[] getBytes(int size) {
        byte[] temp = new byte[size];
        byteBuffer.get(temp);
        return temp;
    }

    @Override
    public String getString() {
        int size = byteBuffer.get();
        byte[] bytes = new byte[size];
        byteBuffer.get(bytes);
        return new String(bytes, Charset.forName("UTF-8"));
    }

    @Override
    public long getUInt() {
        long v = 0;
        byte b;
        byte by = 0;
        do {
            b = byteBuffer.get();
            v = v | (b & 0x7f << by);
            by = (byte) (by + 7);
        } while ((byte) (b & 0x80) != (byte) 0x00);

        return v;
    }
}
