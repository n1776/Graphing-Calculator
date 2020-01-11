package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

import java.util.Objects;

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

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + ": " + value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathConstant that = (MathConstant) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode()
    {
        return Double.hashCode(value);
    }
}
