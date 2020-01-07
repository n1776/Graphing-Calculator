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
        System.out.println("Enter the expression to parse");
        final String expr = input.nextLine();
        final var result = Parser.parseToAST(expr).evaluate();
        System.out.println(result);
    }
}
