package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class BinaryOperator implements Evaluable
{
    Evaluable param1;
    Evaluable param2;

    @Override
    public boolean hasVariable()
    {
        return param1.hasVariable() || param2.hasVariable();
    }

    @Override
    public String getTreeStructure(int depth)
    {
        return Evaluable.super.getTreeStructure(depth)
                + "\n" + param1.getTreeStructure(depth+1)
                + "\n" + param2.getTreeStructure(depth+1);
    }
}
