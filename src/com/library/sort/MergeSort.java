package com.library.sort;

import java.util.Arrays;
import java.util.Comparator;

//O(nlogn) time complexity all cases since data is partitioned into 2 equal sizes if size is a power of 2
//O(n) space complexity because of merge
//Stable sort
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

    protected static <T extends Comparable<T>> void merge(T[] s1, T[] s2, T[] s3) {
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

    public static <T> void sort(T[] s, Comparator<T> c) {
        if (s.length == 1) return;
        int mid = s.length / 2;

        T[] s1 = Arrays.copyOfRange(s, 0, mid);
        T[] s2 = Arrays.copyOfRange(s, mid, s.length);

        sort(s1, c);
        sort(s2, c);
        merge(s1, s2, s, c);
    }

    public static <T> void merge(T[] s1, T[] s2, T[] s3, Comparator<T> c) {
        int s1Index = 0;
        int s2Index = 0;

        while (s1Index + s2Index != s3.length) {
            if (s2Index == s2.length || (s1Index < s1.length && c.compare(s1[s1Index], (s2[s2Index])) < 0)) {
                s3[s1Index + s2Index] = s1[s1Index++];
            } else {
                s3[s1Index + s2Index] = s2[s2Index++];
            }
        }
    }
}
