package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class MathVariable implements Evaluable
{
    double value = Double.NaN;

    @Override
    public double evaluate()
    {
        if (Double.isNaN(value))
            throw new VariableNotFilledException();
        else
            return value;
    }

    @Override
    public void fillVariable(double value)
    {
        this.value = value;
    }

    @Override
    public boolean hasVariable()
    {
        return true;
    }
}
