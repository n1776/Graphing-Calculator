package org.hypergolic.calculator.parser;

public class SubtractionOperator extends BinaryOperator
{
    SubtractionOperator()
    {
        this.precedence = 1;
        this.associativity = Associativity.LEFT;
    }

    @Override
    public String toString()
    {
        return "-";
    }

    @Override
    public void accept(Visitor visitor) { visitor.visit(this); }
}
