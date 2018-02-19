package com.library.sort;

import org.junit.Test;

public class MergeSortBottomUpTest {
    @Test
    public void test_array_size_power_of_2(){
        int[] s1 = new int[]{2,1,5,7,4,3,6,6}; //Size 8 (2^4)
        MergeSortBottomUp.sort(s1);
        for (Integer i : s1) {
            System.out.println(i);
        }
    }

    @Test
    public void test_array_size_NOT_power_of_2(){
        int[] s1 = new int[]{2,1,5,7,4,3,6,6,0,9,12};
        MergeSortBottomUp.sort(s1);
        for (Integer i : s1) {
            System.out.println(i);
        }
    }
}