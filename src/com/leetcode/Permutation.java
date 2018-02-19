package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private static final List<String> out = new ArrayList<>();

    public static List<String> permute(String input, int m) {
        _permute(input.toCharArray(), 0, m);
        return out;
    }

    private static void _permute(char[] n, int index, int m) {
        if (index == m) {
            out.add(String.valueOf(n, 0, m));
            return;
        }
        for (int i = index; i < n.length; i++) {
            swap(n, index, i);
            _permute(n, index + 1, m);
            swap(n, index, i);
        }
    }

    private static void swap(char[] n, int i1, int i2) {
        char temp = n[i1];
        n[i1] = n[i2];
        n[i2] = temp;
    }
}
