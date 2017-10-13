package com.library.graph;

import java.util.*;
/*
* Running time complexity O(m + n) since it uses graph implemented as an adjacency list
* Every entry in the adjacency list is visited only once to generate BFS
* Weaker bound is O(n^2)
* BFS generates connected component of the starting node
*/
public class Bfs<N extends Node, E extends Edge<N>> {
    private final DirectedGraph graph;
    private final DirectedGraph bfsTree;
    private final ArrayList<ArrayList<Node>> bfsLevel;

    public Bfs(DirectedGraph graph) {
        this.graph = graph;
        this.bfsTree = new DirectedGraph();
        this.bfsLevel = new ArrayList<>();
    }

    public void generateBfs(N start) {
        ArrayList<Node> list = new ArrayList<>();
        list.add(start);
        this.bfsLevel.add(list);
        generateBfs(0);
    }

    private void generateBfs(int level) {
        ArrayList<Node> list = new ArrayList<>();
        for (Node node : this.bfsLevel.get(level)) {
            Set<Node> adjNodes = this.graph.getAdjNodeList(node);
            if (adjNodes == null) continue;
            for (Node adjNode : adjNodes) {
                if (adjNode.visited) continue;
                adjNode.visited = true;
                list.add(adjNode);
                this.bfsTree.addEdge(new Edge(node, adjNode));
            }
        }
        if (list.size() > 0) {
            this.bfsLevel.add(list);
            generateBfs(level + 1);
        }
        return;
    }

    public String printBfs() {
        StringBuilder b = new StringBuilder();
        if (this.bfsLevel.isEmpty()) return "Empty Tree";
        for (ArrayList<Node> list : this.bfsLevel) {
            b.append(list.toString()).append("\n");
        }
        return b.toString();
    }

    public void printBfs(N start) {
        generateBfs(start);
        System.out.println(printBfs());
    }

    public String getBfsNodeListString(int level) {
        if (this.bfsLevel.size() < level) return null;
        return this.bfsLevel.get(level).toString();
    }
}
