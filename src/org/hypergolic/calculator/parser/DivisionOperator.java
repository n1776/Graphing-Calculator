package org.hypergolic.calculator.parser;

public class DivisionOperator extends BinaryOperator
{
    public DivisionOperator()
    {
        this.precedence = 2;
        this.associativity = Associativity.LEFT;
    }

    @Override
    public String toString()
    {
        return "/";
    }

    @Override
    public void accept(Visitor visitor) { visitor.visit(this); }
}
