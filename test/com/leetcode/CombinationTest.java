package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CombinationTest {
    @Test
    public void test0(){
        Combination c = new Combination("abcd", 4);
        Assert.assertEquals("[abcd]", c.find().toString());
    }
    @Test
    public void test3(){
        Combination c = new Combination("abcd", 3);
        Assert.assertEquals("[abc, abd, acd, bcd]", c.find().toString());
    }

    @Test
    public void test1(){
        Combination c = new Combination("abcd", 2);
        Assert.assertEquals("[ab, ac, ad, bc, bd, cd]", c.find().toString());
    }

    @Test
    public void test6(){
        Combination c = new Combination("abcd", 1);
        Assert.assertEquals("[a, b, c, d]", c.find().toString());
    }

    @Test
    public void test4(){
        Combination c = new Combination("abcd", 0);
        Assert.assertEquals("[]", c.find().toString());
    }

    @Test
    public void test5(){
        Combination c = new Combination("abcd", 4);
        Assert.assertEquals("[    , a   , b   , c   , d   , ab  , ac  , ad  , bc  , bd  , cd  , abc , abd , acd , bcd , abcd]", c.findPowerSet().toString());
    }
}