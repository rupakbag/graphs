package com.library.graph;

public class UndirectedGraph<N extends Node> extends AdjacencyList<N> {
    @Override
    public boolean addEdge(N u, N v) {
        return super.addEdge(u,v) & super.addEdge(v,u);
    }

    @Override
    public boolean removeEdge (N u, N v){
        return super.removeEdge(u,v) & super.removeEdge(v,u);
    }
}