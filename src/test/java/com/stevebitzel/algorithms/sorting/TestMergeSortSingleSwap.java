package com.stevebitzel.algorithms.sorting;

import java.util.*;

import com.stevebitzel.algorithms.sorting.MergeSort;
import com.stevebitzel.algorithms.sorting.MergeSortSingleSwap;
import org.junit.jupiter.api.Test;

public class TestMergeSortSingleSwap {

    @Test
    void foo() {
        int size = 100;
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

        int[] result = MergeSortSingleSwap.sort(bar);
        for (int i = 0; i < size; i++) {
            assert result[i] == i;
        }
    }

    @Test
    void foo2() {
        int size = 100;
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

        int[] result = MergeSort.sort(bar);
        for (int i = 0; i < size; i++) {
            assert result[i] == i;
        }
    }
}
