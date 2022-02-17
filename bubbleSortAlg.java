package com.company;


import java.awt.*;
import java.util.Collections;

public class bubbleSortAlg extends Thread {
    @Override
    public void run() {
        boolean isSwapped;
        int swapCounter = 0;
        int comparisonCounter = 0;
        for (int i = 0; i < bars.valuesList.size() - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < bars.valuesList.size() - i - 1; j++) {
                bars.barsList.get(j).setForeground(Color.RED);
                bars.barsList.get(j + 1).setForeground(Color.RED);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (bars.valuesList.get(j) > bars.valuesList.get(j + 1)) {
                    bars.barsList.get(j).setValue(bars.valuesList.get(j + 1));
                    bars.barsList.get(j + 1).setValue(bars.valuesList.get(j));
                    Collections.swap(bars.valuesList, j, j + 1);
                    isSwapped = true;
                    swapCounter++;
                    bodyAlg.description1.setText("Number of swaps: "+swapCounter);

                }
                bars.barsList.get(j).setForeground(Color.CYAN);
                bars.barsList.get(j + 1).setForeground(Color.CYAN);
                comparisonCounter++;
                bodyAlg.description2.setText("Number of comparisons: "+comparisonCounter);
            }
            if (!isSwapped) {
                bodyAlg.start.setEnabled(true);
                break;
            }
        }
        bodyAlg.start.setEnabled(true);
    }
}