package com.library.divideNconquer;

import org.junit.Assert;
import org.junit.Test;

public class FindPeakTest {
    @Test
    public void testFindPeak(){
        int[] input = new int[]{1,2,3,4,5,6,7,8,3};
        FindPeak fp = new FindPeak(input);
        Assert.assertEquals(7, fp.findPeakIndex());
    }
}