package com.library.sort;

//O(nlogn) Best case / Average case / Expected time complexity in Randomised quick sort
//O(n^2)   Worst Case in non randomised quick sort
//Non Stable sort, In place sort
//Choosing the median as pivot will guarantee O(nlogn) but finding median is O(n). Significant overhead.
//Quick Sort outperforms both heap-sort and merge-sort on many tests

import java.util.Random;

public class RandomizedQuickSortInPlace {
    public static void sort(int[] d) {
        _qSort(d, 0, d.length - 1);
    }

    private static void _qSort(int[] d, int i, int j) {
        if (j <= i) return;
        swap(d, i, getRandomPivotIndex(i,j));
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

    private static int getRandomPivotIndex(int i, int j){
        Random r = new Random();
        return i + r.nextInt(j - i + 1);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
