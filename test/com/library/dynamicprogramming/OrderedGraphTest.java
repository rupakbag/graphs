package com.library.dynamicprogramming;

import com.library.graph.Edge;
import com.library.graph.Graph;
import com.library.graph.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderedGraphTest {
    OrderedGraph ogt;
    Graph g;
    Node v1, v2, v3, v4, v5;

    @Before
    public void setUp(){
        g = new Graph();
        ogt = new OrderedGraph(g);
        v1 = Node.getInstance("v1");
        v2 = Node.getInstance("v2");
        v3 = Node.getInstance("v3");
        v4 = Node.getInstance("v4");
        v5 = Node.getInstance("v5");
    }

    @Test
    public void longest_Path_In_Ordered_Graph(){
        g.addEdge(Edge.getInstance(v1, v4))
            .addEdge(Edge.getInstance(v1, v2))
            .addEdge(Edge.getInstance(v2, v4))
            .addEdge(Edge.getInstance(v2, v5))
            .addEdge(Edge.getInstance(v3, v4))
            .addEdge(Edge.getInstance(v4, v5));
        Assert.assertEquals(3, ogt.getLongestPath(v1, v5));
    }

}