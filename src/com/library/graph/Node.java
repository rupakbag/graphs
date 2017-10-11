package com.library.graph;

public class Node {
    final String name;
    final int nodeId;
    boolean visited;
    private static IdGenerator g = IdGenerator.getInstance();

    public static Node getInstance(String nodeName) {
        return new Node(g.getNextId(), nodeName);
    }

    private Node(int nodeId, String name) {
        this.nodeId = nodeId;
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
