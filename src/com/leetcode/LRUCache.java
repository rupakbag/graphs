package com.leetcode;

import java.util.HashMap;
import java.util.Map;
//    https://leetcode.com/problems/lru-cache/description/
// Use Circular Linked List
public class LRUCache {
    class Entry {
        int k;
        int v;
        Entry prev = null;
        Entry next = null;
        Entry(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    Entry head = null; //Represents the LRU element to be evicted when cache is full
    Map<Integer, Entry> m;
    int capacity;
    public LRUCache(int capacity) {
        this.m = new HashMap(capacity);
        this.capacity = capacity;
    }

    public int get(int k) {
        if (m.containsKey(k)) {
            Entry e = m.get(k);
            update(e);
            return e.v;
        }
        return -1;
    }

    public void put(int k, int v) {
        Entry e;
        if (m.containsKey(k)) {
            e = m.get(k);
            e.v = v;
        }
        else if (m.size() == capacity) {
            e = head;
            m.remove(head.k);
            head.k = k;
            head.v = v;
            m.put(k, e);
        }
        else {
            e = new Entry(k,v);
            m.put(k, e);
        }
        update(e);
    }

    void update(Entry e){
        if (head == null) {
            head = e;
            head.next = e;
            e.prev = head;
            return;
        }
        if (e == head) {
            head = head.next;
            return;
        }

        if (e.prev != null) e.prev.next = e.next;
        if (e.next != null) e.next.prev = e.prev;
        Entry temp = head.prev;
        e.next = head;
        head.prev = e;
        temp.next = e;
        e.prev = temp;
    }
}
