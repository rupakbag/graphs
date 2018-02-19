package com.library.sort;

public class InsertionSort {
    public static void sort(int[] data){
        int c = 1;
        while (c < data.length) {
            int c1 = c;
            while (c >= 1 && data[c] < data[c - 1]) {
                swap(data, c);
                c--;
            }
            c = c1 + 1;
        }
    }

    private static void swap(int[]data, int index) {
        int temp = data[index-1];
        data[index - 1] = data[index];
        data[index] = temp;
    }

    //Slightly more efficient
    //Does partial swap
    public static void sort1(int[] data){
        int c = 1;
        while (c < data.length) {
            int cVal = data[c];
            int c1 = c;
            while (c >= 1 && cVal<data[c-1]){
                data[c] = data[c-1];
                c--;
            }
            data[c] = cVal;
            c = c1 + 1;
        }
    }
}
