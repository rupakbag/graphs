package com.library.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Graph<N extends Node, E extends Edge<N>> {
    Set<N> v;
    Set<E> e;
    AdjacencyList<N> adjList;

    public abstract Graph<N,E> reverse();

    public Graph() {
        this.v = new HashSet<>();
        this.e = new HashSet<>();
        this.adjList = new AdjacencyList<>();
    }

    public void addNode(N u) {
        this.v.add(u);
    }

    public void removeNode(N u) {
        Iterator<E> iterator = e.iterator();
        while (iterator.hasNext()){
            E edge = iterator.next();
            if (edge.start.equals(u) || edge.end.equals(u)) {
                removeEdge(edge);
            }
        }
    }

    public void addEdge(E edge) {
        if (!e.contains(edge)) {
            this.adjList.addEdge(edge.start, edge.end);
            this.v.add(edge.start);
            this.v.add(edge.end);
            this.e.add(edge);
        }
    }

    public  boolean removeEdge(E edge) {
        if (edge != null && e.remove(edge)) {
            edge.end.incomingEdgeCount--;
            adjList.removeEdge(edge.start, edge.end);
            return true;
        }
        return false;
    }

    public Iterator<E> edgeIterator() {
        return e == null? null : e.iterator();
    }

    public Iterator<N> nodeIterator() {
        return v == null? null : v.iterator();
    }
    public Set<N> getAdjNodeList(N u) {
        return adjList.getAdjNodeList(u);
    }

    private class AdjacencyList<N extends Node> {
        private HashMap<N, HashSet<N>> list;
        public AdjacencyList(){
            this.list = new HashMap<>();
        }

        protected boolean addEdge(N u, N v) {
            HashSet<N> list = this.list.get(u);
            if (list == null) {
                list = new HashSet<>();
                this.list.put(u, list);
            }
            return list.add(v);
        }

        protected boolean removeEdge (N u, N v){
            if (!list.containsKey(u)) return false;
            if (v == null) {
                Set<N> s = list.remove(u);
                return s == null? false : s.size() > 0;
            }
            return list.get(u).remove(v);
        }
        public int size() {
            return list == null ? 0 : list.size();
        }
        public Set<N> getAdjNodeList(N u) {
            return list.get(u);
        }
    }
}
