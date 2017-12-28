package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DfsTest {
    private Graph graph = new Graph(false);
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
        graph.addEdge(n1, n2)
        .addEdge(n1, n3)
        .addEdge(n2, n4)
        .addEdge(n2, n5)
        .addEdge(n3, n5)
        .addEdge(n3, n7)
        .addEdge(n3, n8)
        .addEdge(n5, n6)
        .addEdge(n9, n10)
        .addEdge(n11, n12)
        .addEdge(n12, n13);
    }

    @Test
    public void dfsNodeOrder(){
        Dfs dfs = new Dfs(this.graph);
        Assert.assertEquals("[n1, n2, n4, n5, n6, n3, n7, n8]", dfs.getDfsNodeOrder(n1));
    }
}