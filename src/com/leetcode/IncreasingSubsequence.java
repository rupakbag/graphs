package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class IncreasingSubsequence {
    private static StringBuilder out = new StringBuilder();

    public static String getSequence(int[] input) {
        ArrayList<Integer> integerInput = new ArrayList<>(input.length);
        for (int i : input) {
            integerInput.add(Integer.valueOf(i));
        }
        Collections.sort(integerInput);
        for (int i = 0; i < integerInput.size(); i++) {
            _subsequence(integerInput, i, integerInput.size() - 1);
        }
        return out.toString();
    }

    private static void _subsequence(ArrayList<Integer> input, int i, int j) {
        for (int s = i + 1; s <= j; s++){
            _sub(input, i, s);
        }
    }

    private static void _sub(ArrayList<Integer> input, int i, int j) {
        out.append("[");
        for (int index = i; index <=j; index++) {
            out.append(input.get(index)).append(",");
        }
        out.append("]");
    }
}
