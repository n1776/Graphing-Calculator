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
    public String getTreeStructure(String indent, boolean last, boolean isRoot)
    {
        String str;
        String oldIndent = indent;
        if (last) {
            str = "└ ";
            indent += "  ";
        }
        else {
            str = isRoot ? "" : "├ ";
            indent += isRoot ? "" : "│ ";
        }
        return oldIndent + str + this.toString() + "\n"
                + param1.getTreeStructure(indent, false, false)
                + param2.getTreeStructure(indent, true, false);
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
