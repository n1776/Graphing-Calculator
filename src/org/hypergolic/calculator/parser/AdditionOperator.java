package org.hypergolic.calculator.parser;

public class AdditionOperator extends BinaryOperator
{
    public AdditionOperator()
    {
        this.precedence = 1;
        this.associativity = Associativity.LEFT;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof AdditionOperator;
    }

    @Override
    public String toString()
    {
        return "+";
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
