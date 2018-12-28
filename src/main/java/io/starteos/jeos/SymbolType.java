package io.starteos.jeos;

public class SymbolType {
    private long value;

    public SymbolType(long s) {
        this.value = s;
    }

    public boolean is_valid() {
        return Symbol.is_valid_symbol(value);
    }

    public long precision() {
        return value & 0xff;
    }

    public long name() {
        return value;
    }

    public int name_length() {
        return Symbol.symbol_name_length(value);
    }

    @Override
    public String toString() {
        return Symbol.name_to_string(value);
    }
}
