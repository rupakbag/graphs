package com.library.graph;

import java.util.*;

public class WeightedGraph {
    final Set<Node> v;
    final Map<Node, Set<Edge>> adjList;
    final boolean undirectedGraph;

    public static WeightedGraph getUndirectedGraphInstance() {
        return new WeightedGraph(true);
    }

    public static WeightedGraph getDirectedGraphInstance() {
        return new WeightedGraph(false);
    }

    private WeightedGraph(boolean undirectedGraph) {
        this.undirectedGraph = undirectedGraph;
        this.v = new HashSet<>();
        this.adjList = new HashMap<>();
    }

    public WeightedGraph addNode(Node u) {
        this.v.add(u);
        return this;
    }

    public WeightedGraph addEdge(Node s, Node e, int weight) {
        addNode(s).addNode(e);
        _addEdge(s, e, weight);
        if (undirectedGraph) {
            _addEdge(e, s, weight);
        }
        return this;
    }

    private void _addEdge(Node s, Node e, int w) {
        adjList.computeIfAbsent(s, k -> new HashSet<>()).add(new Edge(s, e, w));
        e.incomingEdgeCount++;
    }

    public  void removeEdge(Node s, Node e) {
        _removeEdge(s, e);
        if (undirectedGraph) removeEdge(e, s);
    }

    private void _removeEdge(Node s, Node e) {
        Set<Edge> adjSet = adjList.get(s);
        if (adjSet!= null) {
            adjSet.remove(new Edge(s, e));
            e.incomingEdgeCount--;
        }
        if (adjSet.size() == 0) adjList.remove(s); // Remove entry from Adjcency List if this is the only edge
    }

    // O(n) operation Avoid!!!
    public void removeNode(Node s) {
        if (!this.v.remove(s)) return;

        //Remove outgoing edges
        Set<Edge> adjSet = adjList.remove(s);
        if (adjSet != null) {
            for (Edge e : adjSet) {
                e.end.incomingEdgeCount--;
            }
        }

        //Remove incoming edges
        if (s.incomingEdgeCount > 0) {
            Iterator<Map.Entry<Node, Set<Edge>>> i = adjList.entrySet().iterator();
            while (i.hasNext()){
                Map.Entry<Node, Set<Edge>> entry = i.next();
                entry.getValue().remove(new Edge(entry.getKey(), s));
                if (entry.getValue().size() == 0) {
                    i.remove();
                }
            }
        }
        s.clear();
    }

    public Iterator<Node> nodeIterator() {
        return v.iterator();
    }

    public int nodeSize() {
        return v.size();
    }

    public Set<Edge> getAdjEdgeList(Node u) {
        return adjList.get(u);
    }

    public void clear() {
        this.v.clear();
        this.adjList.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        for (Map.Entry<Node, Set<Edge>> entry : adjList.entrySet()) {
            for (Edge n : entry.getValue()) {
                sb.append(entry.getKey()).append(" -> ").append(n).append(", ");
            }
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 2) + "]";
    }

    static public class Edge {
        public final Node start;
        public final Node end;
        public final int weight;

        public Edge(Node start, Node end) {
            this.start = start;
            this.end = end;
            this.weight = 0;
        }

        public Edge(Node start, Node end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
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
            sb.append(end)
                    .append("(")
                    .append(weight)
                    .append(")");
            return sb.toString();
        }
    }
}
