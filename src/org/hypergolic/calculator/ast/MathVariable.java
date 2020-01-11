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

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof MathVariable;
    }

    @Override
    public int hashCode()
    {
        return 0;
    }
}
