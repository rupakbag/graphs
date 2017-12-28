package com.library.divideNconquer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class WordSegmentation {
    int[] optValue;
    int[] optIndex;

    String input;
    private final static HashSet<String> dictionary = new HashSet<>();
    static {
        dictionary.add("meet");
        dictionary.add("me");
        dictionary.add("at");
        dictionary.add("eight");
        dictionary.add("i");
        dictionary.add("love");
        dictionary.add("you");
    }

    public String getopt(String input) {
        this.input = input;
        this.optValue = new int[input.length()];
        this.optIndex = new int[input.length()];
        Arrays.fill(optValue, 0);

        for (int j = 0; j < input.length(); j++) {
            this.optValue[j] = _getOpt(j);
        }
        return getString();
    }

    private int _getOpt(int j) {
        if (j == -1) return 0;
        if (this.optValue[j] > 0) return this.optValue[j];

        int maxOptValue = -1;
        for (int i = 0; i <= j; i++) {
            int opt = quality(i, j) + _getOpt(i - 1);
            if (maxOptValue < opt) {
                maxOptValue = opt;
                optIndex[j] = i;
            }
        }
        return maxOptValue;
    }

    private int quality(int i, int j) {
        return this.dictionary.contains(input.substring(i, j + 1))?
                j - i + 1 : 0;
    }

    private String getString() {
        StringBuilder sb = new StringBuilder();
        int i = input.length() - 1;
        LinkedList<String> ll = new LinkedList<>();
        while (i >= 0) {
            ll.addFirst(input.substring(optIndex[i], i + 1));
            i = optIndex[i] - 1;
        }
        return ll.toString();
    }
}
