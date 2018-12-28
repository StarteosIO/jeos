package io.starteos.jeos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.starteos.jeos.exception.SymbolConversionException;
import io.starteos.jeos.raw.Pack;
import io.starteos.jeos.utils.StringUtils;

public class Symbol implements Pack.Packer {
    private static final long[] PRECISION_TABLE = {
            1, 10, 100, 1000, 10000,
            100000, 1000000, 10000000, 100000000,
            1000000000, 10000000000L,
            100000000000L, 1000000000000L,
            10000000000000L, 100000000000000L
    };
    private long amount;
    private SymbolType symbolType;


    public Symbol(long amount, SymbolType symbolName) {
        this.amount = amount;
        this.symbolType = symbolName;
    }

    public Symbol(String value) throws SymbolConversionException {
        value = value.trim();

        Pattern pattern = Pattern.compile("^([0-9]+)\\.?([0-9]*)([ ][a-zA-Z0-9]{1,7})?$");//\\s(\\w)$");
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            String beforeDotVal = matcher.group(1), afterDotVal = matcher.group(2);

            String symbolStr = StringUtils.isEmpty(matcher.group(3)) ? null : matcher.group(3).trim();
            symbolType = new SymbolType(string_to_symbol(afterDotVal.length(), symbolStr));
            this.amount = Long.parseLong(beforeDotVal + afterDotVal);
        } else {
            this.amount = 0;
            this.symbolType = new SymbolType(string_to_symbol(3, "EOS"));
        }
    }

    public byte decimals() {
        return (byte) (symbolType.name() & 0xFF);
    }

    public long precision() {
        int decimal = decimals();
        if (decimal >= PRECISION_TABLE.length) {
            decimal = 0;
        }

        return PRECISION_TABLE[decimal];
    }

    @Override
    public String toString() {
        long precisionVal = precision();
        String result = String.valueOf(amount / precisionVal);

        if (decimals() > 0) {
            long fract = amount % precisionVal;
            result += "." + String.valueOf(precisionVal + fract).substring(1);
        }

        return result + " " + symbolType.toString();
    }

    public BigDecimal toBigDecimal() {
        return BigDecimal.valueOf(amount).divide(BigDecimal.valueOf(precision()), 4, RoundingMode.DOWN);
    }


    static public long string_to_symbol(int precision, String str) throws SymbolConversionException {
        if (str == null || str.length() == 0) {
            throw new SymbolConversionException("symbol error");
        }
        int len = str.length();
        long result = 0;
        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (c > 'A' && c < 'Z') {
                result |= c << (8 * (1 + i));
            } else {
                throw new SymbolConversionException("symbol error");
            }
        }
        result |= Long.parseLong(String.valueOf(precision));
        return result;
    }

    static public String name_to_string(long sym) {
        sym >>= 8;
        StringBuilder result = new StringBuilder();
        while (sym > 0) {
            char c = (char) (sym & 0xff);
            result.append(c);
            sym >>= 8;
        }
        return result.toString();
    }

    static public boolean is_valid_symbol(long sym) {
        sym >>= 8;
        for (int i = 0; i < 7; ++i) {
            char c = (char) (sym & 0xff);
            if (!('A' <= c && c <= 'Z')) {
                return false;
            }
            sym >>= 8;
            if ((sym & 0xff) == 0) {
                do {
                    sym >>= 8;
                    if ((sym & 0xff) != 0) {
                        return false;
                    }
                    ++i;
                } while (i < 7);
            }
        }
        return true;
    }

    static public int symbol_name_length(long sym) {
        sym >>= 8;
        int length = 0;
        while ((sym & 0xff) != 0 && length <= 7) {
            ++length;
            sym >>= 8;
        }
        return length;
    }

    public SymbolType getSymbolType() {
        return symbolType;
    }

    @Override
    public void pack(Pack.Writer writer) {
        writer.putLong(amount);
        writer.putLong(symbolType.name());
    }
}
