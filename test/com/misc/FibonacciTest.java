package com.misc;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void testFibRecursive(){
        Assert.assertEquals(34, Fibonacci.getFibRecursive(8));
    }

    @Test
    public void testFibIterative(){
        Assert.assertEquals(34, Fibonacci.getFibIterative(8));
    }
    @Test
    public void testFibSpaceOptimized(){
        Assert.assertEquals(34, Fibonacci.getFibSpaceOptimized(8));
    }
}