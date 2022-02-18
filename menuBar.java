package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

import static java.lang.StrictMath.abs;

public class menuBar extends JMenuBar{
    static int nrSort = 1;
    static JMenuItem quickSort = new JMenuItem("QuickSort");
    static JMenuItem bubbleSort = new JMenuItem("BubbleSort");
    static JMenuItem mergeSort = new JMenuItem("MergeSort");
    //static JMenuItem editLength = new JMenuItem("Edit length");
    static JMenuItem editSpeed = new JMenuItem("Edit speed");
    static JMenuItem reset = new JMenuItem("Set shuffled");
    static JMenuItem sorted = new JMenuItem("Set sorted");
    static JMenuItem reversed = new JMenuItem("Set reversed");

    menuBar(){
        JMenu chooseAlg = new JMenu("Choose algorithm");
        JMenu edit = new JMenu("Edit");
        JMenu setArray = new JMenu("Set array");
        JMenu help = new JMenu("Help");
        JMenuItem iHelp = new JMenuItem("Help");


        quickSort.addActionListener(e -> setQuickSort());
        bubbleSort.addActionListener(e -> setBubbleSort());
        mergeSort.addActionListener(e -> setMergeSort());
        //editLength.addActionListener(e -> setLength());
        editSpeed.addActionListener(e -> setSpeed());
        reset.addActionListener(e -> shuffle());
        sorted.addActionListener(e -> setSorted());
        reversed.addActionListener(e -> setReversed());
        iHelp.addActionListener(e -> placeholder());

        this.add(chooseAlg);
            chooseAlg.add(quickSort);
            chooseAlg.add(bubbleSort);
            chooseAlg.add(mergeSort);
        this.add(edit);
            //edit.add(editLength);
            edit.add(editSpeed);
        this.add(setArray);
            setArray.add(reset);
            setArray.add(sorted);
            setArray.add(reversed);
        this.add(help);
            help.add(iHelp);
    }

    private void shuffle(){
        Collections.shuffle(bars.valuesList);
        for(int i=0; i<bars.lengthOfAnArray; i++){
            bars.barsList.get(i).setValue(bars.valuesList.get(i));
            bars.barsList.get(i).setForeground(Color.CYAN);
        }
    }

    private void setQuickSort(){
        aboutAlg.title.setText("QuickSort");
        aboutAlg.descWorst.changeText("Worst: O(n^2)");
        aboutAlg.descAver.changeText("Average: Θ(n log(n))");
        aboutAlg.descBest.changeText("Best: Ω(n log(n))");
        shuffle();
        nrSort = 1;
    }

    private void setBubbleSort(){
        aboutAlg.title.setText("BubbleSort");
        aboutAlg.descWorst.changeText("Worst: O(n^2)");
        aboutAlg.descAver.changeText("Average: Θ(n^2)");
        aboutAlg.descBest.changeText("Best: Ω(n)");
        shuffle();
        nrSort = 2;
    }

    private void setMergeSort(){
        aboutAlg.title.setText("MergeSort");
        aboutAlg.descWorst.changeText("Worst: O(n log(n))");
        aboutAlg.descAver.changeText("Average: Θ(n log(n))");
        aboutAlg.descBest.changeText("Best: Ω(n log(n))");
        shuffle();
        nrSort = 3;
    }
    /*
    private void setLength(){
        bars.lengthOfAnArray = Integer.parseInt(JOptionPane.showInputDialog("How long array would you like?\nDefault is 100 elements\nCurrent is "+bars.lengthOfAnArray+" elements\nInput positive int:"));
        bars.barsList.clear();
        bars.valuesList.clear();
    }
    */
    private void setSpeed(){
        bars.sortingSpeed = abs(Integer.parseInt(JOptionPane.showInputDialog("What sorting speed would you like (in ms)? \nDefault is 3ms\nCurrent is "+bars.sortingSpeed+"ms\nInput positive int:")));
    }

    public void setSorted(){
        for(int i=0; i<bars.lengthOfAnArray; i++){
            bars.valuesList.set(i, i+1);
            bars.barsList.get(i).setValue(i+1);
            bars.barsList.get(i).setForeground(Color.CYAN);
        }
    }

    private void setReversed(){
        for(int i=0; i<bars.lengthOfAnArray; i++){
            bars.valuesList.set(i, bars.lengthOfAnArray-i);
            bars.barsList.get(i).setValue(bars.lengthOfAnArray-i);
            bars.barsList.get(i).setForeground(Color.CYAN);
        }
    }

    public static void disableChange(){
        bodyAlg.start.setEnabled(false);
        quickSort.setEnabled(false);
        bubbleSort.setEnabled(false);
        mergeSort.setEnabled(false);
        reset.setEnabled(false);
        sorted.setEnabled(false);
        reversed.setEnabled(false);

    }

    public static void enableChange(){
        bodyAlg.start.setEnabled(true);
        quickSort.setEnabled(true);
        bubbleSort.setEnabled(true);
        mergeSort.setEnabled(true);
        reset.setEnabled(true);
        sorted.setEnabled(true);
        reversed.setEnabled(true);
    }

    private void placeholder(){
        JOptionPane.showMessageDialog(null, "OK Boomer!");
    }
}
