package com.library.dynamicprogramming;

/*
* Page 313: Algorithm Design
*/
public class HighLowStressWeek {
    private final int[] l;
    private final int[] h;
    private final int[] optValues;

    public HighLowStressWeek(int[] highStress, int[] lowStress) {
        this.h = highStress;
        this.l = lowStress;
        this.optValues = new int[highStress.length];
    }

    public int getOptimalSolution() {
        int max = _opt(h.length - 1);
        printOptimalSites(h.length - 1);
        return max;
    }

    private void printOptimalSites(int i) {
        if (i == -1) return;

        if (l[i] + _opt(i - 1) > h[i] + _opt(i - 2)) {
            System.out.println("Low Stress Week " + i );
            printOptimalSites(i - 1);
            return;
        }

        System.out.println("High Stress Week " + i );
        printOptimalSites(i - 2);
    }

    private int _opt(int i) {
        if (i < 0) return 0;
        if (optValues[i] != 0) return optValues[i];

        int includeLowStress = l[i] + _opt(i - 1);
        int includeHighStress = h[i] + _opt(i - 2);
        optValues[i] = Math.max(includeLowStress, includeHighStress);
        return optValues[i];
    }
}
