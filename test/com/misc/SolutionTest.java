package com.misc;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test(){
        int[] a = new int[]{1,2,3,4,5};
        Assert.assertEquals("", Solution.getRotation(5, 4, a));
    }

}