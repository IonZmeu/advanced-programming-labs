package com.ionn.graphics;

import javax.swing.*;
import java.io.IOException;


public class ConfigPanel extends JPanel {
    public MainFrame frame;
//    public ComboBoxModel<Object> linesCombo;
//    public CodePointMap.Range dotsField ;
    JLabel dotsLabel;
    JLabel linesLabel;
    JSpinner dotsSpinner;
    JButton newGameButton;
    JComboBox linesComboBox;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();

    }

    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability");
        DefaultComboBoxModel<Double> lines = new DefaultComboBoxModel<Double>();
        lines.addElement(0.25);
        lines.addElement(0.5);
        lines.addElement(0.75);
        lines.addElement(1.0);
        linesComboBox = new JComboBox(lines);
        newGameButton = new JButton("Create new game");
        newGameButton.addActionListener(e -> {
            try {
                frame.canvas.createBoard( (int) dotsSpinner.getValue(), (double) lines.getSelectedItem());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesComboBox);
        add(newGameButton);
    }
}

