package org.hypergolic.calculator.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest
{

    @Test
    void parseToAST()
    {
        assertEquals(2, Parser.parseToAST("1+1").evaluate(), 0.001);
    }
}