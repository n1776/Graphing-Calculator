package org.hypergolic.calculator.graphing;
import org.hypergolic.calculator.Evaluable;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);

        Path2D.Double p = new Path2D.Double();

        final double MAX_X = 2 * Math.PI;
        final double SCALE = w / MAX_X;
        double previousY = f.evaluate((-w)/SCALE);
        p.moveTo(0 , previousY);
        for (double x = -w; x <= w; x+= 0.5) {
            double xScaled = x / SCALE;
            double y = f.evaluate(xScaled);
            if (Math.abs((SCALE * (y - previousY))/h) < 0.5)
                p.lineTo(w + x, h - (SCALE * y));
            else
                p.moveTo(w + x, h - (SCALE * y));
            previousY = y;

        }
        //p.closePath();
        g2.draw(p);

    }

}
