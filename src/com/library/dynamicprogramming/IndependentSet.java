package com.library.dynamicprogramming;

/* Page 312: Algorithm Design
* Input: Graph with n node path with weights (Only one edge exists between consecutive nodes in a path)
* Output: Independent set of maximum total weight (No two nodes in a independent set has an edge)
 */

public class IndependentSet {
    private final int[] weights;
    private int[] optValues;

    public IndependentSet(int[] weights) {
        this.weights = weights;
        this.optValues = new int[weights.length];
    }

    public int getIntependentSetWeight() {
        int max = _opt(weights.length - 1);
        printOptimalSites(weights.length - 1);
        return max;
    }

    private void printOptimalSites(int i) {
        if (i == -1) return;

        int pIndex = p(i);
        if (weights[i] + _opt(pIndex) > _opt(i - 1)) {
            System.out.println(weights[i]);
            printOptimalSites(pIndex);
            return;
        }

        printOptimalSites(i - 1);
    }

    private int _opt(int i) {
        if (i < 0) return 0;
        if (optValues[i] != 0) return optValues[i];

        int revenueExcluded = _opt(i - 1);
        int revenueIncluded = weights[i] + _opt(p(i));
        optValues[i] = Math.max(revenueExcluded, revenueIncluded);
        return optValues[i];
    }

    private int p(int i) {
        return i - 2;
    }
}
