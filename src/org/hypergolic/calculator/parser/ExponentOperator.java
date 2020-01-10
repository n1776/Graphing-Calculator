package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.ast.Exponent;

public class ExponentOperator extends BinaryOperator
{

    public ExponentOperator()
    {
        this.precedence = 3;
        this.associativity = Associativity.RIGHT;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof ExponentOperator;
    }

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString()
    {
        return "^";
    }
}
