package me.rogalsp1.virtualcamera.view;

import me.rogalsp1.virtualcamera.Properties;
import me.rogalsp1.virtualcamera.model.Edge2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

/**
 * Created by rogalsp1 on 15.10.16.
 */
public class DrawingPanel extends JPanel {

    private List<Edge2D> edgesToDraw;

    public DrawingPanel(List<Edge2D> edgesToDraw) {
        setBackground(Properties.BACKGROUND_COLOR);
        setForeground(Properties.BACKGROUND_COLOR);
        this.edgesToDraw = edgesToDraw;
    }

    public void init() {
        setBackground(Properties.BACKGROUND_COLOR);
        setForeground(Properties.BACKGROUND_COLOR);
    }

    public void repaint(List<Edge2D> edgesToDraw) {
        this.edgesToDraw = edgesToDraw;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Properties.LINE_COLOR);
        drawEdges(g);
        setSize(Properties.DRAWING_WINDOW_WIDTH, Properties.DRAWING_WINDOW_HEIGHT);
    }


    private void drawEdges(Graphics g) {
        edgesToDraw.stream().forEach(x -> drawEdge(g, x));
    }

    private void drawEdge(Graphics g, Edge2D edge2D) {
        Graphics2D g2 = (Graphics2D) g;
        Line2D line = new Line2D.Double(edge2D.getPoint1().getX(),
                edge2D.getPoint1().getY(),
                edge2D.getPoint2().getX(),
                edge2D.getPoint2().getY());
        g2.draw(line);
    }
}
