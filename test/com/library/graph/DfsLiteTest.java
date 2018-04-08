package com.library.graph;

import org.junit.Assert;
import org.junit.Test;

public class DfsLiteTest {
    @Test
    public void test_dfs_array_impl(){
        int[][] graph = new int[][]{{1,4},{0,2,3},{1},{1},{0}};
        int[] nodes = DfsLite.dfs(graph,0);
        StringBuilder sb = new StringBuilder();
        for (int i : nodes) {
            sb.append(i).append(" ");
        }
        Assert.assertEquals("0 4 1 3 2", sb.toString().trim());
    }

    @Test
    public void test_dfs_linkedlist_impl(){
        int[][] graph = new int[][]{{1,4},{0,2,3},{1},{1},{0}};
        Assert.assertEquals("[0, 4, 1, 3, 2]", DfsLite.dfs_LinkedList(graph,0).toString());
    }
}