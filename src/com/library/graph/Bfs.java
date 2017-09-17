package com.library.graph;

import java.util.*;

public class Bfs<N extends Node> {
    private final Graph<N> graph;
    private final Graph<N> bfsTree;
    private final ArrayList<ArrayList<N>> bfsLevel;

    public Bfs(Graph<N> graph) {
        this.graph = graph;
        this.bfsTree = new Graph<>();
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
