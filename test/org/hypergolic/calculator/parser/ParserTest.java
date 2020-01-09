package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest
{

    public static final double DELTA = 0.0001;

    @Test
    void parseToAST()
    {
        assertEquals(2, Parser.parseToAST("1+1").evaluate(), DELTA);
        assertEquals(7, Parser.parseToAST("1+2*3").evaluate(), DELTA);
        assertEquals(9, Parser.parseToAST("(1+2)*3").evaluate(), DELTA);
        assertEquals(4, Parser.parseToAST("9+2-7").evaluate(), DELTA);
        assertEquals(1, Parser.parseToAST("2*3-5").evaluate(), DELTA);
        assertEquals(5, Parser.parseToAST("10/5+3").evaluate(), DELTA);
        assertEquals(9, Parser.parseToAST("6/2*(1+2)").evaluate(), DELTA);

        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("(1+1"));
        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("1+1)"));

        assertDoesNotThrow(() -> Parser.parseToAST("()1"));
    }
}