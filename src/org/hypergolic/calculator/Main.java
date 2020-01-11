package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.Lexer;
import org.hypergolic.calculator.parser.Parser;
import org.hypergolic.calculator.parser.ShuntingYardVisitor;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the expression to parse: ");
            final String expr = input.nextLine();
            final var result = Parser.parseToAST(expr);
            System.out.println(result.getTreeStructure());
            if (result.hasVariable()) {
                System.out.println("Enter the value of x: ");
                System.out.println(result.evaluate(input.nextDouble()));
            } else {
                System.out.println(result.evaluate(Double.NaN));
            }
            //clear buffer
            input.nextLine();
        }
    }

    private static double takeDerivative(Evaluable f, double x)
    {
        //derivative of a constant is always 0
        if (!f.hasVariable())
            return 0;
        //formula from https://en.wikipedia.org/wiki/Symmetric_derivative
        //according to Wikipedia, 0.001 is used by the TI-84
        final double h = 0.001;
        return ((f.evaluate(x + h) - f.evaluate(x - h)) / (2*h));
    }
}
