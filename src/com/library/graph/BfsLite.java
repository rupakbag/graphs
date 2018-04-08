package com.library.graph;

//O(m+n)
// O(n) because of the time needed to create fixed size arrays
// O(m) because the while loop runs once for each edge

import java.util.ArrayList;
import java.util.LinkedList;

public class BfsLite {
    public static int[] bfs(int[][] g, int n) {
        int[] nodes = new int[g.length];
        byte[] b = new byte[g.length];
        int[] queue = new int[g.length];
        int qStartIndex = 0, qEndIndex = 0;
        int nIndex = 0;

        queue[qEndIndex++] = n;

        while(qStartIndex < qEndIndex) {
            int e = queue[qStartIndex++];
            nodes[nIndex++] = e;
            b[e] = 1;

            for (int i : g[e]){
                if (b[i] == 0) {
                    queue[qEndIndex++] = i;
                }
            }
        }
        return nodes;
    }

    static String decode(String encodedMessage) {
        StringBuilder b = new StringBuilder();
        int offset = 0;
        for (int i=encodedMessage.length() - 1; i >= 0; i--) {
            b.append((char)(((encodedMessage.charAt(i) - offset++)/2)));
        }
        return b.toString();
    }

    public static void moveZeroes(int[] nums) {
        int nZ = -1;
        int z = -1;
        int i = 0;
        while (i<nums.length) {
            if (nums[i] > 0 && nZ == -1) nZ = i;
            if (nums[i] == 0 && z == -1) z = i;
            if (z > -1 && nZ > -1) {
                swap(nums,z,nZ);
                z++;
                nZ = -1;
            }
            i++;
        }
    }

    static void  swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static ArrayList<Integer> bfs_LinkedList(int[][] g, int n){
        byte[] visited = new byte[g.length];
        ArrayList<Integer> nodes = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(n);
        while(!queue.isEmpty()){
            int e = queue.remove();
            nodes.add(e);
            visited[e] = 1;

            for(int i : g[e]) {
                if (visited[i] == 0) {
                    queue.add(i);
                }
            }
        }
        return nodes;
    }
}
