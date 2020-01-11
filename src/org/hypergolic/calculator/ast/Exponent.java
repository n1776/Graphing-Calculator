package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Exponent extends BinaryOperator
{
    public Exponent(Evaluable left, Evaluable right)
    {
        super(left, right);
    }

    @Override
    public double evaluate(double x)
    {
        return Math.pow(left.evaluate(x), right.evaluate(x));
    }
}
