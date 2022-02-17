package com.company;

import javax.swing.*;
import java.util.Collections;

public class menuBar extends JMenuBar{
    static int nrSort;
    menuBar(){
        JMenu chooseAlg = new JMenu("Choose sorting algorithm");
        JMenuItem quickSort = new JMenuItem("QuickSort");
        JMenuItem bubbleSort = new JMenuItem("BubbleSort");
        JMenuItem mergeSort = new JMenuItem("MergeSort");
        JMenu reset = new JMenu("Reset");
        JMenuItem iReset = new JMenuItem("Reset");
        JMenu help = new JMenu("Help");
        JMenuItem iHelp = new JMenuItem("Help");

        quickSort.addActionListener(e -> setQuickSort());
        bubbleSort.addActionListener(e -> setBubbleSort());
        mergeSort.addActionListener(e -> setMergeSort());
        iReset.addActionListener(e -> shuffle());
        iHelp.addActionListener(e -> placeholder());

        this.add(chooseAlg);
            chooseAlg.add(quickSort);
            chooseAlg.add(bubbleSort);
            chooseAlg.add(mergeSort);
        this.add(reset);
            reset.add(iReset);
        this.add(help);
            help.add(iHelp);
    }


    private void setQuickSort(){
        aboutAlg.title.setText("QuickSort");
        aboutAlg.descWorst.changeText("Worst: O(n^2)");
        aboutAlg.descAver.changeText("Average: Θ(n log(n))");
        aboutAlg.descBest.changeText("Best: Ω(n log(n))");
        shuffle();

    }

    private void setBubbleSort(){
        aboutAlg.title.setText("BubbleSort");
        aboutAlg.descWorst.changeText("Worst: O(n^2)");
        aboutAlg.descAver.changeText("Average: Θ(n^2)");
        aboutAlg.descBest.changeText("Best: Ω(n)");
        shuffle();
        nrSort=2;
    }

    private void setMergeSort(){
        aboutAlg.title.setText("MergeSort");
        aboutAlg.descWorst.changeText("Worst: O(n log(n))");
        aboutAlg.descAver.changeText("Average: Θ(n log(n))");
        aboutAlg.descBest.changeText("Best: Ω(n log(n))");
        shuffle();
    }

    private void shuffle(){
        Collections.shuffle(bars.valuesList);
        for(int i=0; i<100; i++){
            bars.barsList.get(i).setValue(bars.valuesList.get(i));
        }
    }
    private void placeholder(){
        JOptionPane.showMessageDialog(null, "OK Boomer!");
    }
}
