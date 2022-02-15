package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class bars extends JPanel {
    static ArrayList<bars.singleBar> barsList = new ArrayList<>();
    static ArrayList<Integer> valuesList = new ArrayList<>();

    bars(){
        this.setBounds(50,50, 1100,300);
        this.setLayout(new GridLayout(1,100));
        for(int i=1; i<=100; i++){
            valuesList.add(i);
        }
        Collections.shuffle(valuesList);

        for(int i=0; i<100; i++){
            barsList.add(new singleBar(valuesList.get(i)));
            this.add(barsList.get(i));
        }

    }

    public static class singleBar extends JProgressBar{
        singleBar(int value){
            this.setValue(value);
            this.setOrientation(JProgressBar.VERTICAL);
        }
    }
}
