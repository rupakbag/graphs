package com.library.graph;

import java.util.HashMap;
import java.util.Map;

public class Node {
    final String name;

    final int nodeId;
    int incomingEdgeCount = 0;
    boolean visited;
    private static Map<String, Node> nodeCache = new HashMap<>();

    private static IdGenerator g = IdGenerator.getInstance();

    private Node(String name) {
        this.nodeId = g.getNextId();
        this.name = name;
    }
    public static Node getInstance(String nodeName) {
        Node n = nodeCache.computeIfAbsent(nodeName, k -> new Node(k));
        return n.clear();
    }

    public Node clear() {
        this.incomingEdgeCount =0;
        this.visited = false;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + nodeId;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() { return name; }
    public int getNodeId() { return nodeId; }
}
