package com.company;

import javax.swing.*;
import java.awt.*;

public class bodyAlg extends JPanel {
    static JLabel description1 = new JLabel("Number of swaps: 0");
    static JLabel description2 = new JLabel("Number of comparisons: 0");
    static JButton start = new JButton("Start");
    static JButton stop = new JButton("Stop");


    bodyAlg(){
        this.setBounds(0,150,1200,650);
        this.setLayout(null);
        this.add(new bars());
        this.setBackground(Color.lightGray);

        start.setBounds(15, 450, 200, 100);
        start.setFocusable(false);
        this.add(start);
        start.addActionListener(e -> runSort());

        stop.setBounds(250, 450, 200, 100);
        stop.setFocusable(false);
        this.add(stop);
        stop.addActionListener(e -> setStop());

        description1.setBounds(500, 450, 250, 100);
        description1.setFont(new Font("Arial", Font.ITALIC, 15));
        description1.setForeground(Color.BLACK);
        description2.setBounds(800, 450, 250, 100);
        description2.setFont(new Font("Arial", Font.ITALIC, 15));
        description2.setForeground(Color.BLACK);
        this.add(description1);
        this.add(description2);

    }

    private void runSort(){
        description1.setText("Number of swaps: 0");
        description2.setText("Number of comparisons: 0");
        if(menuBar.nrSort == 1){
            menuBar.disableChange();
            new quickSortAlg().start();
        }
        else if(menuBar.nrSort == 2){
            menuBar.disableChange();
            new bubbleSortAlg().start();
        }
        else if(menuBar.nrSort == 3){
            menuBar.disableChange();
            new mergeSortAlg().start();
        }
    }

    private void setStop(){
        JOptionPane.showMessageDialog(null, "Work in progress...");
    }

}
