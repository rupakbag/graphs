package com.library.graph;

import java.util.HashMap;

public class Edge {
    final Node start;
    final Node end;

    private static HashMap<Integer, Edge> edgePool = new HashMap<>();
    public static Edge getInstance(Node start, Node end) {
        Integer key = Integer.valueOf(start.hashCode()*31 + end.hashCode());
        Edge e = edgePool.get(key);
        if (e == null) {
            e = new Edge(start, end);
            edgePool.put(key, e);
        }
        return e;
    }

    private Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public Edge reverse() {
        return new Edge(end, start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (!start.equals(edge.start)) return false;
        return end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(start)
                .append(" -> ")
                .append(end);
        return sb.toString();
    }
}
