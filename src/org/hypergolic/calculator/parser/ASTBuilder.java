package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;
import org.hypergolic.calculator.ast.Addition;
import org.hypergolic.calculator.ast.MathConstant;
import org.hypergolic.calculator.ast.Multiplication;

import java.util.ArrayDeque;

public class ASTBuilder
{
    private ArrayDeque<Evaluable> evaluables = new ArrayDeque<>();

    public void add(Constant constant)
    {
        evaluables.add(new MathConstant(constant.value));
    }

    public void add(AdditionOperator additionOperator)
    {
        final Evaluable second = evaluables.pop();
        final Evaluable first = evaluables.pop();
        evaluables.push(new Addition(first, second));
    }

    public void add(MultiplicationOperator multiplicationOperator)
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
