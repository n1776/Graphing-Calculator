package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class MathVariable implements Evaluable
{
    @Override
    public double evaluate(double x)
    {
        return x;
    }

    @Override
    public boolean hasVariable()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
