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
        this.optValues = new int[ny.length][2];
    }

    public int getMovingCost() {
        for (int month = 0; month < ny.length; month++) {
            optValues[month][0] = _opt(month, LOC.NY);
            optValues[month][1] = _opt(month, LOC.SF);
        }
        printOptimalLocation();
        return Math.min(optValues[ny.length - 1][0], optValues[sf.length - 1][1]);
    }

    private void printOptimalLocation() {
        for (int month = 0; month < ny.length; month++) {
            System.out.println((optValues[month][0] < optValues[month][1]) ? "NY " : "SF ");
        }
    }

    private int _opt(int month, LOC currentLoc) {
        if (month == 0) return locationCost(month, currentLoc);
        int locIndex = (currentLoc == LOC.NY)? 0 : 1;
        if (optValues[month][locIndex] != 0) {
            return optValues[month][locIndex];
        }
            return Math.min(_opt(month - 1, currentLoc) + locationCost(month, currentLoc),
            _opt(month - 1, otherLocation(currentLoc)) + locationCost(month, currentLoc) + movingCost);

    }

    private LOC otherLocation(LOC currentLoc) {
        return currentLoc == LOC.NY ? LOC.SF : LOC.NY;
    }

    private int locationCost(int month, LOC currentLoc) {
        return currentLoc == LOC.NY ? ny[month] : sf[month];
    }
}
