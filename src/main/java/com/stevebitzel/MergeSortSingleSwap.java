package com.stevebitzel;

public class MergeSortSingleSwap {

    public static int[] sort(int[] ts) {
        final int[] swap = new int[ts.length + 2];

        int midIndex = Math.floorDiv((ts.length-1), 2);
        return mergeSort(ts, swap, 0, midIndex, ts.length-1);
    }

    private static int[] mergeSort(int[] array, int[] swap, int start, int mid, int last) {
        if (mid > start) {
            mergeSort(array, swap, start, (start + Math.floorDiv(mid - start - 1, 2)), mid);
        }

        if (last - mid > 1) {
            mergeSort(array, swap, mid+1, mid + Math.floorDiv(last - mid, 2), last);
        }

        merge(array, swap, start, mid, last);
        return array;
    }

    private static void merge(int[] array, int[] swap, int p, int q, int r) {
        int leftSize = q - p + 1;
        for (int i= 0; i< leftSize; i++) {
            swap[i] = array[p + i];
        }
        swap[leftSize] = Integer.MAX_VALUE;

        int rightStart = leftSize+1;
        int rightSize = r-q;

        for (int i= 0; i < rightSize; i++) {
            swap[rightStart + i] = array[q+i+1];
        }
        swap[leftSize + rightSize + 1] = Integer.MAX_VALUE;

        int left = 0;
        int right = rightStart;

        for (int n = p; n <= r; n++ ) {
            if (swap[left] < swap[right]) {
                array[n] = swap[left++];
            } else {
                array[n] = swap[right++];
            }
        }
    }
}
