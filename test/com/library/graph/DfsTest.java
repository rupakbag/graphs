package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DfsTest {
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
        graph.addEdge(Edge.getInstance(n2, n4));
        graph.addEdge(Edge.getInstance(n2, n5));
        graph.addEdge(Edge.getInstance(n3, n5));
        graph.addEdge(Edge.getInstance(n3, n7));
        graph.addEdge(Edge.getInstance(n3, n8));
        graph.addEdge(Edge.getInstance(n5, n6));
        graph.addEdge(Edge.getInstance(n9, n10));
        graph.addEdge(Edge.getInstance(n11, n12));
        graph.addEdge(Edge.getInstance(n12, n13));
    }

    @Test
    public void dfsNodeOrder(){
        Dfs dfs = new Dfs(this.graph);
        Assert.assertEquals("[n1, n2, n4, n5, n6, n3, n7, n8]", dfs.getDfsNodeOrder(n1));
    }
}