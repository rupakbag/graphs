package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalOrderTest {
    private DirectedGraph graph = new DirectedGraph();
    private Node n1,n2,n3,n4,n5,n6,n7;

    @Before
    public void setUp() throws Exception {
        n1 = new Node("n1");
        n2 = new Node("n2");
        n3 = new Node("n3");
        n4 = new Node("n4");
        n5 = new Node("n5");
        n6 = new Node("n6");
        n7 = new Node("n7");

        graph.addEdge(Edge.getInstance(n1, n4));
        graph.addEdge(Edge.getInstance(n1, n5));
        graph.addEdge(Edge.getInstance(n1, n7));
        graph.addEdge(Edge.getInstance(n2, n6));
        graph.addEdge(Edge.getInstance(n2, n5));
        graph.addEdge(Edge.getInstance(n2, n3));
        graph.addEdge(Edge.getInstance(n3, n4));
        graph.addEdge(Edge.getInstance(n3, n5));
        graph.addEdge(Edge.getInstance(n4, n5));
        graph.addEdge(Edge.getInstance(n5, n6));
        graph.addEdge(Edge.getInstance(n5, n7));
        graph.addEdge(Edge.getInstance(n6, n7));
    }

    @Test
    public void printTopologicalOrder() {
        TopologicalOrder to = new TopologicalOrder(graph);
        Assert.assertEquals("[n1, n2, n3, n4, n5, n6, n7]", to.getTopologicalOrder());
    }
}