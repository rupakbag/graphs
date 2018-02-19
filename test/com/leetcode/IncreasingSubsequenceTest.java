package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class IncreasingSubsequenceTest {

    @Test
    public void test1(){
        int[] input = new int[] {4, 6, 7, 7};
        Assert.assertEquals("", IncreasingSubsequence.getSequence(input));
    }
}