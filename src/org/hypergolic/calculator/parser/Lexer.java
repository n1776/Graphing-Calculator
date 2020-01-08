package org.hypergolic.calculator.parser;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Lexer
{
    public static Token lookupToken(String tok)
    {
        Objects.requireNonNull(tok);

        //this is bad but it works
        try {
            double value = Double.parseDouble(tok);
            return new Constant(value);
        } catch (NumberFormatException ignored) {}

        if (tok.equals("("))
            return new LeftParenthesis();
        if (tok.equals(")"))
            return new RightParenthesis();
        if (tok.equals("+"))
            return new AdditionOperator();
        if (tok.equals("-"))
            return new SubtractionOperator();
        if (tok.equals("*"))
            return new MultiplicationOperator();
        if (tok.equals("/"))
            return new DivisionOperator();
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
