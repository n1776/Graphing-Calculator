package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ASTTest
{

    private void testExpr(String expr, double expectedValue)
    {
        final double DELTA = 0.0001;
        assertEquals(expectedValue, Parser.parseToAST(expr).evaluate(0), DELTA);
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

        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("(1+1"));
        assertThrows(MismatchedParenthesisException.class,
                () -> Parser.parseToAST("1+1)"));

        assertDoesNotThrow(() -> Parser.parseToAST("()1"));
    }
}