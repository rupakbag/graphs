package com.library.greedyAlgo;

import com.library.graph.Node;
import com.library.graph.WeightedGraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {
    private WeightedGraph dg = WeightedGraph.getDirectedGraphInstance();
    private Node n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;

    @Before
    public void setup(){
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");
        n7 = Node.getInstance("n7");
        n8 = Node.getInstance("n8");
        n9 = Node.getInstance("n9");
        n10 = Node.getInstance("n10");
        n11 = Node.getInstance("n11");
        n12 = Node.getInstance("n12");
        n13 = Node.getInstance("n13");
    }

    @Test
    public void shortestPath(){
        dg.addEdge(n1, n2, 1)
                .addEdge(n1, n3, 2)
                .addEdge(n1, n4, 4)
                .addEdge(n2, n5, 3)
                .addEdge(n2, n4, 1)
                .addEdge(n4, n5, 1)
                .addEdge(n3, n4, 2)
                .addEdge(n3, n6, 3)
                .addEdge(n4, n6, 2);

        Assert.assertEquals("[n1 -> n2(1), n1 -> n3(2), n2 -> n4(1), n4 -> n5(1), n4 -> n6(2)]",
                Dijkstra.shortestPath(dg, n1).toString());
    }
}