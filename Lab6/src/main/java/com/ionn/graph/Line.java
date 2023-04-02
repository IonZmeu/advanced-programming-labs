package com.ionn.graph;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Line implements Serializable {
    private int x1, x2, y1, y2;
    Point point1 = new Point(0, 0);
    Point point2 = new Point(0, 0);

    public Line(int x1, int y1, int x2, int y2, List<Point> pointList) {
        System.out.println(this.toString() + x1 +" "+ x2);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        boolean first = true;
        for (Point p : pointList
        ) {
            if (!first) {
                if (p.getX() == x1 || p.getX() == x2 && p.getY() == y1 || p.getY() == y2) {
                    point1 = p;
                    System.out.println("am gasit nod1"+p.getX()+ " "+ x1);
                }
            } else {
                if (p.getX() == x1 || p.getX() == x2 && p.getY() == y1 || p.getY() == y2) {
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

            if (point1.getPlayer1() == point2.getPlayer1() && point1.getPlayer1() != 0) {
                g.setColor(point1.getColor());
                System.out.println("scimbat culoarea in " + point1.getColor());
            }

        //System.out.println(x1+" "+" "+x2);
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
    }
}
