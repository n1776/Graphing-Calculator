package org.hypergolic.calculator;

public interface Evaluable
{
    double evaluate(double x);
    boolean hasVariable();
    default String getTreeStructure(int depth)
    {
        return "  ".repeat(depth) + this.toString();
    }
}
