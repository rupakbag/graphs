package com.library.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfShortestPath {
    public static int getNumberOfShortestPath(Graph ug, Node u, Node w) {
        int pathCount = 0;
        Integer shortestDistance = 0;
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(u);
        u.satDataRefHolder = new Integer(0);
        while(!bfsQueue.isEmpty()) {
            Node n = bfsQueue.remove();
            Integer distance = (Integer)n.satDataRefHolder;
            n.visited = true;
            if (n.equals(w)) {
                shortestDistance = distance;
                pathCount++;
                continue;
            }

            Set<Node> adjNodeList = ug.getAdjNodeList(n);
            if (adjNodeList == null) continue;
            Integer adjNodeDistance = distance + 1;
            for (Node adjNode : adjNodeList) {
                if (!adjNode.visited) {
                    adjNode.satDataRefHolder = adjNodeDistance;
                    bfsQueue.add(adjNode);
                }
                else if (adjNode.equals(w) && shortestDistance == adjNodeDistance) {
                    pathCount++;
                }
            }
        }

        return pathCount++;
    }
}
