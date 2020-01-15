package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.NamedConstant;
import org.hypergolic.calculator.parser.Parser;
import org.hypergolic.calculator.parser.Symbol;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
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
        Map<String, Symbol> constants = new HashMap<>();
        constants.put("pi", new NamedConstant("pi", Math.PI));
        while (shouldContinue())
        {
            printStream.print("> ");
            String input = scanner.nextLine();
            Evaluable ast = Parser.parseToAST(input);
            if (ast.hasVariable())
                printStream.println("[anonymous function]");
            else
                printStream.println(ast.evaluate(Double.NaN));

        }
    }

}
