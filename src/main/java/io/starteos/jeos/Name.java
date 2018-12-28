package io.starteos.jeos;

import java.util.Arrays;

import io.starteos.jeos.exception.NameConversionException;
import io.starteos.jeos.raw.Pack;

public class Name implements Pack.Packer, Pack.Unpacker {


    private static final int MAX_NAME_IDX = 12;
    /**
     * 字符串名�?
     */
    private String name;

    // uint64_t 类型的�??
    private long value; //uint64_t

    public Name(long value) {
        this.value = value;
        this.name = name_to_string(value);
    }

    public Name(String name) throws NameConversionException {
        this.value = string_to_name(name);
        this.name = name_to_string(value);
    }


    public long name_long() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * 返回名称的后�?
     *
     * @return 如果没有则返回当前名�?
     */
    public Name suffix() {

        long remaining_bits_after_last_actual_dot = 0;
        long tmp = 0;
        for (long remaining_bits = 59; remaining_bits >= 4; remaining_bits -= 5) { // Note: remaining_bits must remain signed integer
            // Get characters one-by-one in name in order from left to right (not including the 13th character)
            long c = (value >> remaining_bits) & 0x1FL;
            if (c == 0) { // if this character is a dot
                tmp = remaining_bits;
            } else { // if this character is not a dot
                remaining_bits_after_last_actual_dot = tmp;
            }
        }
        long thirteenth_character = value & 0x0FL;
        if (thirteenth_character != 0) { // if 13th character is not a dot
            remaining_bits_after_last_actual_dot = tmp;
        }

        if (remaining_bits_after_last_actual_dot == 0) // there is no actual dot in the name other than potentially leading dots
            return new Name(value);

        // At this point remaining_bits_after_last_actual_dot has to be within the range of 4 to 59 (and restricted to increments of 5).

        // Mask for remaining bits corresponding to characters after last actual dot, except for 4 least significant bits (corresponds to 13th character).
        long mask = (1L << remaining_bits_after_last_actual_dot) - 16;
        long shift = 64 - remaining_bits_after_last_actual_dot;
        return new Name(((value & mask) << shift) + (thirteenth_character << (shift - 1)));
    }

    /**
     * @return 返回当前名称长度
     */
    public int length() {
        long mask = 0xF800000000000000L;
        if (value == 0) {
            return 0;
        }
        int l = 0;
        int i = 0;
        for (long v = value; i < MAX_NAME_IDX + 1; ) {
            if ((v & mask) > 0) {
                l = i;
            }
            ++i;
            v <<= 5;
        }
        return l + 1;
    }

    /**
     * 单个Char转uint64_t
     *
     * @param c �?要转换的Char
     * @return uint64_t
     */
    public static byte charToValue(char c) throws NameConversionException {
        if (c == '.') {
            return 0;
        } else if (c >= '1' && c <= '5') {
            return (byte) ((c - '1') + 1);
        } else if (c >= 'a' && c <= 'z') {
            return (byte) ((c - 'a') + 6);
        } else {
            throw new NameConversionException("character is not in allowed character set for names");
        }
    }

    public static long string_to_name(String str) throws NameConversionException {
        if (null == str) {
            return 0;
        }

        int len = str.length();
        long value = 0;

        for (int i = 0; i <= MAX_NAME_IDX; i++) {
            long c = 0;

            if (i < len) c = charToValue(str.charAt(i));

            if (i < MAX_NAME_IDX) {
                c &= 0x1f;
                c <<= 64 - 5 * (i + 1);
            } else {
                c &= 0x0f;
            }

            value |= c;
        }

        return value;
    }

    public static String name_to_string(long value) {
        String charmap = ".12345abcdefghijklmnopqrstuvwxyz";
        long tmp = value;

        char[] result = new char[MAX_NAME_IDX + 1];
        Arrays.fill(result, ' ');

        for (int i = 0; i <= MAX_NAME_IDX; ++i) {
            char c = charmap.charAt((int) (tmp & (i == 0 ? 0x0f : 0x1f)));
            result[MAX_NAME_IDX - i] = c;
            tmp >>= (i == 0 ? 4 : 5);
        }

        return String.valueOf(result).replaceAll("[.]+$", ""); // remove trailing dot
    }

    static Name toName(String name) throws NameConversionException {
        return new Name(name);
    }

    @Override
    public void pack(Pack.Writer writer) {
        writer.putLong(value);
    }

    @Override
    public void unpack(Pack.Reader reader) {
        value = reader.getLong();
    }
}
