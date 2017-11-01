package com.library.sort;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testMergeSort() {
        Integer[] s1 = new Integer[]{2,1,5,7,4,3,6,6,2};
        MergeSort.sort(s1);
        for (Integer i : s1) {
            System.out.println(i);
        }
    }

    @Test
    public void testMerge() {
        Integer[] s1 = new Integer[]{2,5,6};
        Integer[] s2 = new Integer[]{1,3,4,7};
        Integer[] s3 = new Integer[7];
        MergeSort.merge(s1,s2,s3);
        for (Integer i : s3) {
            System.out.println(i);
        }
    }
}