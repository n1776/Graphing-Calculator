package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Multiplication extends BinaryOperator
{
    public Multiplication(Evaluable param1, Evaluable param2)
    {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public double evaluate(double x) { return param1.evaluate(x) * param2.evaluate(x); }
}
