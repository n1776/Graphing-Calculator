package org.hypergolic.calculator.ast;

public class VariableNotFilledException extends RuntimeException
{
    public VariableNotFilledException()
    {
        super("Variable was not filled");
    }

    public VariableNotFilledException(String message)
    {
        super(message);
    }
}
