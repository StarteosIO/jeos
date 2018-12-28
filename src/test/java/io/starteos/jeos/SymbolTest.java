package io.starteos.jeos;

import org.junit.Test;

import io.starteos.jeos.exception.SymbolConversionException;

public class SymbolTest {

    @Test
    public void string_to_name() throws SymbolConversionException {
        long symbolName = Symbol.string_to_symbol(4, "EOS");
        System.out.println(symbolName);
        String symbol = Symbol.name_to_string(1397703940);
        System.out.println(symbol);
        SymbolType symbolType = new SymbolType(1397703940);
        System.out.println(symbolType.is_valid());
        System.out.println(symbolType.name());
        System.out.println(symbolType.name_length());
        System.out.println(symbolType.precision());

        long test1 = -10;
        System.out.println((test1 & 0xff));

        Symbol symbol1 = new Symbol("50.0001 BOS");
        System.out.println(symbol1.toBigDecimal().toPlainString());
    }

}