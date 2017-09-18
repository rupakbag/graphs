package com.library.graph;

import java.util.ArrayList;
import java.util.Set;

public class Dfs<N extends Node> {
    private ArrayList<N> nodeOrder;
    private Graph<N> dfsTree;
    private Graph<N> graph;

    public Dfs(Graph<N> graph) {
        this.graph = graph;
        this.dfsTree = new Graph<>();
        this.nodeOrder = new ArrayList<>();
    }

    public void generateDfs(N start) {
        start.visited = true;
        this.nodeOrder.add(start);
        Set<N> adjNodes = graph.getAdjNodeList(start);
        if (adjNodes == null) return;
        for (N n : adjNodes) {
            if (!n.visited) {
                this.dfsTree.addEdge(start, n);
                generateDfs(n);
            }
        }
    }

    public String getDfsNodeOrder(N start) {
        generateDfs(start);
        return generateNodeOrderString();
    }

    private String generateNodeOrderString() {
        if (this.nodeOrder.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (N n : this.nodeOrder) {
            sb.append(n).append(" ");
        }
        return sb.toString().trim();
    }
}