package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class BinaryOperator implements Evaluable
{
    final Evaluable left;
    final Evaluable right;

    protected BinaryOperator(Evaluable left, Evaluable right)
    {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean hasVariable()
    {
        return left.hasVariable() || right.hasVariable();
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
                + left.getTreeStructure(indent, false, false)
                + right.getTreeStructure(indent, true, false);
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
