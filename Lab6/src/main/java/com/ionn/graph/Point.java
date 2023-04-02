package com.ionn.graph;

import java.awt.*;
import java.io.Serializable;

public class Point implements Serializable {
    private int x;
    private int y;
    private int player1 = 0;
    private boolean selected = false;
    private Color color;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void draw(Graphics g){
        if(player1 == 1 && selected){
            g.setColor(Color.RED);
            color=Color.RED;
        }
        if(player1 == 2 && selected){
            g.setColor(Color.GREEN);
            color=Color.GREEN;
        }
        g.fillOval(x - 7, y - 5, 10, 10);
        g.setColor(Color.BLACK);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPlayer1(int player1) {
        this.player1 = player1;
    }

    public int getPlayer1() {
        return player1;
    }

    public boolean isSelected() {
        return selected;
    }
}
