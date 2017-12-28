package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalOrderTest {
    private Graph graph = new Graph(false);
    private Node n1,n2,n3,n4,n5,n6,n7;

    @Before
    public void setUp() throws Exception {
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");
        n7 = Node.getInstance("n7");

        graph.addEdge(n1, n4)
            .addEdge(n1, n5)
            .addEdge(n1, n7)
            .addEdge(n2, n6)
            .addEdge(n2, n5)
            .addEdge(n2, n3)
            .addEdge(n3, n4)
            .addEdge(n3, n5)
            .addEdge(n4, n5)
            .addEdge(n5, n6)
            .addEdge(n5, n7)
            .addEdge(n6, n7);
    }

    @Test
    public void printTopologicalOrder() {
        TopologicalOrder to = new TopologicalOrder(graph);
        Assert.assertEquals("[n1, n2, n3, n4, n5, n6, n7]", to.getTopologicalOrder());
    }
}