package com.library.graph;

/*
* Butterflies are classified in two groups. Given n butterfly samples and m pairs of specimens marked either "same"
* or "different", find if the sameSpecimen is consistent in placing every specimen in two groups.
 */

import java.util.LinkedList;
import java.util.Set;

public class SpecimenClassification {

    public SpecimenClassification() {
    }

    public static boolean isConsistent(Set<Pair> judgements) {
        WeightedGraph wg = new WeightedGraph(true);
        for (Pair p : judgements) {
            wg.addEdge(Node.getInstance(p.a), Node.getInstance(p.b), (p.sameSpecimen? 1 : -1));
        }

        Node n = wg.adjList.keySet().iterator().next();
        return _color(wg, n);
    }

    private static boolean _color(WeightedGraph wg, Node node) {
        LinkedList<Node> list = new LinkedList<>();
        list.add(node);
        node.satDataRefHolder = "red";
        node.visited = true;

        while (list.size() > 0) {
            Node n = list.remove();
            Set<WeightedGraph.Edge> adjEdges = wg.getAdjNodeList(n);
            if (adjEdges == null) {
                continue;
            }
            for (WeightedGraph.Edge e : adjEdges) {
                if (e.end.visited) {
                    if ((e.weight == 1 && e.end.satDataRefHolder == n.satDataRefHolder) ||
                            (e.weight == -1 && e.end.satDataRefHolder != n.satDataRefHolder)) continue;
                    return false;
                }
                e.end.visited = true;
                list.add(e.end);
                e.end.satDataRefHolder = (e.weight == 1) ? n.satDataRefHolder :
                                                    ((n.satDataRefHolder == "red")? "black" : "red");
            }
        }
        return true;
    }

    static class Pair {
        final String a;
        final String b;
        final boolean sameSpecimen;

        Pair(String a, String b, boolean sameSpecimen) {
            this.a = a;
            this.b = b;
            this.sameSpecimen = sameSpecimen;
        }
    }
}
