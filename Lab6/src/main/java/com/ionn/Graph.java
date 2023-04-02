package com.ionn;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Line> lines;
    List<Point> points;

    public Graph() {
        this.lines = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public void draw(Graphics g) {
        for (Point p : points
        ) {
            p.draw(g);
        }
        for (Line l:lines
             ) {
            l.draw(g);
        }
    }
}
