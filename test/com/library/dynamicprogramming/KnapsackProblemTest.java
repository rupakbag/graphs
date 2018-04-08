package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class KnapsackProblemTest {
    KnapsackProblem ksp;
    @Test
    public void testOptimalSolution(){
        int[] weight = new int[]{10,5,7,8,5,9};
        this.ksp = new KnapsackProblem(weight,20);
        Assert.assertEquals(20, ksp.getOpt());
    }

    @Test
    public void testOptimalSolution1(){
        int[] weight = new int[]{2,2,3};
        this.ksp = new KnapsackProblem(weight,6);
        Assert.assertEquals(5, ksp.getOpt());
    }
}