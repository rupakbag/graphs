package com.library.sort;

import java.util.Arrays;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] s) {
        if (s.length == 1) return;
        int mid = s.length / 2;

        T[] s1 = Arrays.copyOfRange(s, 0, mid);
        T[] s2 = Arrays.copyOfRange(s, mid, s.length);

        sort(s1);
        sort(s2);
        merge(s1, s2, s);
    }

    public static <T extends Comparable<T>> void merge(T[] s1, T[] s2, T[] s3) {
        int s1Index = 0;
        int s2Index = 0;

        while (s1Index + s2Index != s3.length) {
            if (s2Index == s2.length || (s1Index < s1.length && s1[s1Index].compareTo(s2[s2Index]) < 0)) {
                s3[s1Index + s2Index] = s1[s1Index++];
            } else {
                s3[s1Index + s2Index] = s2[s2Index++];
            }
        }
    }
}
