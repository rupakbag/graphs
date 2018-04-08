package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    private final int m;
    private final byte[] s;
    private final ArrayList<String> out;
    byte[] stack;
    int top = -1;

    public Combination(String s, int m) {
        this.s = s.getBytes();
        this.m = m;
        this.out = new ArrayList<>();
    }

    public List<String> find() {
        this.stack  = new byte[m];
        _comb(0,m);
        return out;
    }

    public List<String> findPowerSet() {
        this.stack  = new byte[s.length];
        for (int i = 0; i <= s.length; i++){
            _comb(0,i);
            top = -1;
        }
        return out;
    }

    private void _comb(int idx, int m) {
        if (m == 0){
            out.add(new String(stack));
            return;
        }
        for (int i = idx; i <= s.length - m; i++) {
            stack[++top] = s[i];
            _comb(i + 1, m - 1);
            top--;
        }
    }
}
