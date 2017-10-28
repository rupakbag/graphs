package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DfsTest {
    private DirectedGraph graph = new DirectedGraph();
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