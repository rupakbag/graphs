package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BfsTest {
    private Graph<Node> graph = new Graph<>();
    private Node n1 = Node.getInstance("n1");
    private Node n2 = Node.getInstance("n2");
    private Node n3 = Node.getInstance("n3");
    private Node n4 = Node.getInstance("n4");
    private Node n5 = Node.getInstance("n5");
    private Node n6 = Node.getInstance("n6");
    private Node n7 = Node.getInstance("n7");
    private Node n8 = Node.getInstance("n8");
    private Node n9 = Node.getInstance("n9");

    @Before
    public void setup() {
        graph.addEdge(n1, n2);
        graph.addEdge(n1, n3);
        graph.addEdge(n2, n4);
        graph.addEdge(n2, n5);
        graph.addEdge(n3, n7);
        graph.addEdge(n3, n8);
        graph.addEdge(n5, n6);
    }

    @Test
    public void printBfs() throws Exception {
        Bfs<Node> bfs = new Bfs<>(graph);
        bfs.generateBfs(n1, 0);
        Assert.assertEquals("n2 n3", bfs.getBfsNodes(1));
    }

}