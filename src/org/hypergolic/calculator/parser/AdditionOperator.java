package org.hypergolic.calculator.parser;

public class AdditionOperator extends Operator
{
    public AdditionOperator()
    {
        this.precedence = 1;
        this.associativity = Associativity.LEFT;
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
