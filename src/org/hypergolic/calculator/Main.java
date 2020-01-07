package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.Lexer;
import org.hypergolic.calculator.parser.ShuntingYardVisitor;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the expression to parse");
        var output = Lexer.lexExpression(input.nextLine());
        var visitor = new ShuntingYardVisitor();
        output.forEach(x -> x.accept(visitor));
        visitor.getResult().forEach(System.out::println);
    }
}
