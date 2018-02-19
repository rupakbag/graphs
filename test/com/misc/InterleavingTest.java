package com.misc;

import org.junit.Assert;
import org.junit.Test;

public class InterleavingTest {
    @Test
    public void test(){
        String s3 = "eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D";
        String s2 = "UhSQsB6CWAHE6zzphz5BIAHqSWIY24D";
        String s1 = "eZCHXr0CgsB4O3TCDlitYI7kH38rEElI";
        Assert.assertEquals(1, Interleaving.test1(s1, s2, s3));
    }
    @Test
    public void test1(){
        String s1 = "e";
        String s2 = "B";
        String s3 = "Be";
        Assert.assertEquals(1, Interleaving.test1(s1, s2, s3));
    }
}