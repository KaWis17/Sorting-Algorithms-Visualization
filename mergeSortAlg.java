package com.company;

import java.awt.*;
import java.util.ArrayList;

public class mergeSortAlg extends Thread {

    int comparisonCounter =0;
    @Override
    public void run() {
        bodyAlg.description1.setText("Number of comparisons: ???");

        try {
            sorting(0, bars.valuesList.size() - 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new sortedAnimation().start();
    }

    private void sorting(int start, int end) throws InterruptedException {
        if(start>=end){
            return;
        }

        int middle = (end + start)/2;
        bars.barsList.get(middle).setForeground(Color.blue);
        Thread.sleep(bars.sortingSpeed);
        sorting(start, middle);
        sorting(middle+1, end);
        bars.barsList.get(middle).setForeground(Color.CYAN);
        mergeList(start,middle,end);

    }

    private void mergeList(int start, int middle, int end) throws InterruptedException {
        ArrayList<Integer> mergedSorted = new ArrayList<>();

        int firstIndex = start;
        int secondIndex = middle+1;

        while(firstIndex<=middle && secondIndex<=end){
            if(bars.valuesList.get(firstIndex)<bars.valuesList.get(secondIndex)){
                mergedSorted.add(bars.valuesList.get(firstIndex));
                firstIndex++;
            }else{
                mergedSorted.add(bars.valuesList.get(secondIndex));
                secondIndex++;
            }
        }

        //only one of them will execute
        while(firstIndex <= middle){
            mergedSorted.add(bars.valuesList.get(firstIndex));
            firstIndex++;
        }
        while(secondIndex <= end){
            mergedSorted.add(bars.valuesList.get(secondIndex));
            secondIndex++;
        }

        int i = 0;
        int j = start;
        while(i<mergedSorted.size()){
            comparisonCounter++;
            bodyAlg.description2.setText("Number of comparisons: "+comparisonCounter);
            Thread.sleep(bars.sortingSpeed);
            bars.valuesList.set(j, mergedSorted.get(i++));
            bars.barsList.get(j).setValue(bars.valuesList.get(j));
            j++;
        }
    }
}
