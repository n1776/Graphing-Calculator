package org.hypergolic.calculator.parser;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ShuntingYardVisitor implements Visitor
{
    private ArrayDeque<Token> opStack = new ArrayDeque<>();
    private ArrayList<Token> outputList = new ArrayList<>();


    @Override
    public void visit(LeftParenthesis leftParenthesis)
    {
        opStack.push(leftParenthesis);
    }

    @Override
    public void visit(RightParenthesis rightParenthesis)
    {
        while (!opStack.isEmpty() && !(opStack.peek() instanceof LeftParenthesis)) {
            outputList.add(opStack.pop());
        }
        //If we still have an element left, it has to be a left parenthesis
        if (!opStack.isEmpty()) {
            //discard the left parenthesis
            opStack.pop();
        } else {
            //if we reach this, the stack has run out without hitting a left parenthesis.
            //this means we have a right paren without a matching left paren
            throw new IllegalStateException("Mismatched Parenthesis");
        }
    }

    @Override
    public void visit(Constant constant)
    {
        outputList.add(constant);
    }

    @Override
    public void visit(AdditionOperator operator)
    {
        while (performShuntingYardCheck(operator, opStack.peek())) {
            outputList.add(opStack.pop());
        }
        opStack.push(operator);
    }

    @Override
    public void visit(MultiplicationOperator operator)
    {
        while (performShuntingYardCheck(operator, opStack.peek())) {
            outputList.add(opStack.pop());
        }
        opStack.push(operator);
    }

    private static boolean performShuntingYardCheck(BinaryOperator binaryOperator, Token top)
    {
        if (top instanceof LeftParenthesis)
            return false;
        if (!(top instanceof BinaryOperator))
            return false;
        BinaryOperator topOp = (BinaryOperator)top;
        if (topOp.precedence > binaryOperator.precedence)
            return true;

        if (topOp.precedence == binaryOperator.precedence
            && topOp.associativity == BinaryOperator.Associativity.LEFT)
            return true;

        return false;
    }

    public ArrayList<Token> getResult()
    {
        while (!opStack.isEmpty()) {
            outputList.add(opStack.pop());
        }
        //if the output has a left paren in it there is an extra paren
        if (outputList.stream().anyMatch(x -> x instanceof LeftParenthesis))
            throw new IllegalStateException("Mismatched Parenthesis");
        
        return outputList;
    }

}
