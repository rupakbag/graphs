package com.library.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class TopologicalOrder<N extends Node> {
    private DirectedGraph<N> graph;
    private ArrayList<N> topologicalOrder;
    private HashMap<Node, Integer> incomingEdgeCount;

    public TopologicalOrder(DirectedGraph<N> graph) {
        this.graph = graph;
    }

    public void generateTopologicalOrder() {
        if (graph == null) return;
        this.topologicalOrder = new ArrayList<>();
        generateIncomingEdgeCount();
    }

    private void generateIncomingEdgeCount() {
        this.incomingEdgeCount = new HashMap<>();
        //TODO 

    }

    public String getTopologicalOrder() {
        return "";
    }
}
