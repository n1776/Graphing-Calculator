package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Exponent extends BinaryOperator
{
    public Exponent(Evaluable param1, Evaluable param2)
    {
        this.left = param1;
        this.right = param2;
    }

    @Override
    public double evaluate(double x)
    {
        return Math.pow(left.evaluate(x), right.evaluate(x));
    }
}
