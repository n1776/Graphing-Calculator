package org.hypergolic.calculator.parser;

public class LeftParenthesis implements Token
{

    @Override
    public String toString()
    {
        return "(";
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof LeftParenthesis;
    }
}
