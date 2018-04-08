package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DetectCycleTest {
    DetectCycle dc = new DetectCycle();
    private Graph graph = Graph.getDirectedGraphInstance();
    private Node n1,n2,n3,n4,n5,n6;

    @Before
    public void setup() {
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");

    }

    @Test
    public void test_simple_cycle() {
        graph.addEdge(n1, n2)
                .addEdge(n2, n3)
                .addEdge(n3, n1);
        Assert.assertEquals(1, dc.printCycle(graph, n1));
    }

    @Test
    public void test_multiple_cycle() {
        graph.addEdge(n1, n2)
                .addEdge(n2, n3)
                .addEdge(n3, n1)
                .addEdge(n2, n4)
                .addEdge(n4, n5)
                .addEdge(n5, n6)
                .addEdge(n6, n4);
        Assert.assertEquals(2, dc.printCycle(graph, n1));
    }

    @Test
    public void test_no_cycle() {
        graph.addEdge(n1, n2)
                .addEdge(n2, n3)
                .addEdge(n1, n3);
        Assert.assertEquals(0, dc.printCycle(graph, n1));
    }

    @Test
    public void test_no_cycle1() {
        graph.addEdge(n1, n2)
                .addEdge(n1, n4)
                .addEdge(n2, n3)
                .addEdge(n2, n5)
                .addEdge(n4, n5);
        Assert.assertEquals(0, dc.printCycle(graph, n1));
    }

    @Test
    public void test_undirected_graph_cycle() {
        Graph g = Graph.getUndirectedGraphInstance();
        g.addEdge(n1, n2)
                .addEdge(n1, n5)
                .addEdge(n2, n3)
                .addEdge(n2, n4)
                .addEdge(n4, n5)
                .addEdge(n5,n6);
        Assert.assertEquals(1, dc.printCycle(g, n1));
    }


}