package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class PermutationTest {
    @Test
    public void test0(){
        Assert.assertEquals("[a, b, c]", Permutation.permute("abc", 1).toString());
    }

    @Test
    public void test1(){
        Assert.assertEquals("[ab, ac, ba, bc, cb, ca]", Permutation.permute("abc", 2).toString());
    }

    @Test
    public void test2(){
        Assert.assertEquals("[abc, acb, bac, bca, cba, cab]", Permutation.permute("abc", 3).toString());
    }

    @Test
    public void test3(){
        Assert.assertEquals("[ab, ac, ad, ba, bc, bd, cb, ca, cd, db, dc, da]", Permutation.permute("abcd", 2).toString());
    }

    @Test
    public void test4(){
        Assert.assertEquals("[abcd, abdc, acbd, acdb, adcb, adbc, bacd, badc, bcad, bcda, bdca, bdac, cbad, cbda, cabd, cadb, cdab, cdba, dbca, dbac, dcba, dcab, dacb, dabc]",
                Permutation.permute("abcd", 4).toString());
    }
}