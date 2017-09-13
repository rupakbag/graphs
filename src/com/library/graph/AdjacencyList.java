package com.library.graph;

import java.util.*;

public class AdjacencyList<N extends Node> {
    private HashMap<N, HashSet<N>> list;

    public AdjacencyList(){
        this.list = new HashMap<>();
    }

    public boolean addEdge(N u, N v) {
        HashSet<N> list = this.list.get(u);
        if (list == null) {
            list = new HashSet<>();
            this.list.put(u, list);
        }
        return list.add(v);
    }

    public boolean removeEdge (N u, N v){
        if (!list.containsKey(u)) return false;
        if (v == null) {
            Set<N> s = list.remove(u);
            return s == null? false : s.size() > 0;
        }
        return list.get(u).remove(v);
    }

    public Set<N> getAdjNodeList(N u) {
        return list.get(u);
    }
}
