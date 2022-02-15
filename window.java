package com.company;

import javax.swing.*;

public class window extends JFrame {
    window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setResizable(false);
        this.setTitle("Sorting Algorithms Visualization");
        this.setLayout(null);

        this.setJMenuBar(new menuBar());
        this.add(new aboutAlg());
        this.add(new bodyAlg());
        this.setVisible(true);
    }
}
