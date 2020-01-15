package org.hypergolic.calculator;

import org.hypergolic.calculator.parser.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
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
        constants.put("e", new NamedConstant("e", Math.E));
        while (shouldContinue())
        {
            printStream.print("> ");
            String input = scanner.nextLine();
            Lexer lexer = new Lexer(constants);
            Evaluable ast = Parser.parseToAST(lexer.lexExpression(input));
            if (ast.hasVariable())
                printStream.println("[anonymous function]");
            else
                printStream.println(ast.evaluate(Double.NaN));

        }
    }

}
