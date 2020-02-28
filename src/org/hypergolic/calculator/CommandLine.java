package org.hypergolic.calculator;

import org.hypergolic.calculator.ast.MathConstant;
import org.hypergolic.calculator.graphing.GraphingFrame;
import org.hypergolic.calculator.parser.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLine
{
    private final InputStream inputStream;
    private final PrintStream printStream;
    private final Scanner scanner;

    private boolean enableTiming = true;
    private long previousTime;
    DecimalFormat timeFormat;

    public CommandLine()
    {
        this(System.in, System.out);
    }

    public CommandLine(InputStream inputStream, PrintStream printStream)
    {
        this.inputStream = inputStream;
        this.printStream = printStream;
        scanner = new Scanner(inputStream);

        //always add leading 0, display 4 digits precision with trailing 0s
        timeFormat = new DecimalFormat("0.0000");
    }

    private boolean shouldContinue()
    {
        return true;
    }

    public void process()
    {
        SymbolTable table = new SymbolTable();
        table.addConstant("pi", new Constant(Math.PI));
        table.addConstant("e", new Constant(Math.E));

        while (shouldContinue())
        {
            printStream.print("> ");
            String input = scanner.nextLine();
            if (enableTiming) {
                previousTime = System.nanoTime();
            }
            Lexer lexer = new Lexer(table);
            Evaluable ast = Parser.parseToAST(lexer.lexExpression(input));
            if (ast.hasVariable())
                new GraphingFrame(ast);
            else
                printStream.println(ast.evaluate(Double.NaN));

            if (enableTiming) {
                long currentTime = System.nanoTime();
                double elapsedTimeInMs = (currentTime - previousTime) / 1e6;
                printStream.println("Time elapsed: " + timeFormat.format(elapsedTimeInMs) + "ms");
            }

        }
    }

}
