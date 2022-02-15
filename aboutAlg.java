package com.company;

import javax.swing.*;
import java.awt.*;

public class aboutAlg extends JPanel {
    static JLabel title = new JLabel("SomeSort");
    static JPanel description = new JPanel();
    static descLabel descWorst = new descLabel("Worst something");
    static descLabel descAver = new descLabel("Average something");
    static descLabel descBest = new descLabel("Best something");

    aboutAlg(){
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);

        description.setLayout(new GridLayout(1,3));
        description.setBackground(Color.BLACK);
        description.add(descWorst);
        description.add(descAver);
        description.add(descBest);

        this.setBounds(0,0,1200,150);
        this.setLayout(new GridLayout(2,1));
        this.setBackground(Color.BLACK);
        this.add(title);
        this.add(description);
    }

    public static class descLabel extends JLabel{
        descLabel(String text){
            this.setText(text);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setFont(new Font("Arial", Font.ITALIC, 25));
            this.setForeground(Color.WHITE);
        }

        public void changeText(String text){
            this.setText(text);
        }
    }
}
