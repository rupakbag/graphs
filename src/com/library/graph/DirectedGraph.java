package com.library.graph;

public class DirectedGraph<N extends Node> extends AdjacencyList<N> {
//    private int nodeCount = 0;
    private int edgeCount = 0;
//    private Set<N> nodeSet;

    public DirectedGraph() {
//        this.nodeSet = new HashSet<>();
    }

    public boolean addEdge(N u, N v) {
        if (super.addEdge(u,v)) {
            edgeCount++;
            return true;
        }
        return false;
    }

    public boolean removeEdge (N u, N v){
        if (super.removeEdge(u, v)) {
            edgeCount--;
            return true;
        }
        return false;
    }
}
