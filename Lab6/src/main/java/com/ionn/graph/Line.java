package com.ionn.graph;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Line implements Serializable {
    private int coordX1, coordX2, coordY1, coordY2;
    Point point1 = new Point(0, 0);
    Point point2 = new Point(0, 0);

    public Line(int coordX1, int coordY1, int coordX2, int coordY2, List<Point> pointList) {
        System.out.println(this.toString() + coordX1 +" "+ coordX2);
        this.coordX1 = coordX1;
        this.coordX2 = coordX2;
        this.coordY1 = coordY1;
        this.coordY2 = coordY2;
        boolean first = true;
        for (Point p : pointList
        ) {
            if (!first) {
                if ((p.getCoordX() == coordX1 || p.getCoordX() == coordX2 && p.getCoordY() == coordY1
                        || p.getCoordY() == coordY2)&& p.getCoordX()!= point2.getCoordX() && p.getCoordY()!= point2.getCoordY()) {
                    point1 = p;
                    System.out.println("am gasit nod 1 "+p.getCoordX()+ " "+ coordX1 + " "+ coordX2);
                }
            } else {
                if ((p.getCoordX() == coordX1 || p.getCoordX() == coordX2 && p.getCoordY() == coordY1 || p.getCoordY() == coordY2)&& p.getCoordX()!= point1.getCoordX() && p.getCoordY()!= point1.getCoordY()) {
                    point2 = p;
                    System.out.println("am gasit nod 2 "+p.getCoordX()+ " "+ coordX1 + " "+ coordX2);
                }
            }
            first = false;
        }
    }

    public void draw(Graphics g) {

            if (point1.getPlayer1() == point2.getPlayer1() && point1.getPlayer1() != 0) {
                g.setColor(point1.getColor());
                //System.out.println("scimbat culoarea in " + point1.getColor());
            }

        //System.out.println(x1+" "+" "+x2);
        g.drawLine(coordX1, coordY1, coordX2, coordY2);
        g.setColor(Color.BLUE);
    }
}
