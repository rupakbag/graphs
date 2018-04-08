package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class SubsetSumTest {
    @Test
    public void test(){
        int[] weight = new int[]{3, 34, 4, 12, 5, 2};
        SubsetSum ss = new SubsetSum(weight, 9);
        Assert.assertEquals(true, ss.isSubset());
    }

    @Test
    public void test1(){
        int[] weight = new int[]{3, 34, 4, 12, 5, 2};
        SubsetSum ss = new SubsetSum(weight, 10);
        Assert.assertEquals(true, ss.isSubset());
    }

    @Test
    public void test3(){
        int[] weight = new int[]{3, 5, 2};
        SubsetSum ss = new SubsetSum(weight, 7);
        Assert.assertEquals(true, ss.isSubset());
    }
}