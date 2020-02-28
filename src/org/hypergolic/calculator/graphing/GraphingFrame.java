package org.hypergolic.calculator.graphing;

import org.hypergolic.calculator.Evaluable;

import javax.swing.*;
import java.awt.*;

public class GraphingFrame
{
    public GraphingFrame(Evaluable f)
    {
        JFrame frame = new JFrame("Graphing");
        frame.add(new GraphingComponent(f));
        frame.setMinimumSize(new Dimension(400, 400));
        frame.setVisible(true);
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);
    }
}
