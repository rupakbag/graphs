package com.misc;

public class Interleaving {
    public static int test1(String a, String b, String c) {
        return interleave(a,0,b,0,c,0);
    }

    private static int interleave(String a, int ai, String b, int bi, String c, int ci) {
        if (a.length() == ai && b.length() == bi && c.length() == ci) return 1;
        char s = c.charAt(ci);
        if (ai < a.length() && bi < b.length() && a.charAt(ai) == s && b.charAt(bi) == s) {
            return interleave(a, ai + 1, b, bi, c, ci + 1) | interleave(a, ai, b, bi + 1, c, ci + 1);
        }
        if (ai < a.length() && s == a.charAt(ai)) {
            return interleave(a, ai+1, b, bi, c, ci+1);
        }
        else if (bi < b.length() && s == b.charAt(bi)) {
            return interleave(a, ai, b, bi+1, c, ci+1);
        }
        else return 0;
    }

    public static int test(String a, String b, String c) {
        int aIdx = 0, oldAidx = 0;
        int bIdx = 0, oldBidx = 0;
        boolean chooseA = false;
        for (int i = 0; i < c.length(); i++) {
            char s = c.charAt(i);
            if (aIdx < a.length() && bIdx < b.length() && (!chooseA) &&
                    a.charAt(aIdx) == b.charAt(bIdx) && b.charAt(bIdx) == s) {
                chooseA = true;
                oldAidx = aIdx++;
                oldBidx = bIdx;
            }
            else if (aIdx < a.length() && s==a.charAt(aIdx)) {
                if (chooseA) {
                    bIdx = oldBidx;
                    chooseA = false;
                }
                aIdx++;
            }
            else if (bIdx < b.length() && s==b.charAt(bIdx)){
                if (chooseA) {
                    aIdx = oldAidx;
                    chooseA = false;
                }
                bIdx++;
            }
            else return 0;
        }
        if (aIdx == a.length() && bIdx == b.length()) return 1;
        return 0;
    }
}
