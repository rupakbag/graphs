package com.library.graph;

import java.util.*;

public class TopologicalOrder {
    private final Graph graph;
    private ArrayList<Node> topologicalOrder;
    private HashMap<Node, Integer> incomingEdgeCount;
    private Queue<Node> active;

    public TopologicalOrder(Graph graph) {
        this.graph = graph;
        active = new LinkedList<Node>();
    }

    //O(m+n)
    public static String getTopologicalOrder(Graph g) {
        List<Node> order = new LinkedList<>();
        //Find Set of non incoming edge nodes
        Queue<Node> noIncoming = new LinkedList<>();
        for (Node n : g.v) {
            if (n.incomingEdgeCount == 0) noIncoming.add(n);
        }
        int nodeCount = 0;
        while(!noIncoming.isEmpty()) {
            Node n = noIncoming.remove();
            order.add(n);
            nodeCount++;
            Set<Node> adjNodeList = g.getAdjNodeList(n);
            if (adjNodeList == null) continue;
            for (Node adjNode : adjNodeList) {
                if (--adjNode.incomingEdgeCount == 0) {
                    noIncoming.add(adjNode);
                }
            }
        }

        if (order.size() < g.nodeSize()) { //No DAG, find Cycle
//            DetectCycle
        }
        String s = ""; //sb.toString();
        return (nodeCount == g.nodeSize()) ? s.substring(0, s.length() - 2) + "]" : "[]";
    }
}
