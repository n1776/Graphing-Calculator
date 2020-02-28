package org.hypergolic.calculator;

import org.hypergolic.calculator.ast.MathVariable;
import org.hypergolic.calculator.graphing.GraphingComponent;

import javax.swing.*;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        CommandLine commandLine = new CommandLine();
        commandLine.process();
    }

}
