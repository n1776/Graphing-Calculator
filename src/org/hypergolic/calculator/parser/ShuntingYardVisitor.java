package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;

import java.util.ArrayDeque;

public class ShuntingYardVisitor implements Visitor
{
    private ArrayDeque<Token> opStack = new ArrayDeque<>();
    private ASTBuilderVisitor ASTVisitor = new ASTBuilderVisitor();

    @Override
    public Evaluable getResult()
    {
        //give the AST visitor all remaining operators
        opStack.forEach(token -> token.accept(ASTVisitor));
        return ASTVisitor.getResult();
    }

    @Override
    public void visit(LeftParenthesis leftParenthesis)
    {
        opStack.push(leftParenthesis);
    }

    @Override
    public void visit(Function function)
    {
        opStack.push(function);
    }

    @Override
    public void visit(RightParenthesis rightParenthesis)
    {
        while (!opStack.isEmpty() && !(opStack.peek() instanceof LeftParenthesis)) {
            opStack.pop().accept(ASTVisitor);
        }
        //If we still have an element left, it has to be a left parenthesis
        if (!opStack.isEmpty()) {
            //discard the left parenthesis
            opStack.pop();
        } else {
            //if we reach this, the stack has run out without hitting a left parenthesis.
            //this means we have a right paren without a matching left paren
            throw new MismatchedParenthesisException();
        }
    }

    @Override
    public void visit(Constant constant)
    {
        constant.accept(ASTVisitor);
    }

    @Override
    public void visit(Variable variable) { variable.accept(ASTVisitor); }

    private void addBinaryOp(BinaryOperator operator)
    {
        while (performShuntingYardCheck(operator, opStack.peek())) {
            opStack.pop().accept(ASTVisitor);
        }
        opStack.push(operator);
    }

    @Override
    public void visit(AdditionOperator operator)
    {
        addBinaryOp(operator);
    }

    @Override
    public void visit(SubtractionOperator operator)
    {
        addBinaryOp(operator);
    }

    @Override
    public void visit(MultiplicationOperator operator)
    {
        addBinaryOp(operator);
    }

    @Override
    public void visit(DivisionOperator operator)
    {
        addBinaryOp(operator);
    }

    @Override
    public void visit(ExponentOperator operator)
    {
        addBinaryOp(operator);
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



}
