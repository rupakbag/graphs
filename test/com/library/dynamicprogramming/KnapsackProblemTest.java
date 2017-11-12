package com.library.dynamicprogramming;

import com.library.dynamicprogramming.KnapsackProblem.REQ;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnapsackProblemTest {
    KnapsackProblem ksp;
    REQ req1,req2,req3,req4, req5, req6, req7, req8, req9;

    @Before
    public void setUp() throws Exception {
        this.req1 = new REQ(10);
        this.req2 = new REQ(17);
        this.req3 = new REQ(7);
        this.req4 = new REQ(8);
        this.req5 = new REQ(5);
        this.req6 = new REQ(9);

        this.req7 = new REQ(2);
        this.req8 = new REQ(2);
        this.req9 = new REQ(3);
    }

    @Test
    public void testOptimalSolution(){
        this.ksp = new KnapsackProblem(20);
        ksp.addRequest(req1);
        ksp.addRequest(req2);
        ksp.addRequest(req3);
        ksp.addRequest(req4);
        ksp.addRequest(req5);
        ksp.addRequest(req6);
        Assert.assertEquals(20, ksp.getOpt());
    }

    @Test
    public void testOptimalSolution1(){
        this.ksp = new KnapsackProblem(6);
        ksp.addRequest(req7);
        ksp.addRequest(req8);
        ksp.addRequest(req9);
        Assert.assertEquals(5, ksp.getOpt());
    }
}