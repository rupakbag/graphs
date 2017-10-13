package com.library.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BfsTest {
    private DirectedGraph graph = new DirectedGraph();
//    private Node n1 = Node.getInstance("n1");
//    private Node n2 = Node.getInstance("n2");
//    private Node n3 = Node.getInstance("n3");
//    private Node n4 = Node.getInstance("n4");
//    private Node n5 = Node.getInstance("n5");
//    private Node n6 = Node.getInstance("n6");
//    private Node n7 = Node.getInstance("n7");
//    private Node n8 = Node.getInstance("n8");
//    private Node n9 = Node.getInstance("n9");
//    private Node n10 = Node.getInstance("n10");
//    private Node n11 = Node.getInstance("n11");
//    private Node n12 = Node.getInstance("n12");
//    private Node n13 = Node.getInstance("n13");

    @Before
    public void setup() {
//        graph.addEdge(n1, n2);
//        graph.addEdge(n1, n3);
//        graph.addEdge(n2, n3);
//        graph.addEdge(n2, n4);
//        graph.addEdge(n2, n5);
//        graph.addEdge(n4, n5);
//        graph.addEdge(n3, n5);
//        graph.addEdge(n3, n7);
//        graph.addEdge(n3, n8);
//        graph.addEdge(n7, n8);
//        graph.addEdge(n5, n6);
//        graph.addEdge(n9, n10);
//        graph.addEdge(n11, n12);
//        graph.addEdge(n12, n13);
    }

    @Test
    public void printBfs() throws Exception {
        Bfs<Node, Edge<Node>> bfs = new Bfs<>(graph);
//        bfs.generateBfs(n1);
        Assert.assertEquals("[n2, n3]", bfs.getBfsNodeListString(1));
    }

}