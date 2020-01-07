package org.hypergolic.calculator.parser;

import java.util.ArrayList;
import java.util.Scanner;

public class Lexer
{
    public static Token lookupToken(String tok)
    {
        if ("0123456789.".contains(tok))
            return new Constant(Double.parseDouble(tok));
        if (tok.equals("("))
            return new LeftParenthesis();
        if (tok.equals(")"))
            return new RightParenthesis();
        if (tok.equals("+"))
            return new AdditionOperator();
        if (tok.equals("*"))
            return new MultiplicationOperator();
        //not a valid token
        return null;
    }
    public static ArrayList<Token> lexExpression(String expression)
    {
        ArrayList<Token> tokens = new ArrayList<>();
        Scanner scan = new Scanner(expression);
        String regex = "(?<=[-−+*/()])|(?=[-−+*/()])";
        String[] toks = expression.split(regex);
        for (String tok : toks) {
            tok = tok.trim();
            tokens.add(lookupToken(tok));
        }
        return tokens;
    }
}
