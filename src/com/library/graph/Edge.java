package com.library.graph;

public class Edge<N extends Node> {
    N start;
    N end;

    public Edge(N start, N end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (!start.equals(edge.start)) return false;
        return end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    public Edge<N> reverse() {
        return new Edge<N>(end, start);
    }
}
