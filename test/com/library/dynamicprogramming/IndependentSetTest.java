package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class IndependentSetTest {
    IndependentSet is;
    @Test
    public void testIndependentSet(){
        is = new IndependentSet(new int[]{1,8,6,3,6});
        Assert.assertEquals(14, is.getIntependentSetWeight());
    }
}