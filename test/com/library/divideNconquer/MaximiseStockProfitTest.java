package com.library.divideNconquer;

import org.junit.Assert;
import org.junit.Test;

public class MaximiseStockProfitTest {
    @Test
    public void test1(){
        int[] prices = new int[]{1,2,3,4,5,4,2};
        MaximiseStockProfit mf = new MaximiseStockProfit(prices);
        Assert.assertEquals(4, mf.getMaxProfit());
    }

    @Test
    public void test2() {
        int[] prices = new int[]{3, 2, 1, 2, 3, 4, 5};
        MaximiseStockProfit mf = new MaximiseStockProfit(prices);
        Assert.assertEquals(4, mf.getMaxProfit());
    }

    @Test
    public void test3(){
        int[] prices = new int[]{1,2,3,4,3,2,1,2,3,4,5,6,7};
        MaximiseStockProfit mf = new MaximiseStockProfit(prices);
        Assert.assertEquals(6, mf.getMaxProfit());
    }
}