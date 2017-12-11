package com.library.divideNconquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeAndInversionCountTest {
    @Test
    public void test1() {
        int[] input = new int[] {3,2,1};
        Assert.assertEquals(6, MergeAndInversionCount.getInversion(input));
        System.out.println(Arrays.toString(input));
    }
}