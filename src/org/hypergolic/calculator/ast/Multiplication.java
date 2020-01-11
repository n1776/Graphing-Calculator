package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Multiplication extends BinaryOperator
{
    public Multiplication(Evaluable param1, Evaluable param2)
    {
        this.left = param1;
        this.right = param2;
    }

    @Override
    public double evaluate(double x) { return left.evaluate(x) * right.evaluate(x); }
}
