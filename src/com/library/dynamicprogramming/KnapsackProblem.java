package com.library.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

public class KnapsackProblem {
    private final int W;
    private final List<REQ> requestList;
    private int[][] optValues;
    public KnapsackProblem(int W) {
        this.W = W;
        this.requestList = new LinkedList<>();
    }

    public int getOpt() {
        this.optValues = new int[requestList.size() + 1][W + 1];
        for(int i = 1; i <= requestList.size(); i++){
            for (int w = 0; w <= W; w++) {
                optValues[i][w] = _opt(i,w);
            }
        }
        return this.optValues[this.requestList.size()][W];
    }

    private int _opt(int i, int w) {
        if (i == 0) return 0;
        if (optValues[i][w] != 0) return optValues[i][w];

        int currentIndexWeight = requestList.get(i - 1).weight;
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
