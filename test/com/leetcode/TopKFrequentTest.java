package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class TopKFrequentTest {
    @Test
    public void top_frequency_different(){
        Assert.assertEquals("[1, 2]", TopKFrequent.topKFrequent(new int[]{1,1,1,2,3,2},2).toString());
    }

    @Test
    public void top_frequency_same(){
        Assert.assertEquals("[17, 1]", TopKFrequent.topKFrequent(new int[]{17,1,1,17,1,17,2,3,2},2).toString());
    }

}