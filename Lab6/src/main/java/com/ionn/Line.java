package com.ionn;

import java.awt.*;
import java.util.List;

public class Line {
    private int x1, x2, y1, y2;
    Point point1 = new Point(0, 0);
    Point point2 = new Point(0, 0);

    public Line(int x1, int y1, int x2, int y2, List<Point> pointList) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        boolean first = true;
        for (Point p : pointList
        ) {
            if (!first) {
                if (p.getX() == x1 || p.getX() == x2 && p.getY() == y1 || point1.getY() == y2) {
                    point1 = p;
                    System.out.println("am gasit nod1");
                }
            } else {
                if (p.getX() == x1 || p.getX() == x2 && p.getY() == y1 || point1.getY() == y2) {
                    point2 = p;
                    System.out.println("am gasit nod2");
                }
            }
            first = false;
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        if (point1.getX() == x1 || point1.getX() == x2 && point1.getY() == y1 || point1.getY() == y2 && point2.getX() == x1 || point2.getX() == x2 && point2.getY() == y1 || point2.getY() == y2) {
            if (point1.getPlayer1() == point2.getPlayer1() && point1.getPlayer1() != 0) {
                g.setColor(point1.getColor());
                System.out.println("scimbat culoarea");
            }
        }
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
    }
}
