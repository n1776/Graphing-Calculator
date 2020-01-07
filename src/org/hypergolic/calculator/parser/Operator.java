package org.hypergolic.calculator.parser;

public abstract class Operator implements Token
{
    public enum Associativity {
        LEFT, RIGHT;
    }

    public int precedence;
    Associativity associativity;
}
