package com.library.misc;

/* https://brilliant.org/wiki/rank-of-a-word-in-dictionary/
* Returns rank starting from zero
*/

public class WordRank {
    public int rank(String s) {
        int rank = 0;
        for (int i = 0; i< s.length(); i++) {
            rank += f(s,i);
        }
        return rank;
    }

    private int f(String s, int i) {
        int j = numSmallLetter(s,i);
        int k = s.length() - (i+1);
        return j * fact(k);
    }

    private int numSmallLetter(String s, int i) {
        int ret = 0;
        for (int j = i + 1; j < s.length(); j++) {
            if (s.charAt(j) < s.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }

    private int fact(int k) {
        return (k<=1)? 1 : k * fact(k - 1);
    }

}
