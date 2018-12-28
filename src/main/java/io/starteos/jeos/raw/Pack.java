package io.starteos.jeos.raw;

import java.util.Collection;

public interface Pack {
    interface Packer {
        public void pack(Writer writer);
    }

    interface Unpacker {
        public void unpack(Reader reader);
    }

    interface Reader {
        public byte get();

        public Short getShort();

        public int getInt();

        public long getLong();

        public byte[] getBytes(int size);

        public String getString();

        public long getUInt();
    }

    interface Writer {
        public Writer put(byte b);

        public Writer putShort(Short value);

        public Writer putInt(int value);

        public Writer putLong(long value);

        public Writer putBytes(byte[] value);

        public Writer putString(String value);

        public byte[] toBytes();

        public int length();

        public Writer putList(Collection<? extends Packer> list);

        public Writer putUint(long value);
    }
}
