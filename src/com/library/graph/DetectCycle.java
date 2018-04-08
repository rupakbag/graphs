package com.library.graph;

import java.util.Set;

public class DetectCycle {
    Graph g;
    int cycleCount = 0;
    /*
    * This method returns the number of cycles found in the graph. Also prints the list of nodes that form each cycle
    * Returns 0 if no cycle exists
    * Bug: If start node doesn't lead to cycle, no cycle is detected. Remove dependency on start node
     */
    public int printCycle(Graph g, Node start) {
        this.g = g;
        getCycle(start, null, "");
        return cycleCount;
    }

    private void getCycle(Node n, Node prevNode, String path) {
        if (n.visited) {
            if (path.contains(n.getName())) {
                System.out.println("Cycle Found: " + filterPath(path, n) + " " + n.getName());
                cycleCount++;
            }
            return;
        }

        n.visited= true;
        path += " " + n.getName();
        Set<Node> nAdjSet = g.getAdjNodeList(n);
        if (nAdjSet == null) return;
        for (Node nAdj : nAdjSet) {
            if (nAdj != prevNode) {
                getCycle(nAdj, n, path);
            }
        }
    }

    private String filterPath(String path, Node n) {
        return path.substring(path.indexOf(n.toString()));
    }
}
