package com.library.sort;

import org.junit.Test;

public class InsertionSortTest {
    @Test
    public void test(){
        int[] data = new int[]{2,5,4,3,1};
        InsertionSort.sort1(data);
        for (int i = 0; i<data.length; i++) {
            System.out.println(data[i]);
        }
    }
}