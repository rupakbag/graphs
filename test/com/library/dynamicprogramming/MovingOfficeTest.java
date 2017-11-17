package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MovingOfficeTest {
    MovingOffice mo;
    @Test
    public void testMovingOffice(){
        int[] NY = new int[]{2,2,1,2};
        int[] SF = new int[]{1,1,2,1};
        mo = new MovingOffice(NY, SF, 10);
        Assert.assertEquals(20, mo.getMovingCost());
    }
}