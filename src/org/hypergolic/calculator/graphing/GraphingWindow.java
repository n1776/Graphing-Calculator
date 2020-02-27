package org.hypergolic.calculator.graphing;
import org.hypergolic.calculator.Evaluable;

import javax.swing.*;
import java.awt.*;

public class GraphingWindow
{
    private Evaluable f;
    private JFrame frame;
    public GraphingWindow(Evaluable f)
    {
        this.f = f;
        frame = new JFrame("Graph");
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
