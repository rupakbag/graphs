package com.library.graph;

public class Node {
    final String name;
    final int nodeId;
    int incomingEdgeCount = 0;
    boolean visited;
    private static IdGenerator g = IdGenerator.getInstance();

    public Node(String name) {
        this.nodeId = g.getNextId();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (nodeId != node.nodeId) return false;
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
}
