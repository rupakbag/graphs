package com.library.misc;

import org.junit.Assert;
import org.junit.Test;

public class FindKthSmallestTest {
    @Test
    public void test(){
        Assert.assertEquals(5, FindKthSmallest.find(new int[]{2,4,5,1,6},4));
    }

    @Test
    public void test1(){
        Assert.assertEquals(2, FindKthSmallest.find(new int[]{2,2,4,5,1,6},3));
    }
}