package com.misc;

public class Fibonacci {
    public static int getFibRecursive(int i) {
        if (i <= 1) return 1;
        return getFibRecursive(i-1) + getFibRecursive(i-2);
    }

    public static int getFibIterative(int i) {
        int[] val = new int[i + 1];
        val[0] = 1;
        val[1] =1;
        for (int j = 2; j <= i; j++) {
            val[j] = val[j-1] + val[j-2];
        }
        return val[i];
    }

    public static int getFibSpaceOptimized(int i) {
        int fib0 = 1;
        int fib1 = 1;
        for (int j = 2; j <= i; j++) {
            int temp = fib0 + fib1;
            fib0 = fib1;
            fib1 = temp;
        }
        return fib1;
    }
}
