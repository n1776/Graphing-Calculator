package org.hypergolic.calculator.parser;

public class Variable implements Token
{
    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
