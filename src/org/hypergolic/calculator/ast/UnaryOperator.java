package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class UnaryOperator implements Evaluable
{
    final Evaluable value;

    protected UnaryOperator(Evaluable value)
    {
        this.value = value;
    }

    @Override
    public boolean hasVariable()
    {
        return value.hasVariable();
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
                + value.getTreeStructure(indent, true, false);
    }
}
