package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class MathVariable implements Evaluable
{
    @Override
    public double evaluate(double x)
    {
        return x;
    }
}
