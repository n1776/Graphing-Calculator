package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperator that = (BinaryOperator) o;
        return left.equals(that.left) &&
                right.equals(that.right);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(left, right);
    }
}
