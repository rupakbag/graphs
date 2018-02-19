package com.library.sort;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test(){
        int[] data = new int[]{2,5,4,3};
        QuickSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}