package com.company;

import java.awt.*;

public class sortedAnimation extends Thread{
    @Override
    public void run(){
        for(int i=0; i<bars.valuesList.size(); i++){
            bars.barsList.get(i).setForeground(Color.green);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        menuBar.enableChange();
    }
}
