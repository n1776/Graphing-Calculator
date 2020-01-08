package org.hypergolic.calculator.parser;

public class MultiplicationOperator extends BinaryOperator
{
    public MultiplicationOperator()
    {
        this.precedence = 2;
        this.associativity = Associativity.LEFT;
    }
    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof MultiplicationOperator;
    }
    @Override
    public String toString()
    {
        return "*";
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
