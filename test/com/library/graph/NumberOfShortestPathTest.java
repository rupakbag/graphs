package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfShortestPathTest {
    private Graph ug;
    private Node n1,n2,n3,n4,n5,n6,n7;

    @Before
    public void setUp() throws Exception {
        ug = Graph.getUndirectedGraphInstance();
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");
        n7 = Node.getInstance("n7");
    }

    @Test
    public void multiple_equal_distance_path() {
        ug.addEdge(n1, n2).addEdge(n1, n3).addEdge(n3 ,n4). addEdge(n2, n5).addEdge(n5, n6).addEdge(n4, n6);
        Assert.assertEquals(2, NumberOfShortestPath.getNumberOfShortestPath(ug, n1, n6));
    }

    @Test
    public void multiple_path_different_distance() {
        ug.addEdge(n1, n2).addEdge(n1, n3).addEdge(n3 ,n4). addEdge(n2, n5).addEdge(n5, n6).addEdge(n4, n7).addEdge(n7, n6);
        Assert.assertEquals(1, NumberOfShortestPath.getNumberOfShortestPath(ug, n1, n6));
    }
}