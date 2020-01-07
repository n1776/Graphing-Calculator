package org.hypergolic.calculator.parser;


public class Constant implements Token
{
    public Constant(double value)
    {
        this.value = value;
    }

    public double value;

    @Override
    public String toString()
    {
        return Double.toString(value);
    }
    @Override
    public boolean equals(Object obj)
    {
        return (obj instanceof Constant)
                && ((Constant) obj).value == this.value;
    }
    @Override
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
