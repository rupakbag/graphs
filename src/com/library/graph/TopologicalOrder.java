package com.library.graph;

import java.util.*;

public class TopologicalOrder {
    private final DirectedGraph graph;
    private ArrayList<Node> topologicalOrder;
    private HashMap<Node, Integer> incomingEdgeCount;
    private Queue<Node> active;

    public TopologicalOrder(DirectedGraph graph) {
        this.graph = graph;
        active = new LinkedList<Node>();
    }

    public void generateTopologicalOrder() {
        if (graph == null) return;
        this.topologicalOrder = new ArrayList<>();

        getActiveNodes();
        processActiveNodes();
        System.out.println(topologicalOrder.toString());
    }

    private void processActiveNodes() {
        if (active.isEmpty()) return;
        Node n = active.remove();
        topologicalOrder.add(n);
        graph.removeNode(n);
        getActiveNodes();
        processActiveNodes();
    }

    private void getActiveNodes() {
        for (Node n : graph.v) {
            if (n.incomingEdgeCount == 0 && !n.visited) {
                active.add(n);
                n.visited = true;
            }
        }
    }

    public String getTopologicalOrder() {
        generateTopologicalOrder();
        return topologicalOrder.toString();
    }
}
