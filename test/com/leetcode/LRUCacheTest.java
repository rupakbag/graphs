package com.leetcode;

import org.junit.Test;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache c = new LRUCache(3);
        c.put(1,100);
        c.put(2,200);
        c.put(3,300);
        System.out.println(c.get(2));
        System.out.println(c.get(4));
        System.out.println(c.get(1));
        c.put(4,400);
    }
}