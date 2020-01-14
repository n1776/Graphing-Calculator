package org.hypergolic.calculator.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lexer
{
    private static final Map<String, Token> opMap;
    static
    {
        opMap = new HashMap<>();
        opMap.put("+", new AdditionOperator());
        opMap.put("-", new SubtractionOperator());
        opMap.put("*", new MultiplicationOperator());
        opMap.put("/", new DivisionOperator());
        opMap.put("^", new ExponentOperator());
        opMap.put("(", new LeftParenthesis());
        opMap.put(")", new RightParenthesis());
        opMap.put("x", new Variable());
    }

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
            Token op = opMap.get(currentToken.toString());
            tokens.add(op);
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
