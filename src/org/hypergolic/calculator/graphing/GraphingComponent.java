package org.hypergolic.calculator.graphing;
import org.hypergolic.calculator.Evaluable;

import javax.swing.*;
import java.awt.*;

public class GraphingComponent extends JComponent
{
    private Evaluable f;
    private JFrame frame;
    public GraphingComponent(Evaluable f)
    {
        this.f = f;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        //w is x, and h is y (as in x/y values in a graph)
        int w = this.getWidth()/2;
        int h = this.getHeight()/2;

        Graphics2D g1 = (Graphics2D) g;
        g1.setStroke(new BasicStroke(1.5f));
        g1.setColor(Color.black);
        g1.drawLine(0,h,w*2,h);
        g1.drawLine(w,0,w,h*2);
        g1.drawString("0", w - 7, h + 13);


        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);

        Polygon p = new Polygon();
        final double MAX_X = 2 * Math.PI;
        final double SCALE = w / MAX_X;

        for (int x = -w; x <= w; ++x) {
            double xScaled = x / SCALE;
            p.addPoint(w + x, h - (int)Math.round(SCALE * f.evaluate(xScaled)));
        }
        g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);

    }

}
