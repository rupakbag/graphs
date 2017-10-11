package com.library.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph<N extends Node, E extends Edge<N>> extends AdjacencyList<N> {
    Set<N> v;
    Set<E> e;

    public Graph() {
        this.v = new HashSet<>();
        this.e = new HashSet<>();
    }

    public void addNode(N u) {
        this.v.add(u);
    }

    public boolean addEdge(N u, N v) {
        if (super.addEdge(u, v)) {
            this.v.add(u);
            this.v.add(v);
            this.e.add((E) new Edge<N>(true, u, v));
            return true;
        }
        return false;
    }

    public boolean addEdge(E edge) {
        if (addEdge(edge.start, edge.end)) {
            this.v.add(edge.start);
            this.v.add(edge.end);
            this.e.add(edge);
            return true;
        }
        return false;
    }

    public  boolean removeEdge(N u, N v) {
        if (super.removeEdge(u,v)) {
//            e.remove();
        }
        return false;
    }

    public  boolean removeEdge(E edge) {
        //TODO
        return false;
    }

    public DirectedGraph<N,E> reverse() {
        DirectedGraph<N, E> revGraph = new DirectedGraph<>();
        for (Edge<N> edge : e) {
            revGraph.addEdge(edge.end, edge.start);
        }
        return revGraph;
    }

    public Iterator<E> edgeIterator() {
        return e == null? null : e.iterator();
    }

    public Iterator<N> nodeIterator() {
        return v == null? null : v.iterator();
    }
}
