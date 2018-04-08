package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) {
            if (m.containsKey(i)) m.put(i, m.get(i) + 1);
            else m.put(i,1);
        }

        List<Integer> ret = new ArrayList<>();
        while (k-- > 0) {
            int max = 0;
            int maxVal = -1;
            for(Map.Entry<Integer, Integer> e : m.entrySet()) {
                if (maxVal < e.getValue()) {
                    maxVal = e.getValue();
                    max = e.getKey();
                }
            }
            ret.add(max);
            m.remove(max);
        }
        return ret;
    }
}
