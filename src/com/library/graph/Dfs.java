package com.library.graph;

import java.util.ArrayList;
import java.util.Set;
/*
* Running time complexity O(m + n) since it uses graph implemented as an adjacency list
* Every entry in the adjacency list is visited only once to generate DFS
* Weaker bound is O(n^2)
* DFS generates connected component of the starting node
*/

public class Dfs<N extends Node, E extends Edge<N>> {
    private ArrayList<N> nodeOrder;
    private DirectedGraph<N, E> dfsTree;
    private DirectedGraph<N, E> graph;

    public Dfs(DirectedGraph<N, E> graph) {
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
        return this.nodeOrder.toString();
    }
}