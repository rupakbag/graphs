package com.library.dynamicprogramming;

/*
* Page 315: Problem 4: Algorithm Design
 */
public class MovingOffice {
    private enum LOC {NY, SF;};

    private final int movingCost;
    private final int[] ny;
    private final int[] sf;
    private final LOC[] optLoc;
    private final int[][] optValues;

    public MovingOffice(int[] ny, int[] sf, int movingCost) {
        this.ny = ny;
        this.sf = sf;
        this.movingCost = movingCost;
        this.optLoc = new LOC[ny.length];
        this.optValues = new int[ny.length][4];
    }

    public int getMovingCost() {
        optValues[0][0] = ny[0];
        optValues[0][1] = ny[0];
        optValues[0][2] = sf[0];
        optValues[0][3] = sf[0];

        for (int month = 1; month < ny.length; month++) {
            _opt(month, LOC.NY);
            _opt(month, LOC.SF);
        }
//        int cost = _opt(ny.length - 1, null);
//        printOptimalLocation(ny.length - 1, null);
        return Math.min(optValues[ny.length - 1][0], optValues[sf.length - 1][1]);
    }

//    private void printOptimalLocation(int month, LOC nextLoc) {
//        if (month == 0) {
//            if (totalCost(0, LOC.NY, nextLoc) < totalCost(0, LOC.SF, nextLoc)) System.out.println("NY");
//            else System.out.println("SF");
//            return;
//        }
//
//        if (optValues[month - 1]) {
//            System.out.println("NY");
//            printOptimalLocation(month + 1, LOC.NY);
//            return;
//        }
//        System.out.println("SF");
//        printOptimalLocation(month + 1, LOC.SF);
//    }

    private int _opt(int month, LOC currentLoc) {
//        int locIndex = (currentLoc == LOC.NY)? 0 : 1;
//        if (optValues[month][locIndex] != 0) return optValues[month][locIndex];

        if (currentLoc == LOC.NY) {
            optValues[month][0] = _opt(month - 1, LOC.NY) + ny[month];
            optValues[month][1] = _opt(month - 1, LOC.SF) + ny[month] + movingCost;
        }
        else {
            optValues[month][2] = _opt(month - 1, LOC.SF) + sf[month];
            optValues[month][3] = _opt(month - 1, LOC.NY) + sf[month] + movingCost;
        }
        int minCost = Math.min(Math.min(optValues[month][0], optValues[month][1]), Math.min(optValues[month][2], optValues[month][3]));
        return minCost;
    }

    private LOC otherLocation(LOC currentLoc) {
        return currentLoc == LOC.NY ? LOC.SF : LOC.NY;
    }

    private int locationCost(int month, LOC currentLoc) {
        return currentLoc == LOC.NY ? ny[month] : sf[month];
    }
}
