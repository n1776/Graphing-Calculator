package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

import java.util.function.DoubleUnaryOperator;

public class ForeignFunction extends UnaryOperator
{
    DoubleUnaryOperator operator;
    ForeignFunction(Evaluable param, DoubleUnaryOperator operator)
    {
        super(param);
        this.operator = operator;
    }



    @Override
    public double evaluate(double x)
    {
        return operator.applyAsDouble(value.evaluate(x));
    }
}
