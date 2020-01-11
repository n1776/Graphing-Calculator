package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Addition extends BinaryOperator
{
    public Addition(Evaluable left, Evaluable right)
    {
        super(left, right);
    }

    @Override
    public double evaluate(double x)
    {
        return left.evaluate(x) + right.evaluate(x);
    }
}
