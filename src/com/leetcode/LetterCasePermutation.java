package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LetterCasePermutation {
    public static String permute(String s) {
        List<String> ret = new ArrayList<>();
        List<String> ret1 = new ArrayList<>();
        List<String> temp;

        byte[] bytes = s.getBytes();
        for(byte b : bytes) {
            if (ret.size() == 0) {
                ret.add(String.valueOf((char)b));
                if (Character.isLetter(b)) ret.add(transform(b));
            }
            else {
                Iterator<String> i = ret.iterator();
                while(i.hasNext()) {
                    String s1 = i.next();
                    ret1.add(String.valueOf(s1 + (char)b));
                    if (Character.isLetter(b)) ret1.add(s1 + transform(b));
                }
                ret.clear();
                temp = ret;
                ret = ret1;
                ret1 = temp;
            }
        }
        return ret.toString();
    }

    private static String transform(byte b) {
        return Character.isLowerCase(b)? String.valueOf((char)Character.toUpperCase(b)) :
                String.valueOf((char)Character.toLowerCase(b));
    }

    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = arr.length - 1;
        while (len >= 0) {
            if (arr[len].length() > 0) {
                sb.append(arr[len]).append(" ");
            }
            len--;
        }
        return sb.toString().trim();
    }
}
