package com.library.divideNconquer;

// Algo Design Book Solved Exercise 2 (Page 244)
// T(n) = 2 T(n/2) + O(n) => O(nlogn)
public class MaximiseStockProfit {
    public static int getMaxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        return _getMaxProfit(prices, 0, prices.length - 1);
    }

    private static int _getMaxProfit(int[] prices, int i, int j) {
        if (i == j) return 0;

        int mid = i + ((j - i)/2);

        int p1 = _getMaxProfit(prices, i, mid);
        int p2 = _getMaxProfit(prices, mid + 1, j);
        int p3 = getMax(prices, mid + 1, j) - getMin(prices, i, mid);

        return (Math.max(p1, Math.max(p2, p3)));
    }

    private static int getMin(int[] prices, int i, int j) {
        int ret = prices[i];
        for (int k = i + 1; k <= j; k++) {
            if (ret > prices[k]) ret = prices[k];
        }
        return ret;
    }

    private static int getMax(int[] prices, int i, int j) {
        int ret = prices[i];
        for (int k = i + 1; k <= j; k++) {
            if (ret < prices[k]) ret = prices[k];
        }
        return ret;
    }
}
