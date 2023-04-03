package com.ionn.graph;

import java.awt.*;
import java.io.Serializable;

public class Point implements Serializable {
    private int coordX;
    private int coordY;
    private int player1 = 0;
    private boolean selected = false;
    private Color color;
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        System.out.println("node with coordinates:" + " x:" + coordX + "y:" + coordY);
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        if(player1 == 1 ){
            g.setColor(Color.RED);
            color=Color.RED;
        }
        if(player1 == 2 ){
            g.setColor(Color.GREEN);
            color=Color.GREEN;
        }
        g.fillOval(coordX - 7, coordY - 5, 10, 10);
        g.setColor(Color.BLUE);
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
