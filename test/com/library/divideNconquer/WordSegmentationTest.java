package com.library.divideNconquer;

import org.junit.Assert;
import org.junit.Test;

public class WordSegmentationTest {

    @Test
    public void test1(){
        WordSegmentation ws = new WordSegmentation();
        Assert.assertEquals("[meet, me, at, eight]", ws.getopt("meetmeateight"));
    }

    @Test
    public void test2(){
        WordSegmentation ws = new WordSegmentation();
        Assert.assertEquals("[i, love, you]", ws.getopt("iloveyou"));
    }
}