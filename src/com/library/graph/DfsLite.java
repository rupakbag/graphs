package com.library.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DfsLite {
// Non resursive using stack
//O(m+n)
// O(n) because of the time needed to create fixed size arrays
// O(m) because the while loop runs once for each edge

    public static int[] dfs(int[][] g, int n) {
        int[] nodes = new int[g.length];
        byte[] b = new byte[g.length];
        int[] stack = new int[g.length];
        int sIndex = 0;
        int nIndex = 0;

        stack[sIndex++] = n;

        while (sIndex > 0) {
            int e = stack[--sIndex];
            nodes[nIndex++] = e;
            b[e] = 1;

            for (int i : g[e]) {
                if (b[i] == 0) {
                    stack[sIndex++] = i;
                }
            }
        }

        return nodes;
    }

    public static ArrayList<Integer> dfs_LinkedList(int[][] g, int n) {
        byte[] b = new byte[g.length];
        ArrayList<Integer> nodes = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();

        stack.addLast(n);

        while (!stack.isEmpty()) {
            int e = stack.removeLast();
            nodes.add(e);
            b[e] = 1;

            for (int i : g[e]) {
                if (b[i] == 0) {
                    stack.addLast(i);
                }
            }
        }

        return nodes;
    }
}
