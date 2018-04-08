package com.library.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public static boolean isBipartite(int[][] g){
        Queue<Integer> q = new LinkedList<>();
        byte[] color = new byte[g.length];

        for (int n = 0; n < g.length; n++) {
            if (color[n] == 0 && g[n].length > 0) {
                q.add(n);
                color[n] = 1;
                while (q.size() > 0) {
                    int e = q.remove();
                    for (int i : g[e]) {
                        if (color[e] == color[i]) return false;
                        if (color[i] == 0) {
                            q.add(i);
                            color[i] = (byte) ((color[e] == 1)? 2 : 1);
                        }
                    }
                }
            }
        }
        return  true;
    }
}
