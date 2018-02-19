package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class StringSubString {
    public String getSet(String str, int len) {
        Set<String> out = new HashSet<>();
        int startIndex = 0;
        byte[] bytes = str.getBytes();
        Set<Byte> bSet = new HashSet<>();
        int i = 0;

//        startIndex = fill(str, bSet, 0, len);
        while(bSet.size()<len){
            if (bSet.add(bytes[i])) { i++; continue;}
            startIndex = str.indexOf(bytes[i], startIndex) + 1;
            bSet.clear();
            i = startIndex;
        }
        out.add(str.substring(startIndex, startIndex + len));
        i = startIndex + len;
        while(i < bytes.length){
            bSet.remove(bytes[startIndex++]);
            if (bSet.add(bytes[i])) {
                out.add(str.substring(startIndex, startIndex + len));
                i++;
            }
            else {
                startIndex = str.indexOf(bytes[i], startIndex) + 1;
                bSet.clear();
                int j = startIndex;
                while(bSet.size()<len){
                    if (bSet.add(bytes[j])) { j++; continue;}
                    j = str.indexOf(bytes[j], startIndex) + 1;
                    bSet.clear();
                    startIndex = j;
                }
                i = j;
//                startIndex = fill(str, bSet, startIndex, len);
            }
        }
        return out.toString();
    }

    private int fill(String str, Set<Byte> bSet, int index, int len) {
        byte[] bytes = str.getBytes();
        bSet.clear();
        int i = index;
        while(bSet.size()<len){
            if (bSet.add(bytes[i])) { i++; continue;}
            i = str.indexOf(bytes[i], index) + 1;
            bSet.clear();
            index = i;
        }
        return index;
    }
}
