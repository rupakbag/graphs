package com.library.graph;

import org.junit.Assert;
import org.junit.Test;

public class BfsLiteTest {
    @Test
    public void test_bfs_array_impl(){
        int[][] graph = new int[][]{{1,4},{0,2,3},{1},{1},{0,5},{4,6},{5}};
        int[] nodes = BfsLite.bfs(graph,0);
        StringBuilder sb = new StringBuilder();
        for (int i : nodes) {
            sb.append(i).append(" ");
        }
        Assert.assertEquals("0 1 4 2 3 5 6", sb.toString().trim());
    }
    @Test
    public void test_bfs_linkedlist_impl(){
        int[][] graph = new int[][]{{1,4},{0,2,3},{1},{1},{0,5},{4,6},{5}};
        Assert.assertEquals("[0, 1, 4, 2, 3, 5, 6]", BfsLite.bfs_LinkedList(graph,0).toString());
    }

    @Test
    public void testZeros(){
        int[] input = new int[]{1,0};
        BfsLite.moveZeroes(input);
        System.out.println();
    }
}