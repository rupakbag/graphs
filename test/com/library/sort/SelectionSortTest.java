package com.library.sort;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void test() {
        int[] data = new int[]{2, 5, 4, 3, 1};
        SelectionSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}