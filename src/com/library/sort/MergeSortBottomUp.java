package com.library.sort;

public class MergeSortBottomUp {
    public static void sort(int[] d) {
        int[] d1 = new int[d.length];
        int[] orig = d;
        int[] temp;
        for (int width = 1; width < d.length; width*=2) {
            for (int i = 0; i < d.length; i+=2*width) {
                merge(d,d1,i,width);
            }
            temp = d; d = d1; d1 = temp; //Swap role of d1 and d. Make d1 as source and d as destination
        }
        if (orig != d) {
            System.arraycopy(d,0,orig,0, orig.length);
        }
    }

    private static void merge(int[] src, int[] dest, int i, int width) {
        int left = i;
        int middle = Math.min(i + width, src.length);   //if size of array is not 2^n, this will allow to sort spill over elements
        int right = Math.min(i + 2*width, src.length);
        int index = i;
        int mIdx = middle;

        while (index < right) {
            if (mIdx == right || (left < middle && src[left] <= src[mIdx])) {
                dest[index++] = src[left++];
            }
            else {
                dest[index++] = src[mIdx++];
            }
        }
    }
}
