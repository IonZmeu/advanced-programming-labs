package com.ionn.graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton saveButtonImg = new JButton("Save Img");
    JButton restartButton = new JButton("Restart");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Exit, etc.)
 //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        //setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(loadButton);
        File file = new File("C:\\Users\\Ion\\Desktop\\New folder\\save");
        loadButton.addActionListener(e -> {
            try {
                frame.canvas.loadGame(file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        add(saveButton);
        saveButton.addActionListener(e -> {
            try {
                frame.canvas.saveGame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        add(saveButtonImg);
        saveButtonImg.addActionListener(e -> {

            frame.canvas.createOffscreenImage();
        });
        add(restartButton);
        add(exitBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
 //...TODO
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
 //...TODO
}

