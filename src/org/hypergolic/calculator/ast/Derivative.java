package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Derivative extends UnaryOperator
{
    protected Derivative(Evaluable value)
    {
        super(value);
    }

    @Override
    public double evaluate(double x)
    {
        //derivative of a constant is always 0
        if (!this.hasVariable())
            return 0;
        //formula from https://en.wikipedia.org/wiki/Symmetric_derivative
        //according to Wikipedia, 0.001 is used by the TI-84
        final double h = 0.001;
        return ((value.evaluate(x + h) - value.evaluate(x - h)) / (2*h));
    }

    @Override
    public boolean hasVariable()
    {
        return value.hasVariable();
    }
}
