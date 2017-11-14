package com.library.dynamicprogramming;
/*
* Page 307: Algorithm Design
* Billboard sites are location offset on a highway from one end. Revenue is associated with each site
* Goal: Maximise revenue such that each site is more than minDistance away from each other
 */
public class Billboard {
    private final int minDistance;
    private int[] sites, revenue, optValues;

    public Billboard(int[] sites, int[] revenue, int minDistance) {
        this.sites = sites;
        this.revenue = revenue;
        this.minDistance = minDistance;
        this.optValues = new int[sites.length];
    }

    public int getMaxRevenue() {
        int max = _opt(sites.length - 1);
        printOptimalSites(sites.length - 1);
        return max;
    }

    private void printOptimalSites(int i) {
        if (i == -1) return;

        int pIndex = p(i);
        if (revenue[i] + _opt(pIndex) > _opt(i - 1)) {
            System.out.println(sites[i]);
            printOptimalSites(pIndex);
            return;
        }

        printOptimalSites(i - 1);
    }

    private int _opt(int i) {
        if (i == -1) return 0;
        if (optValues[i] != 0) return optValues[i];

        int revenueExcluded = _opt(i - 1);
        int revenueIncluded = revenue[i] + _opt(p(i));
        optValues[i] = Math.max(revenueExcluded, revenueIncluded);
        return optValues[i];
    }

    private int p(int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (sites[i] - sites[j] > this.minDistance) return j;
        }
        return -1;
    }
}
