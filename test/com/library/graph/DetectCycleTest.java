package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetectCycleTest {
    DetectCycle dc = new DetectCycle();
    private Graph graph = new Graph(false);
    private Node n1,n2,n3,n4,n5,n6;

    @Before
    public void setup() {
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");

        graph.addEdge(n1, n2)
        .addEdge(n2, n3)
        .addEdge(n3, n1)
        .addEdge(n2, n4)
        .addEdge(n4, n5)
        .addEdge(n5, n6)
        .addEdge(n6, n4);
    }

    @Test
    public void printCycle() {
        Assert.assertEquals(2, dc.printCycle(graph, n1));
    }
}