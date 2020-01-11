package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.Lexer;
import org.hypergolic.calculator.parser.Parser;
import org.hypergolic.calculator.parser.ShuntingYardVisitor;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        CommandLine commandLine = new CommandLine();
        commandLine.process();
    }

}
