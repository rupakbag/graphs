package com.library.divideNconquer;

public class MaximiseStockProfit {
    public int getMaxProfit() {
        return getValue(_getMaxProfit(prices, 0, prices.length -1));
    }

    private int[] prices;

    public MaximiseStockProfit(int[] prices) {
        this.prices = prices;
    }

    private int getValue(Pair pair) {
        return prices[pair.max] - prices[pair.min];
    }

    private Pair _getMaxProfit(int[] prices, int i, int j) {
        if (i + 1 == j) {
            if (prices[i] < prices[j]) return new Pair(i,j);
            return new Pair(j,i);
        }
        if (i == j) {
            return new Pair(i,j);
        }

        int mid = i + (j - i) / 2;

        Pair p1 = _getMaxProfit(prices, i, mid);
        Pair p2 = _getMaxProfit(prices, mid + 1, j);
        Pair p3 = new Pair(p1.min, p2.max);
        if (getValue(p1) > getValue(p2)) {
            return getValue(p1) > getValue(p3) ? p1 : p3;
        } else {
            return getValue(p2) > getValue(p3) ? p2 : p3;
        }
    }

    private class Pair {
        int min;
        int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
