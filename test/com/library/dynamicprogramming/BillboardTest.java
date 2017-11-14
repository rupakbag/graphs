package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class BillboardTest {
    Billboard bb;

    @Test
    public void testMaxRevenue() {
        int [] sites = new int[]{6,7,12,14};
        int [] revenue = new int[]{5,6,5,1};

        bb = new Billboard(sites, revenue, 5);
        Assert.assertEquals(10, bb.getMaxRevenue());
    }

    @Test
    public void testMaxRevenue1() {
        int [] sites = new int[]{2,3,10,14,16,20};
        int [] revenue = new int[]{5,6,5,7,5,5};

        bb = new Billboard(sites, revenue, 5);
        Assert.assertEquals(18, bb.getMaxRevenue());
    }

}