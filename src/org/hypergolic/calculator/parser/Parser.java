package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.Evaluable;

import java.util.ArrayList;

public class Parser
{
    public static Evaluable parseToAST(ArrayList<Token> tokens)
    {
        var visitor = new ShuntingYardVisitor();
        tokens.forEach(x -> x.accept(visitor));
        return visitor.getResult();
    }

    public static Evaluable parseToAST(String expression)
    {
        //Shortcut
        return parseToAST(Lexer.lexExpression(expression));
    }
}
