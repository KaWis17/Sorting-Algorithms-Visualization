package com.company;

import java.awt.*;
import java.util.Collections;

public class quickSortAlg extends Thread{
    int swapCounter = 0;
    int comparisonCounter = 0;
    @Override
    public void run(){
        try {
            sorting(0, bars.valuesList.size()-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0; i<bars.valuesList.size(); i++){
            bars.barsList.get(i).setForeground(Color.green);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bodyAlg.enableChange();
    }


     void sorting(int first, int last) throws InterruptedException {
        if(first<last){
            int pivot = listPartition(first, last);
            sorting(first, pivot-1);
            sorting(pivot+1, last);
        }
    }


    int listPartition(int first, int last) throws InterruptedException {
        int pivotIndex = ((first+last)/2);
        Collections.swap(bars.valuesList, pivotIndex, last);
        bars.barsList.get(pivotIndex).setValue(bars.valuesList.get(pivotIndex));
        bars.barsList.get(last).setValue(bars.valuesList.get(last));

        int b = first;
        for(int a=first; a<=last; a++){
            comparisonCounter++;
            bodyAlg.description2.setText("Number of comparisons: "+comparisonCounter);
            bars.barsList.get(a).setForeground(Color.RED);
            bars.barsList.get(b).setForeground(Color.RED);
            Thread.sleep(2);
            bars.barsList.get(a).setForeground(Color.CYAN);
            bars.barsList.get(b).setForeground(Color.CYAN);

            if(bars.valuesList.get(a) < bars.valuesList.get(last)){
                Collections.swap(bars.valuesList, a,b);
                bars.barsList.get(a).setValue(bars.valuesList.get(a));
                bars.barsList.get(b).setValue(bars.valuesList.get(b));
                b++;
                swapCounter++;
                bodyAlg.description1.setText("Number of swaps: "+swapCounter);
            }
        }
        Collections.swap(bars.valuesList, b, last);
        bars.barsList.get(b).setValue(bars.valuesList.get(b));
        bars.barsList.get(last).setValue(bars.valuesList.get(last));
        bars.barsList.get(b).setForeground(Color.BLUE);
        return b;
    }
}

