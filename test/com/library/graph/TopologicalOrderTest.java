package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TopologicalOrderTest {
    private DirectedGraph graph = new DirectedGraph();
    private Node n1 = new Node("n1");
    private Node n2 = new Node("n2");
    private Node n3 = new Node("n3");
    private Node n4 = new Node("n4");
    private Node n5 = new Node("n5");
    private Node n6 = new Node("n6");
    private Node n7 = new Node("n7");

    @Before
    public void setUp() throws Exception {
        graph.addEdge(new Edge<>(n1, n4));
        graph.addEdge(new Edge<>(n1, n5));
        graph.addEdge(new Edge<>(n1, n7));
        graph.addEdge(new Edge<>(n2, n6));
        graph.addEdge(new Edge<>(n2, n5));
        graph.addEdge(new Edge<>(n2, n3));
        graph.addEdge(new Edge<>(n3, n4));
        graph.addEdge(new Edge<>(n3, n5));
        graph.addEdge(new Edge<>(n4, n5));
        graph.addEdge(new Edge<>(n5, n6));
        graph.addEdge(new Edge<>(n5, n7));
        graph.addEdge(new Edge<>(n6, n7));
    }

    @Test
    public void printTopologicalOrder() {
        TopologicalOrder to = new TopologicalOrder(graph);
        Assert.assertEquals("n1 n2 n3 n4 n5 n6 n7", to.getTopologicalOrder());
    }
}