package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

import java.util.function.DoubleUnaryOperator;

public class ForeignFunction extends UnaryOperator
{
    DoubleUnaryOperator operator;
    ForeignFunction(Evaluable param, DoubleUnaryOperator operator)
    {
        this.param = param;
        this.operator = operator;
    }

    @Override
    public double evaluate()
    {
        return operator.applyAsDouble(param.evaluate());
    }
}
