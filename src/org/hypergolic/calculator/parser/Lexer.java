package org.hypergolic.calculator.parser;

import java.util.ArrayList;
import java.util.Collections;
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
    }

    private enum LexerState
    {
        //starting state of lexer
        INITIAL,
        //a number is being processed
        NUMBER,
        //a single character operator is being processed
        //single character ops can not be used in function names
        SINGLE_CHAR,
        //a string is being processed, potentially a symbol
        //potentially a variable (x), constant, or function
        SYMBOL,
        //a token was detected successfully and added to the list
        //the currentToken StringBuilder should be empty
        SUCCESS,
        //something went wrong
        INVALID
    }
    private LexerState currentState = LexerState.INITIAL;
    private StringBuilder currentToken = new StringBuilder();
    private ArrayList<Token> tokens = new ArrayList<>();

    public Lexer(Map<String, Symbol> symbolMap)
    {
        this.symbolMap = symbolMap;
    }

    private Map<String, Symbol> symbolMap;

    public Lexer()
    {
        this(Collections.emptyMap());
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
        else if (currentState == LexerState.SYMBOL) {
            //x is the hard coded function argument
            if (currentToken.toString().equals("x")) {
                tokens.add(new Variable());
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
        //if char is part of a literal number
        if ("0123456789.".indexOf(c) != -1) {
            emitIfDifferentState(LexerState.NUMBER);
            currentState = LexerState.NUMBER;
            currentToken.append(c);
        } //if char is single character operator
        else if ("+-*/^()".indexOf(c) != -1) {
            emitIfDifferentState(LexerState.SINGLE_CHAR);
            currentState = LexerState.SINGLE_CHAR;
            currentToken.append(c);
            emitToken();
        } //we assume the char is a symbol (function or constant)
        else {
            emitIfDifferentState(LexerState.SYMBOL);
            currentState = LexerState.SYMBOL;
            currentToken.append(c);
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
