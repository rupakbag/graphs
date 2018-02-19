package com.library.misc;

//O(n) time complexity
//O(1) space complexity
public class FindKthSmallest {
    public static int find(int[] d, int k) {
        return _find(d,0,d.length-1,k);
    }

    private static int _find(int[] d, int i, int j, int k) {
        int pivot = d[i];
        int s = i + 1;
        int e = j;

        while (s <= e) {
            while (s <= e && pivot > d[s]) s++;
            while (s <= e && pivot < d[e]) e--;

            if (s <= e) {
                swap(d, s, e);
                s++;
                e--;
            }
        }
        swap(d, i, e);
        if (k == e) return pivot;
        else if (k > e) return _find(d, e + 1, j, k - e);
        else return _find(d, i, e - 1, k);
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
