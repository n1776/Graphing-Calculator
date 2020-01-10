package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class MathConstant implements Evaluable
{
    final double value;

    public MathConstant(double value)
    {
        this.value = value;
    }

    @Override
    public double evaluate(double x)
    {
        return value;
    }

    @Override
    public boolean hasVariable()
    {
        return false;
    }
}
