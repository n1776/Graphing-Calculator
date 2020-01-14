package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;

public abstract class Symbol
{
    final String name;

    protected Symbol(String name)
    {
        this.name = name;
    }
}
