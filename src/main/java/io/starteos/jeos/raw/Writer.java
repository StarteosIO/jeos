package io.starteos.jeos.raw;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;

public class Writer implements Pack.Writer {
    private ByteBuffer byteBuffer;

    public Writer(int size) {
        byteBuffer = ByteBuffer.allocate(size).order(ByteOrder.LITTLE_ENDIAN);
    }

    private void size(int size){
        if (byteBuffer.limit() - byteBuffer.position() < size) {
            int position = byteBuffer.position();
//            byte[] bytes = byteBuffer.array();
            ByteBuffer temp = ByteBuffer.allocate(byteBuffer.limit() * 2 + size).order(ByteOrder.LITTLE_ENDIAN);
            temp.put(byteBuffer.array());
            this.byteBuffer = temp;
            this.byteBuffer.position(position);


        }
    }

    @Override
    public Pack.Writer put(byte b) {
        size(1);
        byteBuffer.put(b);
        return this;
    }

    @Override
    public Pack.Writer putShort(Short value) {
        size(2);
        byteBuffer.putShort(value);
        return this;
    }

    @Override
    public Pack.Writer putInt(int value) {
        size(4);
        byteBuffer.putInt(value);
        return this;
    }

    @Override
    public Pack.Writer putLong(long value) {
        size(8);
        byteBuffer.putLong(value);
        return this;
    }

    @Override
    public Pack.Writer putBytes(byte[] value) {
        size(value.length);
        byteBuffer.put(value);
        return this;
    }

    @Override
    public Pack.Writer putString(String value) {
        if (value == null) {
            putUint(0);
            return this;
        }
        byte[] bytes = value.getBytes();
        putUint(bytes.length);
        putBytes(bytes);
        return this;
    }

    @Override
    public byte[] toBytes() {
        byte[] temp = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, temp, 0, byteBuffer.position());
        return temp;
    }

    @Override
    public int length() {
        return byteBuffer.position();
    }

    @Override
    public Pack.Writer putList(Collection<? extends Pack.Packer> list) {
        if (list == null) {
            putUint(0);
            return this;
        }
        putUint(list.size());
        for (Pack.Packer packer : list) {
            packer.pack(this);
        }
        return this;
    }

    @Override
    public Pack.Writer putUint(long value) {
//        byteBuffer.put()
        do {
            byte b = (byte) (value & 0x7f);
            value = value >> 7;
            b = (byte) (b | ((value > 0 ? 1 : 0) << 7));
            put(b);
        }while (value != 0L);
        return this;
    }
}
