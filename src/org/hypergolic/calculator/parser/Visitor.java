package org.hypergolic.calculator.parser;

public interface Visitor
{
    Object getResult();

    void visit(LeftParenthesis leftParenthesis);
    void visit(RightParenthesis rightParenthesis);
    void visit(Constant constant);
    void visit(Variable variable);
    void visit(Function function);
    void visit(AdditionOperator operator);
    void visit(SubtractionOperator operator);
    void visit(MultiplicationOperator operator);
    void visit(DivisionOperator operator);
    void visit(ExponentOperator operator);
}
