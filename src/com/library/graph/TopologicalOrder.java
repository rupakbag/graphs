package com.library.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TopologicalOrder<N extends Node, E extends Edge<N>> {
    private final DirectedGraph<N, E> graph;
    private ArrayList<N> topologicalOrder;
    private HashMap<N, Integer> incomingEdgeCount;
    private DirectedGraph<N, E> revGraph;
    
    public TopologicalOrder(DirectedGraph<N, E> graph) {
        this.graph = graph;
    }

    public void generateTopologicalOrder() {
        if (graph == null) return;
        this.topologicalOrder = new ArrayList<>();
        this.revGraph = this.graph.reverse();

        Iterator<N> nodeIterator = this.revGraph.nodeIterator();
        while (nodeIterator.hasNext()) {
            N n = nodeIterator.next();
            if (revGraph.getAdjNodeList(n).size() == 0) this.topologicalOrder.add(n);

        }
        getIncomingEdgeCount();
        for(Map.Entry<N, Integer> entry : this.incomingEdgeCount.entrySet()) {
            if (entry.getValue() == Integer.valueOf(0)) {
                this.topologicalOrder.add(entry.getKey());
                this.incomingEdgeCount.remove(entry.getKey());
            }
        }
    }

    private void getIncomingEdgeCount() {
        this.incomingEdgeCount = new HashMap<>();

        //TODO

    }

    public String getTopologicalOrder() {
        generateTopologicalOrder();
        return topologicalOrder.toString();
    }
}
