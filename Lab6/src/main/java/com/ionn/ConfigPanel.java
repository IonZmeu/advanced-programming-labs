package com.ionn;

import jdk.internal.icu.util.CodePointMap;

import javax.swing.*;
import java.util.Vector;

public class ConfigPanel extends JPanel {
    public MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesSpinner;
    JButton createButton;

    JButton LineProb = new JButton("Line probability");
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();

    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability");
        //linesSpinner = new JSpinner(new SpinnerNumberModel(1,1,1,0.1));
        //create the rest of the components
 //...TODO
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
 //...TODO
    }
}

