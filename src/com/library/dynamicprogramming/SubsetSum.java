package com.library.dynamicprogramming;

public class SubsetSum {
    private final int sum;
    private final int[] set;
    private final boolean[][] optValues;

    public SubsetSum(int[] set, int sum) {
        this.set = set;
        this.sum = sum;
        this.optValues = new boolean[set.length + 1][sum + 1];
    }

    public boolean isSubset(){
        for (int i = 1; i <= sum; i++) optValues[0][i] = false;
        for (int i = 0; i <= set.length; i++) optValues[i][0] = true;

        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++) {
                optValues[i][j] = optValues[i-1][j];
                if (j - set[i - 1] >= 0) {
                    optValues[i][j] |= optValues[i - 1][j - set[i - 1]];
                }
            }
        }
        return optValues[set.length][sum];
    }
}
