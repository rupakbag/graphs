package com.library.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

/*
* Page 271: Algorithm Design
*/

public class KnapsackProblem {
    private final int W;
    private final List<REQ> requestList;
    private int[][] optValues;
    public KnapsackProblem(int W) {
        this.W = W;
        this.requestList = new LinkedList<>();
    }

    // O(nW) :  Order of RequestList Size x Knapsack weight
    public int getOpt() {
        this.optValues = new int[requestList.size()][W + 1];
        for(int i = 0; i < requestList.size(); i++){
            for (int w = 0; w <= W; w++) {
                optValues[i][w] = _opt(i,w);
            }
        }
        printOptimalSet(requestList.size() - 1, W);
        return this.optValues[this.requestList.size() - 1][W];
    }

    // O(n) : Order of RequestList Size
    private void printOptimalSet(int i, int w) {
        if (i == -1) return;
        int weight = requestList.get(i).weight;
        if (weight <= w && (weight + _opt(i - 1, w - weight)) > _opt(i - 1, w)) {
            System.out.println(weight + " ");
            printOptimalSet(i - 1, w - weight);
        }
        else {
            printOptimalSet(i - 1, w);
        }
    }

    private int _opt(int i, int w) {
        if (i == -1 || w == 0) return 0;
        if (optValues[i][w] != 0) return optValues[i][w];

        int currentIndexWeight = requestList.get(i).weight;
        int weightExcluded = _opt(i - 1, w);
        if (currentIndexWeight > w) return weightExcluded;
        int weightIncluded =  currentIndexWeight + _opt(i - 1, w - currentIndexWeight);
        return Math.max(weightIncluded, weightExcluded);
    }

    public void addRequest(REQ request) {
        this.requestList.add(request);
    }

    public static class REQ {
        private final int weight;
        public REQ(int weight) {
            this.weight = weight;
        }
    }
}
