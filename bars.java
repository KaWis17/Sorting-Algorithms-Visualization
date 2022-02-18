package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class bars extends JPanel {
    static int lengthOfAnArray = 100;
    static int sortingSpeed = 3;
    static ArrayList<bars.singleBar> barsList = new ArrayList<>();
    static ArrayList<Integer> valuesList = new ArrayList<>();

    bars(){
        this.setBounds(15,25, 1150,400);
        initialiseAnArray();

    }

    public static class singleBar extends JProgressBar{
        singleBar(int value){
            this.setValue(value);
            this.setOrientation(JProgressBar.VERTICAL);
            this.setForeground(Color.CYAN);
            this.setBorder(null);
            this.setMaximum(lengthOfAnArray);
        }
    }

    public void initialiseAnArray(){
        this.setLayout(new GridLayout(1,lengthOfAnArray));
        for(int i=1; i<=lengthOfAnArray; i++){
            valuesList.add(i);
        }
        Collections.shuffle(valuesList);

        for(int i=0; i<lengthOfAnArray; i++){
            barsList.add(new singleBar(valuesList.get(i)));
            this.add(barsList.get(i));
        }
    }
}
