package com.library.graph;

import org.junit.Assert;
import org.junit.Test;

public class BipartiteTest {
    @Test
    public void test(){
        int[][] g = new int[][]{{1,3}, {0,2}, {1,3}, {0,2}};
        Assert.assertEquals(true, Bipartite.isBipartite(g));
    }

    @Test
    public void test1(){
        int[][] g = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        Assert.assertEquals(false, Bipartite.isBipartite(g));
    }

}