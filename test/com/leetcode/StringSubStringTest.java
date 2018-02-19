package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class StringSubStringTest {
    @Test
    public void test1(){
        Assert.assertEquals("[abc, bcd]", new StringSubString().getSet("abcde", 3));
    }

    @Test
    public void test2(){
        Assert.assertEquals("[abc, bcd]", new StringSubString().getSet("abacd", 3));
    }

    @Test
    public void test3(){
        Assert.assertEquals("[abc, bcd]", new StringSubString().getSet("awaglknagawunagwkwagl", 4));
    }
}