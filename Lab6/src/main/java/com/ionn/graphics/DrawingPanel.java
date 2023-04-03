package com.ionn.graphics;

import com.ionn.graph.Graph;
import com.ionn.graph.Line;
import com.ionn.graph.Point;
import com.ionn.saving.Save;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int[] coordX, coordY;
    private int[][] coordX2, coordY2;
    private int numVertices;
    private double edgeProbability;
    private Graph graph = new Graph();
    Random random = new Random();
    private int player = 0;
    private BufferedImage image;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Point p:graph.getPoints()
                     ) {
                    if ((e.getX() > p.getCoordX()-5 && e.getX() < p.getCoordX()+5 && e.getY() > p.getCoordY()-5 && e.getY() < p.getCoordY()+5) && !p.isSelected()){
                        p.setSelected(true);
                        System.out.println("Am atins un nod"+p.getCoordX()+" "+p.getCoordY());
                        if(player % 2 == 0){
                            p.setPlayer1(2);
                        }else {
                            p.setPlayer1(1);
                        }
                        player++;
                    }
                }
                repaint();
            }
        });
    }

    final void createBoard(int numVertices, double edgeProbability) throws IOException {
        createPoligon(numVertices, edgeProbability);
        getLines();
        graph.setLines(new ArrayList<>());
        graph.setPoints(new ArrayList<>());
        initializeGraph();
        saveForReset();
    }

    private void createPoligon(int numVertices, double edgeProbability) {
        this.numVertices = numVertices;
        this.edgeProbability = edgeProbability;
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        coordX = new int[numVertices];
        coordY = new int[numVertices];
        coordX2 = new int[numVertices][numVertices];
        coordY2 = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            coordX[i] = x0 + (int) (radius * Math.cos(alpha * i));
            coordY[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void getLines() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (random.nextInt(0, 100) <= edgeProbability * 100) {
                    coordX2[i][j] = coordX[j];
                    coordY2[i][j] = coordY[j];
                } else {
                    coordX2[i][j] = coordX[i];
                    coordY2[i][j] = coordY[i];
                }

            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, W, H);
        graph.draw(g);
        repaint();
        paintComponent(g);
    }

    public void initializeGraph(){
        for (int i = 0; i < numVertices; i++) {
            graph.addPoint(new Point(coordX[i], coordY[i]));
            System.out.println("apelat nou nod");
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (coordX[i]!= coordX2[i][j] && coordY[i]!= coordY2[i][j]){
                graph.addLine(new Line(coordX[i], coordY[i], coordX2[i][j], coordY2[i][j], graph.getPoints()));
                }
            }
        }
    }

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }


    public void createOffscreenImage() {
        image = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.createGraphics();
        frame.canvas.paint(g);  //this == JComponent
        g.dispose();
        try{ImageIO.write(image,"png",new File("C:\\Users\\Ion\\Desktop\\New folder\\test.png"));}catch (Exception e){}
        System.out.println("Saved");
    }

    public void saveGame() throws IOException {
        Save save = new Save();
        File file = new File("C:\\Users\\Ion\\Desktop\\New folder\\save");
        save.saveGameDataToFile(file);
        save.saveObject(graph);
    }

    public void loadGame(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        graph=(Graph) objectStream.readObject();
    }
    public void saveForReset() throws IOException {
        Save save = new Save();
        File file = new File("C:\\Users\\Ion\\Desktop\\New folder\\reset");
        save.saveGameDataToFile(file);
        save.saveObject(graph);
    }
    public void resetGame(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        graph=(Graph) objectStream.readObject();
    }
}

