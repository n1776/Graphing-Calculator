package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class UnaryOperator implements Evaluable
{
    Evaluable param;

    @Override
    public boolean hasVariable()
    {
        return param.hasVariable();
    }
}
