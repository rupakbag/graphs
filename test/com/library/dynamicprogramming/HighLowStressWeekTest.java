package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class HighLowStressWeekTest {
    HighLowStressWeek hlsw;
    @Test
    public void testOptimalSolution() {
        int[] lowStress = new int[]{10,1,10,10};
        int[] highStress = new int[]{5,50,5,1};
        hlsw = new HighLowStressWeek(highStress, lowStress);
        Assert.assertEquals(70, hlsw.getOptimalSolution());
    }
}