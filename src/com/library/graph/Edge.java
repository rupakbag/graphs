package com.library.graph;

public class Edge<N extends Node> {
    boolean directedEdge;
    N start;
    N end;

    public Edge(boolean directedEdge, N start, N end) {
        this.directedEdge = directedEdge;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (directedEdge != edge.directedEdge) return false;
        if (!start.equals(edge.start)) return false;
        return end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        int result = (directedEdge ? 1 : 0);
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    public Edge<N> reverse() {
        return new Edge<>(true, end, start);
    }
}
