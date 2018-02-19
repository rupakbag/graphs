package com.leetcode;

import com.library.graph.Graph;
import com.library.graph.Node;

import java.util.Set;

public class MaxPathBinaryTree {
    public static int getMaxPath(Graph g) {
        Node n = g.nodeIterator().next();
        return _max(g, n);
    }

    private static int _max(Graph g, Node n) {
        if (n.visited) return 0;
        n.visited = true;
        //Node not included
        int maxNotIncluded = 0;
        Set<Node> adjSet = g.getAdjNodeList(n);
        if (adjSet == null) return ((Integer)n.satDataRefHolder).intValue();
        for(Node adjNode : adjSet){
            if (adjNode.visited) continue;
            int cost = _max(g, adjNode);
            maxNotIncluded = (maxNotIncluded < cost)? cost : maxNotIncluded;
        }

        //Node Included
        int maxIncluded = 0;
        for(Node adjNode : adjSet){
            if (adjNode.visited) continue;
            maxIncluded += _max(g, adjNode);
        }
        maxIncluded = maxIncluded + ((Integer)n.satDataRefHolder).intValue();

        int max = Math.max(maxIncluded, maxNotIncluded);
        return max;
    }
}
