package org.hypergolic.calculator;

public interface Evaluable
{
    double evaluate();
    default double evaluate(double value)
    {
        fillVariable(value);
        return evaluate();
    }
    void fillVariable(double value);
    boolean hasVariable();

}
