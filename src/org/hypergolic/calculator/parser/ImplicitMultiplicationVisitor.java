package org.hypergolic.calculator.parser;

import java.util.ArrayList;

public class ImplicitMultiplicationVisitor implements Visitor
{

    private ArrayList<Token> tokens = new ArrayList<>();
    private boolean shouldEmitMultiply = false;

    @Override
    public ArrayList<Token> getResult()
    {
        return tokens;
    }

    private void emitMultiply() {tokens.add(new MultiplicationOperator());}

    @Override
    public void visit(LeftParenthesis leftParenthesis)
    {
        if (shouldEmitMultiply)
            emitMultiply();
        shouldEmitMultiply = false;
        tokens.add(leftParenthesis);
    }

    @Override
    public void visit(RightParenthesis rightParenthesis)
    {
        shouldEmitMultiply = true;
        tokens.add(rightParenthesis);
    }

    @Override
    public void visit(Constant constant)
    {
        shouldEmitMultiply = true;
        tokens.add(constant);
    }

    @Override
    public void visit(Variable variable)
    {
        if (shouldEmitMultiply)
            emitMultiply();
        shouldEmitMultiply = true;
        tokens.add(variable);
    }

    @Override
    public void visit(AdditionOperator operator)
    {
        shouldEmitMultiply = false;
        tokens.add(operator);
    }

    @Override
    public void visit(SubtractionOperator operator)
    {
        shouldEmitMultiply = false;
        tokens.add(operator);
    }

    @Override
    public void visit(MultiplicationOperator operator)
    {
        shouldEmitMultiply = false;
        tokens.add(operator);
    }

    @Override
    public void visit(DivisionOperator operator)
    {
        shouldEmitMultiply = false;
        tokens.add(operator);
    }

    @Override
    public void visit(ExponentOperator operator)
    {
        shouldEmitMultiply = false;
        tokens.add(operator);
    }
}
