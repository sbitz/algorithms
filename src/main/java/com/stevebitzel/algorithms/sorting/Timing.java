package com.stevebitzel.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Timing {

    public static void main(String[] args) {

        for (int size : new int[] {100, 200, 400, 800, 2000, 4000, 8000, 16000, 30000, 100000, 200000, 500000, 1000000}) {
            int[] input = setup(size);
            long start = System.nanoTime();
            MergeSort.sort(input);
            long end = System.nanoTime();
            System.out.println("MergeSort took: \t\t\t" + (end-start) + "ns to sort " + size + " elements");

            start = System.nanoTime();
            MergeSort.sort(input);
            end = System.nanoTime();
            System.out.println("MergeSortSingleSwap took: \t" + (end-start) + "ns to sort " + size + " elements");
        }

        // todo:
        //  1. run multiple times, provide the average run
        //  2. format the output better
        //  3. graph the output to show the comparison
        //  4. pre-load to reduce bias for the jvm loading
        //  5. run over time to possibly see impact of GC




    }

    private static int[] setup(int size) {
        ArrayList<Integer> foo = new ArrayList<>(size);
        for (int i= 0; i < size; i++) {
            foo.add(i, i);
        }

        Collections.shuffle(foo);
        Iterator<Integer> it = foo.iterator();

        int[] bar = new int[size];
        for (int i= 0; i < size; i++) {
            bar[i] = it.next();
        }
        return bar;
    }
}
