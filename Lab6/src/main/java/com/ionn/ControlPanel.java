package com.ionn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton restartButton = new JButton("Restart");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Exit, etc.)
 //...TODO
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(loadButton);
        add(saveButton);
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

