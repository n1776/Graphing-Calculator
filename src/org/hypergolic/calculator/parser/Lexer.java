package org.hypergolic.calculator.parser;

import java.util.ArrayList;

public class Lexer
{
    private enum LexerState
    {
        INITIAL,
        AMBIGUOUS_FUNCTION,
        NUMBER,
        SINGLE_CHAR,
        SUCCESS,
        INVALID
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
        else if (currentState == LexerState.SINGLE_CHAR) {
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
                    break;
                case "(":
                    tokens.add(new LeftParenthesis());
                    break;
                case ")":
                    tokens.add(new RightParenthesis());
                    break;
                case "x":
                    tokens.add(new Variable());
                    break;
            }
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
        if ("+-*/^()x".indexOf(c) != -1) {
            emitIfDifferentState(LexerState.SINGLE_CHAR);
            currentState = LexerState.SINGLE_CHAR;
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
