package com.leetcode;

import com.library.graph.Graph;
import com.library.graph.Node;
import org.junit.Assert;
import org.junit.Test;

public class MaxPathBinaryTreeTest {
    private Node n10,n2,n20,n1,n101,n25N,n3,n4;
    @Test
    public void test1(){
        Graph g = Graph.getUndirectedGraphInstance();
        n10 = Node.getInstance("n10");
        n10.satDataRefHolder = Integer.valueOf(10);
        n2 = Node.getInstance("n2");
        n2.satDataRefHolder = Integer.valueOf(2);
        n20 = Node.getInstance("n20");
        n20.satDataRefHolder = Integer.valueOf(20);
        n1 = Node.getInstance("n1");
        n1.satDataRefHolder = Integer.valueOf(1);
        n101 = Node.getInstance("n101");
        n101.satDataRefHolder = Integer.valueOf(10);
        n25N = Node.getInstance("n25N");
        n25N.satDataRefHolder = Integer.valueOf(-25);
        n3 = Node.getInstance("n3");
        n3.satDataRefHolder = Integer.valueOf(3);
        n4 = Node.getInstance("n4");
        n4.satDataRefHolder = Integer.valueOf(4);

        g.addEdge(n10,n2).addEdge(n2,n20).addEdge(n2, n1).addEdge(n10,n101).addEdge(n10,n25N).addEdge(n25N,n3)
                .addEdge(n25N, n4);

        Assert.assertEquals(42, MaxPathBinaryTree.getMaxPath(g));
    }

    @Test
    public void test2(){
        Graph g = Graph.getUndirectedGraphInstance();
        n1 = Node.getInstance("n1");
        n1.satDataRefHolder = Integer.valueOf(1);
        n2 = Node.getInstance("n2");
        n2.satDataRefHolder = Integer.valueOf(2);
        n3 = Node.getInstance("n3");
        n3.satDataRefHolder = Integer.valueOf(3);

        g.addEdge(n1,n2).addEdge(n1,n3);

        Assert.assertEquals(6, MaxPathBinaryTree.getMaxPath(g));
    }
}