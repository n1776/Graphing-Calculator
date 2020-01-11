package org.hypergolic.calculator;

public interface Evaluable
{
    double evaluate(double x);
    boolean hasVariable();
    default String getTreeStructure(String indent, boolean last, boolean isRoot)
    {
        String str;
        String oldIndent = indent;
        if (last) {
            str = "└ ";
        }
        else {
            str = "├ ";
        }
        return oldIndent + str + this.toString() + "\n";
    }
    default String getTreeStructure()
    {
        return getTreeStructure("", false, true);
    }
}
