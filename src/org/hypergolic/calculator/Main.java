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
}
