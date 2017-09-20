package com.library.graph;

import java.util.*;
/*
* Running time complexity O(m + n) since it uses graph implemented as an adjacency list
* Every entry in the adjacency list is visited only once to generate BFS
* Weaker bound is O(n^2)
* BFS generates connected component of the starting node
*/
public class Bfs<N extends Node> {
    private final DirectedGraph<N> graph;
    private final DirectedGraph<N> bfsTree;
    private final ArrayList<ArrayList<N>> bfsLevel;

    public Bfs(DirectedGraph<N> graph) {
        this.graph = graph;
        this.bfsTree = new DirectedGraph<>();
        this.bfsLevel = new ArrayList<>();
    }

    public void generateBfs(N start) {
        ArrayList<N> list = new ArrayList<>();
        list.add(start);
        this.bfsLevel.add(list);
        generateBfs(0);
    }

    private void generateBfs(int level) {
        ArrayList<N> list = new ArrayList<>();
        for (N node : this.bfsLevel.get(level)) {
            Set<N> adjNodes = this.graph.getAdjNodeList(node);
            if (adjNodes == null) continue;
            for (N adjNode : adjNodes) {
                if (adjNode.visited) continue;
                adjNode.visited = true;
                list.add(adjNode);
                this.bfsTree.addEdge(node, adjNode);
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
        for (ArrayList<N> list : this.bfsLevel) {
            for (N n : list){
                b.append(n.toString()).append(" ");
            }
            b.append("\n");
        }
        return b.toString();
    }

    public void printBfs(N start) {
        generateBfs(start);
        System.out.println(printBfs());
    }

    public String getBfsNodeListString(int level) {
        if (this.bfsLevel.size() < level) return null;
        return getNodeListString(this.bfsLevel.get(level));
    }

    private String getNodeListString(ArrayList<N> list) {
        StringBuilder b = new StringBuilder();
        for (N n : list){
            b.append(n.toString()).append(" ");
        }
        return b.toString().trim();
    }
}
