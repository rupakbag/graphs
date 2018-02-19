package com.library.sort;

public class QuickSort {
    public static void sort(int[] d) {
        _qSort(d, 0, d.length - 1);
    }

    private static void _qSort(int[] d, int i, int j) {
        if (j <= i) return;
        int pivot = d[i];
        int s = i+1;
        int e = j;

        while (s <= e) {
            while (s <= e && d[s] < pivot) s++;
            while (s <= e && d[e] > pivot) e--;
            if (s <= e) {
                swap(d,s,e);
                s++; e--;
            }
        }
        swap(d,i,e);
        _qSort(d,i,e-1);
        _qSort(d,e+1,j);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
