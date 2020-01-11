package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Subtraction extends BinaryOperator
{
    public Subtraction(Evaluable left, Evaluable right)
    {
        super(left, right);
    }

    @Override
    public double evaluate(double x)
    {
        return left.evaluate(x) - right.evaluate(x);
    }

}
