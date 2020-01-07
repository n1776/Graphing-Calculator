package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class UnaryOperator implements Evaluable
{
    Evaluable param;

    @Override
    public void fillVariable(double value)
    {
        param.fillVariable(value);
    }

    @Override
    public boolean hasVariable()
    {
        return param.hasVariable();
    }
}
