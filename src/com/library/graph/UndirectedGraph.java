package com.library.graph;

public class UndirectedGraph extends Graph<Node, Edge<Node>> {

    //TODO Implement Add/remove edge

    @Override
    public UndirectedGraph reverse() {
        return this;
    }
}