package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest
{
    private static List<Token> oneWithParen = Arrays.asList(
            new LeftParenthesis(),
            new Constant(1),
            new RightParenthesis());
    @Test
    void lexExpression()
    {
        assertEquals(oneWithParen, Lexer.lexExpression("(1)"));
    }
}