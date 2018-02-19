package com.misc;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        getRotation(n,k,a);
    }

    public static String getRotation(int n, int k, int[] a) {
        int[] temp = Arrays.copyOfRange(a,0, k);
//        print(temp);
        move(a, k);
        copyArray(a, temp);
        print(a);
        return "";
    }

    private static void move(int[] a, int k) {
        for (int i = k; i < a.length; i++){
            a[i-k] = a[i];
        }
    }

    private static void copyArray(int[] a, int[] t) {
        int aIndex = a.length - t.length;
        for (int i = 0; i < t.length; i++) {
            a[aIndex++] = t[i];
        }
    }

    private static void print(int[] a) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i < a.length; i++) {
            sb.append(a[i]).append(" ");
        }
        String s = sb.toString().trim();
        System.out.println(s);
    }
}

