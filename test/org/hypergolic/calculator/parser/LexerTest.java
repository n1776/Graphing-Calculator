package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest
{

    @ParameterizedTest
    @MethodSource
    void lexExpression_lexToken(String expr, Token token)
    {
        assertEquals(token, Lexer.lexExpression(expr).get(0));
    }
    private static Stream<Arguments> lexExpression_lexToken()
    {
        return Stream.of(
                Arguments.of("(", new LeftParenthesis()),
                Arguments.of(")", new RightParenthesis()),
                Arguments.of("+", new AdditionOperator()),
                Arguments.of("-", new SubtractionOperator()),
                Arguments.of("*", new MultiplicationOperator()),
                Arguments.of("/", new DivisionOperator()),
                Arguments.of("^", new ExponentOperator())
        );
    }
    @ParameterizedTest
    @MethodSource
    void lexExpression_lexNumber(String expr, double value)
    {
        assertEquals(new Constant(value), Lexer.lexExpression(expr).get(0));
    }
    private static Stream<Arguments> lexExpression_lexNumber()
    {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("123.456", 123.456)
        );
    }

}