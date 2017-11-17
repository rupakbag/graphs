package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class MovingOfficeTest {
    MovingOffice mo;
    @Test
    public void testMovingOffice(){
        int[] NY = new int[]{10,5,7,9};
        int[] SF = new int[]{50,2,2,2};
        mo = new MovingOffice(NY, SF, 10);
        Assert.assertEquals(26, mo.getMovingCost());
    }

    @Test
    public void testMovingOffice1(){
        int[] NY = new int[]{1,3,20,30};
        int[] SF = new int[]{50,20,2,4};
        mo = new MovingOffice(NY, SF, 10);
        Assert.assertEquals(20, mo.getMovingCost());
    }
}