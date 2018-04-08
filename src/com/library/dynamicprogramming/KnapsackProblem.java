package com.library.dynamicprogramming;

/*
* Page 271: Algorithm Design
*/

public class KnapsackProblem {
    private final int W;
    private final int[] weight;
    private final int[][] optValues;

    public KnapsackProblem(int[] weight, int W) {
        this.W = W;
        this.weight = weight;
        optValues = new int[weight.length][W + 1];
    }

    // O(nW) :  Order of RequestList Size x Knapsack weight
    public int getOpt() {
        for(int i = 0; i < this.weight.length; i++){
            for (int w = 0; w <= W; w++) {
                this.optValues[i][w] = _opt(i,w);
            }
        }
        printOptimalSet(weight.length - 1, W);
        return optValues[weight.length - 1][W];
    }

    // O(n) : Order of RequestList Size
    private void printOptimalSet(int i, int w) {
        if (i == -1) return;
        if (weight[i] <= w && (weight[i] + _opt(i - 1, w - weight[i])) > _opt(i - 1, w)) {
            System.out.println(weight + " ");
            printOptimalSet(i - 1, w - weight[i]);
        }
        else {
            printOptimalSet(i - 1, w);
        }
    }

    private int _opt(int i, int w) {
        if (i == -1 || w == 0) return 0;
        if (optValues[i][w] != 0) return optValues[i][w];

        int currentIndexWeight = weight[i];
        int weightExcluded = _opt(i - 1, w);
        if (currentIndexWeight > w) return weightExcluded;
        int weightIncluded =  currentIndexWeight + _opt(i - 1, w - currentIndexWeight);
        return Math.max(weightIncluded, weightExcluded);
    }
}
