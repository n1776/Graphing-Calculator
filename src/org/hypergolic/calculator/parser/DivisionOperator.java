package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.ast.Division;

public class DivisionOperator extends BinaryOperator
{
    public DivisionOperator()
    {
        this.precedence = 2;
        this.associativity = Associativity.LEFT;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof DivisionOperator;
    }

    @Override
    public String toString()
    {
        return "/";
    }

    @Override
    public void accept(Visitor visitor) { visitor.visit(this); }
}
