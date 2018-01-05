package com.library.graph;

import java.util.ArrayList;
import java.util.Set;
/*
* Running time complexity O(m + n) since it uses graph implemented as an adjacency list
* Every entry in the adjacency list is visited only once to generate DFS
* Weaker bound is O(n^2)
* DFS generates connected component of the starting node
*/

public class Dfs {
    private ArrayList<Node> nodeOrder;
    private Graph dfsTree;
    private Graph graph;

    public Dfs(Graph graph) {
        this.graph = graph;
        this.dfsTree = Graph.getDirectedGraphInstance();
        this.nodeOrder = new ArrayList<>();
    }

    public void generateDfs(Node start) {
        start.visited = true;
        this.nodeOrder.add(start);
        Set<Node> adjNodes = graph.getAdjNodeList(start);
        if (adjNodes == null) return;
        for (Node n : adjNodes) {
            if (!n.visited) {
                this.dfsTree.addEdge(start, n);
                generateDfs(n);
            }
        }
    }

    public String getDfsNodeOrder(Node start) {
        generateDfs(start);
        return this.nodeOrder.toString();
    }
}