package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Subtraction extends BinaryOperator
{
    public Subtraction(Evaluable param1, Evaluable param2)
    {
        this.left = param1;
        this.right = param2;
    }

    @Override
    public double evaluate(double x)
    {
        return left.evaluate(x) - right.evaluate(x);
    }

}
