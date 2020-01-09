package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Addition extends BinaryOperator
{
    public Addition(Evaluable param1, Evaluable param2)
    {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public double evaluate(double x)
    {
        return param1.evaluate(x) + param2.evaluate(x);
    }
}
