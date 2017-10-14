package com.library.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph{
    Set<Node> v;
    Set<Edge> e;
    AdjacencyList adjList;

    public Graph() {
        this.v = new HashSet<>();
        this.e = new HashSet<>();
        this.adjList = new AdjacencyList<>();
    }

    public Graph addNode(Node u) {
        this.v.add(u);
        return this;
    }

    public void addEdge(Edge edge) {
        if (!e.contains(edge)) {
            this.adjList.addEdge(edge.start, edge.end);
            this.v.add(edge.start);
            this.v.add(edge.end);
            this.e.add(edge);
            edge.end.incomingEdgeCount++;
        }
    }

    public void removeNode(Node u) {
        if (!v.contains(u)) return;

        Iterator<Edge> iterator = e.iterator();
        while (iterator.hasNext()){
            Edge edge = iterator.next();
            if (edge.start.equals(u) || edge.end.equals(u)) {
                iterator.remove();
                edge.end.incomingEdgeCount--;
                adjList.removeEdge(edge.start, edge.end);
            }
        }
        if (u.incomingEdgeCount == 0 && adjList.getAdjNodeList(u) == null) {
            v.remove(u);
        }
    }

    public  boolean removeEdge(Edge edge) {
        if (edge != null && e.remove(edge)) {
            edge.end.incomingEdgeCount--;
            adjList.removeEdge(edge.start, edge.end);
            return true;
        }
        return false;
    }

    public Iterator<Edge> edgeIterator() {
        return e == null? null : e.iterator();
    }

    public Iterator<Node> nodeIterator() {
        return v == null? null : v.iterator();
    }
    public Set<Node> getAdjNodeList(Node u) {
        return adjList.getAdjNodeList(u);
    }

    public class AdjacencyList<N extends Node> {
        private HashMap<N, HashSet<N>> list;

        public AdjacencyList(){
            this.list = new HashMap<>();
        }

        boolean addEdge(N u, N v) {
            HashSet<N> list = this.list.get(u);
            if (list == null) {
                list = new HashSet<>();
                this.list.put(u, list);
            }
            return list.add(v);
        }

        void removeNode(N n) {
            list.remove(n);
        }

        boolean removeEdge (N u, N v){
            if (u == null || v == null || !list.containsKey(u)) return false;
            boolean success = list.get(u).remove(v);
            if (success && list.get(u).size() == 0) {
                list.remove(u);
            }
            return success;
        }

        public Set<N> getAdjNodeList(N u) {
            return list.get(u);
        }
    }
}
