package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;
import org.hypergolic.calculator.ast.*;

import java.util.ArrayDeque;

public class ASTBuilderVisitor implements Visitor
{
    private ArrayDeque<Evaluable> evaluables = new ArrayDeque<>();

    @Override
    public Evaluable getResult()
    {
        //There should only be one evaluable left, which is the root of the tree
        if (evaluables.size() != 1)
            throw new IllegalStateException("Invalid expression added");
        else
            return evaluables.pop();
    }

    @Override
    public void visit(LeftParenthesis leftParenthesis)
    { throw new MismatchedParenthesisException(); }

    @Override
    public void visit(RightParenthesis rightParenthesis)
    { throw new MismatchedParenthesisException(); }

    @Override
    public void visit(Constant constant)
    {
        evaluables.push(new MathConstant(constant.value));
    }

    @Override
    public void visit(Variable variable)
    { evaluables.push(new MathVariable()); }

    @Override
    public void visit(AdditionOperator additionOperator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Addition(first, second));
    }

    @Override
    public void visit(SubtractionOperator operator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Subtraction(first, second));
    }

    @Override
    public void visit(MultiplicationOperator multiplicationOperator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Multiplication(first, second));
    }

    @Override
    public void visit(DivisionOperator operator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Division(first, second));
    }

}
