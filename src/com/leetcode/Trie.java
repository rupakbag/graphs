package com.leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    class Node {
        boolean isWord;
        HashMap<Character, Node> children;
    }

    final Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        for (char c : word.toCharArray()) {
            if (n.children == null) {
                n.children = new HashMap<>();
            }
            if (!n.children.containsKey(c)) {
                n.children.put(c, new Node());
            }
            n = n.children.get(c);
        }
        n.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = root;
        for (char c : word.toCharArray()) {
            if (n.children == null || !n.children.containsKey(c)) return false;
            n = n.children.get(c);
        }
        return n.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root;
        for (char c : prefix.toCharArray()) {
            if (n.children == null || !n.children.containsKey(c)) return false;
            n = n.children.get(c);
        }
        return true;
    }

//    https://leetcode.com/problems/map-sum-pairs/description/
    class MapSum {
        class Node {
            int val = 0;
            HashMap<Character, Node> children;
        }

        final Node root;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            Node n = root;
            for (char c : key.toCharArray()) {
                if (n.children == null) {
                    n.children = new HashMap<>();
                }
                if (!n.children.containsKey(c)) {
                    n.children.put(c, new Node());
                }
                n = n.children.get(c);
            }
            n.val = val;
        }

        public int sum(String prefix) {
            Node n = root;
            for (char c : prefix.toCharArray()) {
                if (n.children == null || !n.children.containsKey(c)) return 0;
                n = n.children.get(c);
            }

            return findSum(n);
        }

        int findSum(Node root) {
            if  (root.children == null) {
                return root.val;
            }

            int sum = root.val;
            for(Node n : root.children.values()) {
                sum +=findSum(n);
            }
            return sum;
        }
    }

}

