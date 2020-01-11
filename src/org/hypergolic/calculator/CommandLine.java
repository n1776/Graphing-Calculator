package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.Parser;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLine
{
    InputStream inputStream;
    PrintStream printStream;
    Scanner scanner;

    public CommandLine()
    {
        this(System.in, System.out);
    }

    public CommandLine(InputStream inputStream, PrintStream printStream)
    {
        this.inputStream = inputStream;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);
    }

    private boolean shouldContinue()
    {
        return true;
    }

    public void process()
    {
        while (shouldContinue())
        {
            String input = scanner.nextLine();
            printStream.println(Parser.parseToAST(input).evaluate(0));
        }
    }

}
