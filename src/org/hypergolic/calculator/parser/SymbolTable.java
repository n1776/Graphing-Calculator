package org.hypergolic.calculator.parser;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable
{
    private Map<String, Constant> constants;

    public SymbolTable()
    {
        constants = new HashMap<>();
    }

    public void addConstant(String name, Constant constant)
    {
        constants.put(name, constant);
    }

    public Token getSymbol(String name)
    {
        return constants.get(name);
    }
}
