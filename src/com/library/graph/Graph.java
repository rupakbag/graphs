package com.library.graph;

import java.util.*;

public class Graph{
    final Set<Node> v;
    final Map<Node, Set<Node>> adjList;
    final boolean undirectedGraph;

    public static Graph getUndirectedGraphInstance() {
        return new Graph(true);
    }

    public static Graph getDirectedGraphInstance() {
        return new Graph(false);
    }

    private Graph(boolean undirectedGraph) {
        this.undirectedGraph = undirectedGraph;
        this.v = new HashSet<>();
        this.adjList = new HashMap<>();
    }

    public Graph addNode(Node u) {
        this.v.add(u);
        return this;
    }

    public Graph addEdge(Node s, Node e) {
        addNode(s).addNode(e);
        _addEdge(s, e);
        if (undirectedGraph) {
            _addEdge(e, s);
        }
        return this;
    }

    private void _addEdge(Node s, Node e) {
        adjList.computeIfAbsent(s, k -> new HashSet<>()).add(e);
        e.incomingEdgeCount++;
    }

    public  void removeEdge(Node s, Node e) {
        _removeEdge(s, e);
        if (undirectedGraph) removeEdge(e, s);
    }

    private void _removeEdge(Node s, Node e) {
        Set<Node> adjSet = adjList.get(s);
        if (adjSet!= null) {
            adjSet.remove(e);
            e.incomingEdgeCount--;
        }
        if (adjSet.size() == 0) adjList.remove(s); // Remove entry from Adjcency List if this is the only edge
    }

    // O(n) operation Avoid!!!
    public void removeNode(Node s) {
        if (!this.v.remove(s)) return;

        //Remove outgoing edges
        Set<Node> adjSet = adjList.remove(s);
        if (adjSet != null) {
            for (Node n : adjSet) {
                n.incomingEdgeCount--;
            }
        }

        //Remove incoming edges
        if (s.incomingEdgeCount != 0) {
            Iterator<Set<Node>> i = adjList.values().iterator();
            while (i.hasNext()) {
                Set<Node> set = i.next();
                set.remove(s);
                if (set.isEmpty()) i.remove();
            }
        }
        s.clear();
    }

    public Iterator<Node> nodeIterator() {
        return v.iterator();
    }

    public Set<Node> getAdjNodeList(Node u) {
        return adjList.get(u);
    }

    public int nodeSize() {
        return v.size();
    }

    public void clear() {
        this.v.clear();
        this.adjList.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        for (Map.Entry<Node, Set<Node>> entry : adjList.entrySet()) {
            for (Node n : entry.getValue()) {
                sb.append(entry.getKey()).append(" -> ").append(n).append(", ");
            }
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 2) + "]";
    }
}