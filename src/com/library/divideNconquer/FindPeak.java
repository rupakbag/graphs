package com.library.divideNconquer;

/*
* Given a unimodal sequence of values (A[1], A[2]...A[p]...A[n]) For some position p, value increases till p and then decreases until n
* Find the peak entry (p)
 */
public class FindPeak {

    private final int[] input;

    public FindPeak(int[] input) {
        this.input = input;
    }

    public int findPeakIndex() {
        return _findPeak(0, input.length - 1);
    }

    private int _findPeak(int i, int j) {
        if (i==j) return -1;
        int mid = i + ((j - i) / 2);

        if (input[mid - 1] < input[mid] && input[mid] < input[mid + 1]) {
            return _findPeak(mid, j); //Including mid since we may need mid if mid + 1 is the peak
        } else if (input[mid - 1] > input[mid] && input[mid] > input[mid + 1]) {
            return _findPeak(i, mid);
        } else if (input[mid - 1] < input[mid] && input[mid] > input[mid + 1]) {
            return mid;
        }
        return -1;
    }
}
