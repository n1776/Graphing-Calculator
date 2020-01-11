package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Addition extends BinaryOperator
{
    public Addition(Evaluable param1, Evaluable param2)
    {
        this.left = param1;
        this.right = param2;
    }

    @Override
    public double evaluate(double x)
    {
        return left.evaluate(x) + right.evaluate(x);
    }
}
