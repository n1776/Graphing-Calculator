package org.hypergolic.calculator.parser;

import org.hypergolic.calculator.ast.MathVariable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Lexer
{
    private enum LexerState
    {
        INITIAL,
        AMBIGUOUS_FUNCTION,
        NUMBER,
        SUCCESS,
        INVALID
        //operator not needed since all operators are one char
    }
    private LexerState currentState = LexerState.INITIAL;
    private StringBuilder currentToken = new StringBuilder();
    private ArrayList<Token> tokens = new ArrayList<>();

    public Lexer()
    {

    }
    private void emitToken()
    {
        if (currentState == LexerState.NUMBER) {
            double value = Double.parseDouble(currentToken.toString());
            tokens.add(new Constant(value));
        }

        switch (currentToken.toString())
        {
            case "+":
                tokens.add(new AdditionOperator());
                break;
            case "-":
                tokens.add(new SubtractionOperator());
                break;
            case "*":
                tokens.add(new MultiplicationOperator());
                break;
            case "/":
                tokens.add(new DivisionOperator());
                break;
            case "^":
                tokens.add(new ExponentOperator());
            case "(":
                tokens.add(new LeftParenthesis());
                break;
            case ")":
                tokens.add(new RightParenthesis());
                break;
        }

        //clear the current token
        currentState = LexerState.SUCCESS;
        currentToken.setLength(0);
    }
    private void emitIfDifferentState(LexerState state)
    {
        if (currentState != state && currentState != LexerState.INITIAL)
            emitToken();
    }
    private void lookupChar(char c)
    {
        if ("0123456789.".indexOf(c) != -1) {
            emitIfDifferentState(LexerState.NUMBER);
            currentState = LexerState.NUMBER;
            currentToken.append(c);
        }
        if ("+-*/^()".indexOf(c) != -1) {
            currentToken.append(c);
            emitToken();
        }
    }

    public ArrayList<Token> lexExpression(String expression)
    {
        for (char c : expression.toCharArray())
            lookupChar(c);
        emitToken();
        return tokens;
    }
}
