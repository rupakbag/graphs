package com.library.divideNconquer;

import com.library.misc.WordRank;
import org.junit.Assert;
import org.junit.Test;

public class WordRankTest {
    @Test
    public void rank() throws Exception {
        WordRank t = new WordRank();
        Assert.assertEquals(2, t.rank("bac"));
    }

}