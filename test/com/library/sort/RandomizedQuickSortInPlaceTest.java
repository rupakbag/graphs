package com.library.sort;

import org.junit.Test;

public class RandomizedQuickSortInPlaceTest {
    @Test
    public void test(){
        int[] data = new int[]{2,5,4,3,10,12,7,9,6};
        RandomizedQuickSortInPlace.sort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}