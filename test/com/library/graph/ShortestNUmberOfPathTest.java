package com.library.graph;

import org.junit.Assert;
import org.junit.Test;

public class ShortestNUmberOfPathTest {
    @Test
    public void test1() {
        Graph ug = Graph.getUndirectedGraphInstance();
        Assert.assertEquals(0, ShortestNUmberOfPath.getShortestNumberPath(ug));
    }
}