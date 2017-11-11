package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnapsackProblemTest {
    KnapsackProblem ksp;
    KnapsackProblem.REQ req1,req2,req3,req4;

    @Before
    public void setUp() throws Exception {
        this.ksp = new KnapsackProblem(20);
        this.req1 = new KnapsackProblem.REQ(5);
        this.req2 = new KnapsackProblem.REQ(2);
        this.req3 = new KnapsackProblem.REQ(9);
        this.req4 = new KnapsackProblem.REQ(7);
    }

    @Test
    public void testOptimalSolution(){
        ksp.addRequest(req1);
        ksp.addRequest(req2);
        ksp.addRequest(req3);
        ksp.addRequest(req4);
        Assert.assertEquals(20, ksp.getOpt());
    }
}