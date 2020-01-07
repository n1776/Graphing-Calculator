package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest
{
    @Test
    void parseToAST()
    {
        assertEquals(2, Parser.parseToAST("1+1").evaluate(), 0.001);
        assertEquals(7, Parser.parseToAST("1+2*3").evaluate(), 0.001);
        assertEquals(9, Parser.parseToAST("(1+2)*3").evaluate(), 0.001);

        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("(1+1"));
        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("1+1)"));

        assertDoesNotThrow(() -> Parser.parseToAST("()1"));
    }
}