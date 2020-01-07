package org.hypergolic.calculator.ast;

import org.hypergolic.calculator.Evaluable;

public abstract class BinaryOperator implements Evaluable
{
    Evaluable param1;
    Evaluable param2;
}
