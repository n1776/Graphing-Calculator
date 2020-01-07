package org.hypergolic.calculator.parser;

public interface Token
{
    void accept(Visitor visitor);
}
