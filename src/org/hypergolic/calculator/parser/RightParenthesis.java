package org.hypergolic.calculator.parser;

public class RightParenthesis implements Token
{
    @Override
    public String toString()
    {
        return ")";
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
