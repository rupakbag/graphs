package com.library.divideNconquer;

import java.util.Arrays;

public class MergeAndInversionCount {
    public static int getInversion(int[] input) {
        return sortAndCount(input);
    }

    private static int sortAndCount(int[] i) {
        if (i.length == 1) return 0;
        int mid = i.length / 2;

        int[] a = Arrays.copyOfRange(i, 0, mid);
        int[] b = Arrays.copyOfRange(i, mid, i.length);

        return sortAndCount(a) + sortAndCount(b) + mergeAndCount(a, b, i);
    }

    private static int mergeAndCount(int[] a, int[] b, int[] c) {
        int aIndex = 0, bIndex = 0;
        int inv = 0;

        while (aIndex + bIndex != c.length) {
            if (aIndex == a.length) {
                c[aIndex + bIndex] = b[bIndex++];
            }
            else if (bIndex < b.length && b[bIndex] < a[aIndex]) {
                c[aIndex + bIndex] = b[bIndex++];
                inv += (a.length - aIndex);
            }
            else {
                c[aIndex + bIndex] = a[aIndex++];
            }
        }
        return inv;
    }
}
