package com.company;

import javax.swing.*;
import java.awt.*;

public class bodyAlg extends JPanel {
    static JLabel description1 = new JLabel("Number of swaps: ");
    static JLabel description2 = new JLabel("Number of comparisons: ");
    static JButton start = new JButton("Start");

    bodyAlg(){
        this.setBounds(0,150,1200,650);
        this.setLayout(null);
        this.add(new bars());
        this.setBackground(Color.lightGray);

        start.setBounds(15, 450, 200, 100);
        start.setFocusable(false);
        this.add(start);
        start.addActionListener(e -> runSort());

        JButton stop = new JButton("Stop");
        stop.setBounds(250,450,200,100);
        stop.setFocusable(false);
        this.add(stop);

        description1.setBounds(500, 450, 250, 100);
        description1.setFont(new Font("Arial", Font.ITALIC, 15));
        description1.setForeground(Color.BLACK);
        description2.setBounds(800, 450, 250, 100);
        description2.setFont(new Font("Arial", Font.ITALIC, 15));
        description2.setForeground(Color.BLACK);
        this.add(description1);
        this.add(description2);

    }

    public void runSort(){
        if(menuBar.nrSort == 2){
            new bubbleSortAlg().start();
            start.setEnabled(false);
        }
    }


}
