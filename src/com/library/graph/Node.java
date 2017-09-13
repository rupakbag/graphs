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
    public String toString() {
//        final StringBuilder sb = new StringBuilder("Node{");
//        sb.append("name='").append(name).append('\'');
//        sb.append('}');
//        return sb.toString();
        return name;
    }
}
