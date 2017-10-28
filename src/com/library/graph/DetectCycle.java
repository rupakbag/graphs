package com.library.graph;

import java.util.HashMap;
import java.util.HashSet;

public class DetectCycle {

    HashMap<Node, String> pathMap = new HashMap<>();
    Graph g;
    int cycleCount = 0;
    /*
    * This method returns the number of cycles found in the graph. Also prints the list of nodes that form each cycle
    * Returns 0 if no cycle exists
     */
    public int printCycle(Graph g, Node start) {
        this.g = g;
        getCycle(start, start.name);
        return cycleCount;
    }

    private String getCycle(Node n, String path) {
        if (n.visited) {
            System.out.println("Cycle Found: " + filterPath(path));
            cycleCount++;
            return path;
        }
        n.visited= true;
        HashSet<Node> nAdjSet = g.adjList.getAdjNodeList(n);
        if (nAdjSet == null) return path;
        for (Node nAdj : nAdjSet) {
            getCycle(nAdj, path + " " + nAdj.name);
        }
        return path;
    }

    private String filterPath(String path) {
        String lastNode = path.substring(path.lastIndexOf(" ") + 1);
        return path.substring(path.indexOf(lastNode));
    }
}
