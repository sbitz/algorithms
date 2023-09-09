package com.stevebitzel;

public class MergeSort {

    public static int[] sort(int[] arr) {
        int mid = Math.floorDiv(arr.length-1, 2);
        mergeSort(arr, 0, mid, arr.length-1);
        return arr;
    }

    private static void mergeSort(int[] arr, int p, int q, int r) {
        if (q > p) {
            mergeSort(arr, p, p + Math.floorDiv(q - p, 2), q);
        }
        if (r > q+1) {
            mergeSort(arr, q+1, q+1+Math.floorDiv(r-q-1, 2), r);
        }
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r - q;
        int[] leftArr = new int[n1+1];
        int[] rightArr = new int[n2+1];
        int i;
        for (i = 0; i < n1; i++) {
            leftArr[i] = arr[p + i];
        }
        int j;
        for (j = 0; j < n2; j++) {
            rightArr[j] = arr[q+1+j];
        }
        leftArr[n1] = Integer.MAX_VALUE;
        rightArr[n2] = Integer.MAX_VALUE;

        i = 0;
        j = 0;

        for (int k = p; k <= r; k++) {
            if (leftArr[i] <= rightArr[j])
                arr[k] = leftArr[i++];
            else
                arr[k] = rightArr[j++];
        }
    }
}
