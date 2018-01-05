package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BfsTest {
    private Graph graph = Graph.getDirectedGraphInstance();
    private Node n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13;

    @Before
    public void setup() {
        n1 = Node.getInstance("n1");
        n2 = Node.getInstance("n2");
        n3 = Node.getInstance("n3");
        n4 = Node.getInstance("n4");
        n5 = Node.getInstance("n5");
        n6 = Node.getInstance("n6");
        n7 = Node.getInstance("n7");
        n8 = Node.getInstance("n8");
        n9 = Node.getInstance("n9");
        n10 = Node.getInstance("n10");
        n11 = Node.getInstance("n11");
        n12 = Node.getInstance("n12");
        n13 = Node.getInstance("n13");
        graph.addEdge(n1, n2);
        graph.addEdge(n1, n3);
        graph.addEdge(n2, n3);
        graph.addEdge(n2, n4);
        graph.addEdge(n2, n5);
        graph.addEdge(n4, n5);
        graph.addEdge(n3, n5);
        graph.addEdge(n3, n7);
        graph.addEdge(n3, n8);
        graph.addEdge(n7, n8);
        graph.addEdge(n5, n6);
        graph.addEdge(n9, n10);
        graph.addEdge(n11, n12);
        graph.addEdge(n12, n13);
    }

    @Test
    public void printBfs() throws Exception {
        Bfs bfs = new Bfs(graph);
        bfs.generateBfs(n1);
        Assert.assertEquals("[n2, n3]", bfs.getBfsNodeListString(1));
        Assert.assertEquals("[n4, n5, n7, n8]", bfs.getBfsNodeListString(2));
        Assert.assertEquals("[n6]", bfs.getBfsNodeListString(3));
        Assert.assertEquals(null, bfs.getBfsNodeListString(4));
    }

}