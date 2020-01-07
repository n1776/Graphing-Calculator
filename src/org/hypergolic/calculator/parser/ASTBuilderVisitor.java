package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;
import org.hypergolic.calculator.ast.Addition;
import org.hypergolic.calculator.ast.MathConstant;
import org.hypergolic.calculator.ast.Multiplication;

import java.util.ArrayDeque;

public class ASTBuilderVisitor implements Visitor
{
    private ArrayDeque<Evaluable> evaluables = new ArrayDeque<>();

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
    public void visit(AdditionOperator additionOperator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Addition(first, second));
    }

    @Override
    public void visit(MultiplicationOperator multiplicationOperator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Multiplication(first, second));
    }

    public Evaluable getResult()
    {
        //There should only be one evaluable left, which is the root of the tree
        if (evaluables.size() != 1)
            throw new IllegalStateException("Invalid expression added");
        else
            return evaluables.pop();
    }


}
