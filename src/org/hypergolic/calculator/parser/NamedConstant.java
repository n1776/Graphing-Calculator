package org.hypergolic.calculator.parser;

public class NamedConstant extends Constant implements Symbol
{

    final String name;
    protected NamedConstant(String name, double value)
    {
        super(value);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
