package com.library.graph;

import java.util.*;
/*
*   Adjacency List requires space of O(m+n)
 */
public class AdjacencyList<N extends Node> {
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
