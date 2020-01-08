package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class Division extends BinaryOperator
{
    public Division(Evaluable param1, Evaluable param2)
    {
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public double evaluate()
    {
        return param1.evaluate() / param2.evaluate();
    }
}