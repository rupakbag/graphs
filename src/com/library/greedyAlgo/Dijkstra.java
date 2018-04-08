package com.library.greedyAlgo;

import com.library.graph.Node;
import com.library.graph.WeightedGraph;
import com.library.graph.WeightedGraph.Edge;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*O(mlogm)
* O(mlogn)
*Because of limitations of PriorityQueue implemention we cannot increase/decrease priority of any element already in the queue.
* IncreaseKey method is missing. So size of the priority queue is O(m) instead of O(n)
*/
public class Dijkstra {
    public static WeightedGraph shortestPath(WeightedGraph dg, Node s) {
        Queue<Edge> pq = new PriorityQueue<Edge>((o1, o2) -> (o1.weight < o2.weight)? -1 :
                                                                (o1.weight > o2.weight)? 1 : 0);

        WeightedGraph retGraph = WeightedGraph.getDirectedGraphInstance();
        s.satDataRefHolder = Integer.valueOf(0);
        s.visited = true;

        while (retGraph.nodeSize() < dg.nodeSize()) {
            Set<Edge> adjEdges = dg.getAdjEdgeList(s);
            if (adjEdges != null) {
                for (Edge e : dg.getAdjEdgeList(s)) {
                    if (e.end.visited) continue;
                    pq.add(new Edge(s, e.end, e.weight + ((Integer) s.satDataRefHolder).intValue()));
                }
            }
            Edge bestEdge = pq.remove(); //O(nlogn)
            retGraph.addEdge(bestEdge.start, bestEdge.end, bestEdge.weight - ((Integer) bestEdge.start.satDataRefHolder).intValue()); //O(m)
            s = bestEdge.end;
            s.satDataRefHolder = Integer.valueOf(bestEdge.weight);
            s.visited = true;
        }
        return retGraph;
    }
}
