package com.misc;

public class Fibonacci {
    public static int getFibRecursive(int n) {
        if (n <= 1) return 1;
        return getFibRecursive(n-1) + getFibRecursive(n-2);
    }

    public static int getFibIterative(int n) {
        int[] val = new int[n + 1];
        val[0] = 1;
        val[1] =1;
        for (int j = 2; j <= n; j++) {
            val[j] = val[j-1] + val[j-2];
        }
        return val[n];
    }

    public static int getFibSpaceOptimized(int n) {
        int fib0 = 1;
        int fib1 = 1;
        for (int j = 2; j <= n; j++) {
            int temp = fib0 + fib1;
            fib0 = fib1;
            fib1 = temp;
        }
        return fib1;
    }
}
