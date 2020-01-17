package org.hypergolic.calculator.parser;

import java.util.Map;

public class SymbolTable
{
    Map<String, Constant> constants;

    Token getSymbol(String name)
    {
        return constants.get(name);
    }
}
