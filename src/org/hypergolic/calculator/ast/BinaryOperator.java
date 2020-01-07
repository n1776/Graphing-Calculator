package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class BinaryOperator implements Evaluable
{
    Evaluable param1;
    Evaluable param2;

    @Override
    public void fillVariable(double value)
    {
        param1.fillVariable(value);
        param2.fillVariable(value);
    }

    @Override
    public boolean hasVariable()
    {
        return param1.hasVariable() || param2.hasVariable();
    }
}
