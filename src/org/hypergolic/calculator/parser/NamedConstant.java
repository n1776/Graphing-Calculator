package org.hypergolic.calculator.parser;

public class NamedConstant extends Symbol
{

    final double value;
    protected NamedConstant(String name, double value)
    {
        super(name);
        this.value = value;
    }
}
