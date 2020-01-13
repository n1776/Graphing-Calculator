package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;

import java.util.ArrayList;

public class Parser
{
    public static Evaluable parseToAST(ArrayList<Token> tokens)
    {
        var implicitMulVisitor = new ImplicitMultiplicationVisitor();
        tokens.forEach(x -> x.accept(implicitMulVisitor));
        var shuntingYardVisitor = new ShuntingYardVisitor();
        implicitMulVisitor.getResult().forEach(x -> x.accept(shuntingYardVisitor));
        return shuntingYardVisitor.getResult();
    }

    public static Evaluable parseToAST(String expression)
    {
        //Shortcut
        return parseToAST(new Lexer().lexExpression(expression));
    }
}
