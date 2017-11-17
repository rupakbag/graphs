package com.library.dynamicprogramming;

import com.library.graph.Graph;
import com.library.graph.Node;

/*
*   Page 314: Problem 3: Algorithm Design
 */
public class OrderedGraph {
    private final Graph g;
    private int[] optValues;

    public OrderedGraph(Graph g) {
        this.g = g;
    }

    public int getLongestPath(Node start, Node end) {
        this.optValues = new int[g.nodeSize()];
        int max = _opt(start, end);

        // Print Start node since optimal path finder doesn't print start
        System.out.println(start);
        printOptimalPath(start, end);
        return max;
    }

    private void printOptimalPath(Node start, Node end) {
        if (start.equals(end)) return;
        int max = -1;
        Node maxNode = null;
        for (Node n : g.getAdjNodeList(start)) {
            int index = getIndex(n);
            if (max < 1 + optValues[index]) {
                max = 1 + optValues[index];
                maxNode = n;
            }
        }
        System.out.println(maxNode.toString());
        printOptimalPath(maxNode, end);
    }

    private int _opt(Node start, Node end) {
        if (start.equals(end)) return 0;
        if (optValues[getIndex(start)] != 0) return optValues[getIndex(start)];

        int max = -1;
        for (Node n : g.getAdjNodeList(start)) {
            int nMaxLength = 1 + _opt(n, end);
            if (max < nMaxLength) {
                max = nMaxLength;
            }
        }
        int index = getIndex(start);
        optValues[index] = max;
        return max;
    }

    private int getIndex(Node start) {
        return start.hashCode()%optValues.length;
    }
}
