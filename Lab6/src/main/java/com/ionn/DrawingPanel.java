package com.ionn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int[] x, y;
    private int[][] x2, y2;
    private int numVertices;
    private double edgeProbability;
    Random random = new Random();

    BufferedImage image; //the offscreen image

    //Graphics2D graphics; //the tools needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        //createOffscreenImage();
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Point point = e.getPoint();


                repaint();
            }
        });
    }

    final void createBoard(int numVertices, double edgeProbability) {
        //createOffscreenImage();
        createPoligon(numVertices, edgeProbability);
        getLines();
    }

    private void createPoligon(int numVertices, double edgeProbability) {
        this.numVertices = numVertices;
        this.edgeProbability = edgeProbability;
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        x2 = new int[numVertices][numVertices];
        y2 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void getLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (random.nextInt(0, 100) <= edgeProbability * 100) {
                    x2[i][j] = x[j];
                    y2[i][j] = y[j];
                } else {
                    x2[i][j] = x[i];
                    y2[i][j] = y[i];
                }

            }
        }
    }

    private void drawLines(Graphics g) {

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                g.drawLine(x[i], y[i], x2[i][j], y2[i][j]);
            }
        }
    }

    private void drawVertices(Graphics g) {
        Polygon p = new Polygon();
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] - 7, y[i] - 5, 10, 10);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, W, H);
        drawVertices(g);
        drawLines(g);
        repaint();
    }

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    //private void createOffscreenImage() {
    //image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
    //graphics = image.createGraphics();
    //graphics.setRenderingHint(
    //        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //}
}

