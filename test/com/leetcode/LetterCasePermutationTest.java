package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LetterCasePermutationTest {
    @Test
    public void test(){
        Assert.assertEquals("[a1b2, a1B2, A1b2, A1B2]", LetterCasePermutation.permute("a1b2"));
    }
    @Test
    public void test1(){
        Assert.assertEquals("[3z4, 3Z4]", LetterCasePermutation.permute("3z4"));
    }
    @Test
    public void test2(){
        Assert.assertEquals("[12345]", LetterCasePermutation.permute("12345"));
    }
    @Test
    public void test3(){
        Assert.assertEquals("[C, c]", LetterCasePermutation.permute("C"));
    }

    @Test
    public void test4(){
        Assert.assertEquals("blue is sky the", LetterCasePermutation.reverseWords("the sky is blue"));
    }
}