package com.library.graph;

public class Edge<N extends Node> {
    boolean directedEdge;
    N start;
    N end;

    public Edge(boolean directedEdge, N start, N end) {
        this.directedEdge = directedEdge;
        this.start = start;
        this.end = end;
    }
}
