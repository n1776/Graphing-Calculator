package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Sine extends UnaryOperator
{
    public Sine(Evaluable param)
    {
        this.param = param;
    }
    @Override
    public double evaluate()
    {
        return Math.sin(param.evaluate());
    }
}
