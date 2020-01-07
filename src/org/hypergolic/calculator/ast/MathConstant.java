package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public class MathConstant implements Evaluable
{
    final double value;

    public MathConstant(double value)
    {
        this.value = value;
    }

    @Override
    public double evaluate()
    {
        return value;
    }

    @Override
    public void fillVariable(double value)
    {
        //Constants aren't variables
        //Do nothing
    }

    @Override
    public boolean hasVariable()
    {
        //again, constants aren't variables
        return false;
    }
}
