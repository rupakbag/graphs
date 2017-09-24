package com.library.graph;

import org.junit.Assert;
import org.junit.Before;

public class TopologicalOrderTest {
    private DirectedGraph<Node, Edge<Node>> graph = new DirectedGraph<>();
    private Node n1 = Node.getInstance("n1");
    private Node n2 = Node.getInstance("n2");
    private Node n3 = Node.getInstance("n3");
    private Node n4 = Node.getInstance("n4");
    private Node n5 = Node.getInstance("n5");
    private Node n6 = Node.getInstance("n6");
    private Node n7 = Node.getInstance("n7");

    @Before
    public void setUp() throws Exception {
        graph.addEdge(n1, n4);
        graph.addEdge(n1, n5);
        graph.addEdge(n1, n7);
        graph.addEdge(n2, n6);
        graph.addEdge(n2, n5);
        graph.addEdge(n2, n3);
        graph.addEdge(n3, n4);
        graph.addEdge(n3, n5);
        graph.addEdge(n4, n5);
        graph.addEdge(n5, n6);
        graph.addEdge(n5, n7);
        graph.addEdge(n6, n7);
    }
    public void printTopologicalOrder() {
        TopologicalOrder<Node> to = new TopologicalOrder(graph);
        Assert.assertEquals("n1 n2 n3 n4 n5 n6 n7", to.getTopologicalOrder());
    }
}