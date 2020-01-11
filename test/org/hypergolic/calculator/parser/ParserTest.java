package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest
{

    private void testExpr(String expr, double expectedValue)
    {
        final double DELTA = 0.0001;
        assertEquals(expectedValue, Parser.parseToAST(expr).evaluate(0), DELTA);
    }

    private void testExpr(String expr, String equalExpr)
    {
        //test equals() implementation
        assertEquals(Parser.parseToAST(expr), Parser.parseToAST(equalExpr));
        //test hashCode() implementation
        assertEquals(Parser.parseToAST(expr).hashCode(), Parser.parseToAST(equalExpr).hashCode());
    }

    @Test
    void parseToAST()
    {
        testExpr("1+1", 2);
        testExpr("1+2*3", 7);
        testExpr("(1+2)*3", 9);
        testExpr("9+2-7", 4);
        testExpr("2*3-5", 1);
        testExpr("10/5+3", 5);
        testExpr("6/2(1+2)", 9);
        testExpr("(2)(3)(2)", 12);

        testExpr("1", "(1)");
        testExpr("2x", "2*x");
        testExpr("2x^2+9x-1", "2*(x^2)+9*x-1");

        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("(1+1"));
        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("1+1)"));

        assertDoesNotThrow(() -> Parser.parseToAST("()1"));
    }
}