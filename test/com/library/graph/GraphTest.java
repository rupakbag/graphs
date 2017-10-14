package com.library.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph g = new Graph();
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
    }

    @Test
    public void addNode() throws Exception {
        g.addNode(n1).addNode(n2);

        assertEquals("[n1, n2]", g.v.toString());
        assertEquals(0, n1.incomingEdgeCount);
        assertEquals(0, n2.incomingEdgeCount);
        assertEquals(0,g.e.size());
    }

    @Test
    public void addEdge() throws Exception {
        g.addEdge(Edge.getInstance(n1, n2));
        assertEquals("[n1 -> n2]", g.e.toString());
        assertEquals("[n1, n2]", g.v.toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n1).toString());
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals(1, n2.incomingEdgeCount);

        g.addEdge(Edge.getInstance(n3, n2));
        assertEquals("[n1 -> n2, n3 -> n2]", g.e.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n1).toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);

        g.addEdge(Edge.getInstance(n3, n1));
        assertEquals("[n1 -> n2, n3 -> n2, n3 -> n1]", g.e.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n1).toString());
        assertEquals("[n2, n1]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }

    @Test
    public void removeEdge() throws Exception {
        g.addEdge(Edge.getInstance(n1, n2));
        g.addEdge(Edge.getInstance(n3, n2));
        g.addEdge(Edge.getInstance(n3, n1));

        assertEquals(true, g.removeEdge(Edge.getInstance(n3, n2)));
        assertEquals("[n1 -> n2, n3 -> n1]", g.e.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n1).toString());
        assertEquals("[n1]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals(1, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        assertEquals(false, g.removeEdge(Edge.getInstance(n2, n1)));

        assertEquals(true, g.removeEdge(Edge.getInstance(n1, n2)));
        assertEquals("[n3 -> n1]", g.e.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals(null, g.adjList.getAdjNodeList(n1));
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals("[n1]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(0, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }

    @Test
    public void removeNode() throws Exception {
        g.addEdge(Edge.getInstance(n1, n2));
        g.addEdge(Edge.getInstance(n3, n2));
        g.addEdge(Edge.getInstance(n3, n1));

        g.removeNode(n1);
        assertEquals("[n3 -> n2]", g.e.toString());
        assertEquals("[n2, n3]", g.v.toString());
        assertEquals(null, g.adjList.getAdjNodeList(n1));
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals("[n2]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(1, n2.incomingEdgeCount);
        assertEquals(0, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        g.addEdge(Edge.getInstance(n1, n2));
        g.addEdge(Edge.getInstance(n3, n1));
        assertEquals("[n3 -> n2, n1 -> n2, n3 -> n1]", g.e.toString());
        assertEquals("[n2, n3, n1]", g.v.toString());
        assertEquals("[n2]", g.adjList.getAdjNodeList(n1).toString());
        assertEquals("[n2, n1]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        g.removeNode(n2);
        assertEquals("[n3 -> n1]", g.e.toString());
        assertEquals("[n3, n1]", g.v.toString());
        assertEquals(null, g.adjList.getAdjNodeList(n1));
        assertEquals(null, g.adjList.getAdjNodeList(n2));
        assertEquals("[n1]", g.adjList.getAdjNodeList(n3).toString());
        assertEquals(0, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }
}