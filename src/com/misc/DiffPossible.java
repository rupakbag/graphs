package com.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffPossible {
    public static int test(String s, int b) {
        List<Integer> l = new ArrayList<>();
        for (String s1 : s.split(" ")){
            l.add(Integer.parseInt(s1));
        }
        return diffPossible(l, b);
    }

    public static int diffPossible(final List<Integer> a, int b) {
        if (a.size() < 2) return 0;
        Collections.sort(a);
        int x = a.get(0);
        for (int i = 1; i<a.size(); i++) {
            int y = a.get(i);
            if (y - x == b) {
                return 1;
            }
            x = y;
        }
        return 0;
    }
}
