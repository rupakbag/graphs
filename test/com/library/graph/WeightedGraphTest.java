package com.library.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightedGraphTest {
    private WeightedGraph g;;
    private Node n1,n2,n3,n4,n5,n6,n7;

    @Before
    public void setUp() throws Exception {
        g = WeightedGraph.getDirectedGraphInstance();
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");
        n7 = Node.getInstance("n7");
    }

    @Test
    public void addNode() throws Exception {
        g.addNode(n1).addNode(n2);

        assertEquals("[n1, n2]", g.v.toString());
        assertEquals(2, g.v.size());
        assertEquals(0, n1.incomingEdgeCount);
        assertEquals(0, n2.incomingEdgeCount);
    }

    @Test
    public void addEdge() throws Exception {
        g.addEdge(n1, n2, 2);
        assertEquals("[n1 -> n2(2)]", g.toString());
        assertEquals("[n1, n2]", g.v.toString());
        assertEquals("[n2(2)]", g.getAdjNodeList(n1).toString());
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals(1, n2.incomingEdgeCount);

        g.addEdge(n3, n2, 5);
        assertEquals("[n1 -> n2(2), n3 -> n2(5)]", g.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2(2)]", g.getAdjNodeList(n1).toString());
        assertEquals("[n2(5)]", g.getAdjNodeList(n3).toString());
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);

        g.addEdge(n3, n1, 1);
        assertEquals("[n1 -> n2(2), n3 -> n2(5), n3 -> n1(1)]", g.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2(2)]", g.getAdjNodeList(n1).toString());
        assertEquals("[n2(5), n1(1)]", g.getAdjNodeList(n3).toString());
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }

    @Test
    public void removeEdge() throws Exception {
        g.addEdge(n1, n2, 2);
        g.addEdge(n3, n2, 5);
        g.addEdge(n3, n1, 1);

        assertEquals("[n1 -> n2(2), n3 -> n2(5), n3 -> n1(1)]", g.toString());
        g.removeEdge(n3, n2);
        assertEquals("[n1 -> n2(2), n3 -> n1(1)]", g.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2(2)]", g.getAdjNodeList(n1).toString());
        assertEquals("[n1(1)]", g.getAdjNodeList(n3).toString());
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals(1, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        g.removeEdge(n1, n2);
        assertEquals("[n3 -> n1(1)]", g.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals(null, g.getAdjNodeList(n1));
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals("[n1(1)]", g.getAdjNodeList(n3).toString());
        assertEquals(0, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }

    @Test
    public void removeNode() throws Exception {
        g.addEdge(n1, n2, 2);
        g.addEdge(n3, n2, 5);
        g.addEdge(n3, n1, 1);

        assertEquals("[n1 -> n2(2), n3 -> n2(5), n3 -> n1(1)]", g.toString());
        g.removeNode(n1);
        assertEquals("[n3 -> n2(5)]", g.toString());
        assertEquals("[n2, n3]", g.v.toString());
        assertEquals(null, g.getAdjNodeList(n1));
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals("[n2(5)]", g.getAdjNodeList(n3).toString());
        assertEquals(1, n2.incomingEdgeCount);
        assertEquals(0, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        g.addEdge(n1, n2, 3);
        g.addEdge(n3, n1, 1);
        assertEquals("[n1 -> n2(3), n3 -> n2(5), n3 -> n1(1)]", g.toString());
        assertEquals("[n1, n2, n3]", g.v.toString());
        assertEquals("[n2(3)]", g.getAdjNodeList(n1).toString());
        assertEquals("[n2(5), n1(1)]", g.getAdjNodeList(n3).toString());
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals(2, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);

        g.removeNode(n2);
        assertEquals("[n3 -> n1(1)]", g.toString());
        assertEquals("[n1, n3]", g.v.toString());
        assertEquals(null, g.getAdjNodeList(n1));
        assertEquals(null, g.getAdjNodeList(n2));
        assertEquals("[n1(1)]", g.getAdjNodeList(n3).toString());
        assertEquals(0, n2.incomingEdgeCount);
        assertEquals(1, n1.incomingEdgeCount);
        assertEquals(0, n3.incomingEdgeCount);
    }

}