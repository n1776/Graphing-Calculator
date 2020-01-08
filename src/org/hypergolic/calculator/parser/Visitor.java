package org.hypergolic.calculator.parser;

public interface Visitor
{
    void visit(LeftParenthesis leftParenthesis);
    void visit(RightParenthesis rightParenthesis);
    void visit(Constant constant);
    void visit(AdditionOperator operator);
    void visit(SubtractionOperator operator);
    void visit(MultiplicationOperator operator);
}
