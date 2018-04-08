package com.library.divideNconquer;

import org.junit.Assert;
import org.junit.Test;

public class MaximiseStockProfitTest {
    @Test
    public void test1(){
        int[] prices = new int[]{1,2,3,4,5,4,2};
        Assert.assertEquals(4, MaximiseStockProfit.getMaxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = new int[]{3, 2, 1, 2, 3, 4, 5};
        Assert.assertEquals(4, MaximiseStockProfit.getMaxProfit(prices));
    }

    @Test
    public void test3(){
        int[] prices = new int[]{1,2,3,4,3,2,1,2,3,4,5,6,7};
        Assert.assertEquals(6, MaximiseStockProfit.getMaxProfit(prices));
    }
    @Test
    public void test4(){
        int[] prices = new int[]{7,1,5,3,6,4};
        Assert.assertEquals(5, MaximiseStockProfit.getMaxProfit(prices));
    }
}