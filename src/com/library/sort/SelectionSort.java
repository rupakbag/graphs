package com.library.sort;

public class SelectionSort {
    public static void sort(int[] data) {
        for (int i = 0; i<data.length;i++){
            int min = data[i];
            int minIdx = i;
            for (int j = i + 1; j<data.length;j++){
                if (min > data[j]) {
                    min = data[j];
                    minIdx = j;
                }
            }
            swap(data,i,minIdx);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
