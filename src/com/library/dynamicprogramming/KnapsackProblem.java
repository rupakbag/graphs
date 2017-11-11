package com.library.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

public class KnapsackProblem {
    private final int W;
    private int opt;
    private final List<REQ> requestList;

    public KnapsackProblem(int W) {
        this.W = W;
        this.requestList = new LinkedList<>();
    }

    public int getOpt() {
        return _opt(requestList.size() - 1, W);
    }

    private int _opt(int i, int w) {
        return 0;
    }

    public void addRequest(REQ request) {
        this.requestList.add(request);
    }

    public static class REQ {
        private final int w;
        public REQ(int w) {
            this.w = w;
        }
    }
}
