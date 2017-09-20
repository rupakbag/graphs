package com.library.graph;

import java.util.ArrayList;
import java.util.Set;
/*
* Running time complexity O(m + n) since it uses graph implemented as an adjacency list
* Every entry in the adjacency list is visited only once to generate DFS
* Weaker bound is O(n^2)
* DFS generates connected component of the starting node
*/

public class Dfs<N extends Node> {
    private ArrayList<N> nodeOrder;
    private DirectedGraph<N> dfsTree;
    private DirectedGraph<N> graph;

    public Dfs(DirectedGraph<N> graph) {
        this.graph = graph;
        this.dfsTree = new DirectedGraph<>();
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