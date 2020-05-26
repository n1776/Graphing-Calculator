package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.ast.UnaryOperator;

public class Function implements Token
{

    public Function(UnaryOperator func)
    {
        this.func = func;
    }

    public UnaryOperator func;

    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
