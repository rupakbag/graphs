package com.library.graph;

public class UndirectedGraph<N extends Node, E extends Edge<N>> extends Graph<N, E> {
    @Override
    public boolean addEdge(E edge) { return super.addEdge(edge) & super.addEdge((E)edge.reverse());
    }

    @Override
    public boolean removeEdge (E edge){
        return super.removeEdge(edge) & super.removeEdge((E)edge.reverse());
    }
}