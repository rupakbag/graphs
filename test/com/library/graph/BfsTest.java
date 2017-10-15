package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BfsTest {
    private DirectedGraph graph = new DirectedGraph();
    private Node n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;

    @Before
    public void setup() {
        n1 = new Node("n1");
        n2 = new Node("n2");
        n3 = new Node("n3");
        n4 = new Node("n4");
        n5 = new Node("n5");
        n6 = new Node("n6");
        n7 = new Node("n7");
        n8 = new Node("n8");
        n9 = new Node("n9");
        n10 = new Node("n10");
        n11 = new Node("n11");
        n12 = new Node("n12");
        n13 = new Node("n13");
        graph.addEdge(Edge.getInstance(n1, n2));
        graph.addEdge(Edge.getInstance(n1, n3));
        graph.addEdge(Edge.getInstance(n2, n3));
        graph.addEdge(Edge.getInstance(n2, n4));
        graph.addEdge(Edge.getInstance(n2, n5));
        graph.addEdge(Edge.getInstance(n4, n5));
        graph.addEdge(Edge.getInstance(n3, n5));
        graph.addEdge(Edge.getInstance(n3, n7));
        graph.addEdge(Edge.getInstance(n3, n8));
        graph.addEdge(Edge.getInstance(n7, n8));
        graph.addEdge(Edge.getInstance(n5, n6));
        graph.addEdge(Edge.getInstance(n9, n10));
        graph.addEdge(Edge.getInstance(n11, n12));
        graph.addEdge(Edge.getInstance(n12, n13));
    }

    @Test
    public void printBfs() throws Exception {
        Bfs bfs = new Bfs(graph);
        bfs.generateBfs(n1);
        Assert.assertEquals("[n2, n3]", bfs.getBfsNodeListString(1));
        Assert.assertEquals("[n4, n5, n7, n8]", bfs.getBfsNodeListString(2));
        Assert.assertEquals("[n6]", bfs.getBfsNodeListString(3));
        Assert.assertEquals(null, bfs.getBfsNodeListString(4));

        bfs.generateBfs(n3);
        Assert.assertEquals("[n7, n8]", bfs.getBfsNodeListString(1));
    }

}