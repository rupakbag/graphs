package com.library.graph;

public class DirectedGraph extends Graph<Node, Edge<Node>> {
    @Override
    public DirectedGraph reverse() {
        DirectedGraph revGraph = new DirectedGraph();
        for (Edge edge : e) {
            revGraph.addEdge(edge.reverse());
        }
        return revGraph;
    }
}
