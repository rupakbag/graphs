package com.library.graph;

import java.util.*;

public class Bfs<N extends Node> {
    private final Graph<N> graph;
    private final Hashtable<Integer, ArrayList<N>> bfs;

    public Bfs(Graph<N> graph) {
        this.graph = graph;
        this.bfs = new Hashtable<>();
    }

    public void printBfs(N start) {
        generateBfs(start, 0);
        System.out.println(printBfs());
    }

    private String printBfs() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < bfs.size(); i++) {
            for (N n : this.bfs.get(Integer.valueOf(i))) {
                b.append(n.toString()).append(" ");
            }
            b.append("\n");
        }
        return b.toString();
    }

    public void generateBfs(N start, int level) {
        if (start.visited) return;
        start.visited = true;
        Integer levelObj = Integer.valueOf(level);
        ArrayList<N> list = bfs.get(levelObj);
        if (list == null) {
            list = new ArrayList<>();
            bfs.put(levelObj, list);
        }
        list.add(start);

        Set<N> nodeList = this.graph.getAdjNodeList(start);
        if (nodeList == null) return;
        for (N n : nodeList){
            generateBfs(n, level + 1);
        }
    }

    public String getBfsNodes(int level) {
        Integer l = Integer.valueOf(level);
        ArrayList<N> list = bfs.get(l);
        if (list == null) return null;
        StringBuilder sb = new StringBuilder();
        for (Node n : list) {
            sb.append(n.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
