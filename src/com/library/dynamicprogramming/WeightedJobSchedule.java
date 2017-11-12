package com.library.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*  We have n jobs labelled 1...n, with each job specifying start time, finish time and value/weight
*  Goal is to find a subset of mutually exclusive jobs that maximises the sum of the values of the selected jobs
*  O(n) algorithm using Memoization
*/

public class WeightedJobSchedule {
    private static final int UNKNOWN = 0;
    private List<JOB> jobList = new ArrayList<>();
    private int[] optValues;

    public boolean addJob(JOB j) {
        if (JOB.valid(j)) {
            return jobList.add(j);
        }
        return false;
    }

    public int getOpt() {
        Collections.sort(jobList);
        optValues = new int[jobList.size()];
        Arrays.fill(optValues, UNKNOWN);
        int ret = _opt(jobList.size() - 1);
        printOptimalJob(jobList.size() - 1);
        return ret;
    }

    private int _opt(int j) {
        if (j == -1) return 0;
        if (optValues[j] == UNKNOWN) {
            optValues[j] = Math.max(jobList.get(j).w  + _opt(p(j)), _opt(j - 1));
        }
        return optValues[j];
    }

    private int p(int j) {
        int start = jobList.get(j).s;
        for (int i = j - 1; i >= 0; i--) {
            if (jobList.get(i).f <= start) return i;
        }
        return -1;
    }

    private void printOptimalJob(int j) {
        if (j == -1) return;

        if (jobList.get(j).w + getOptValue(p(j)) >= getOptValue(j - 1)) {
            System.out.println(jobList.get(j));
            printOptimalJob(p(j));
        }
        else {
            printOptimalJob(j - 1);
        }
    }

    private int getOptValue(int j) {
        return (j == -1)? 0 : optValues[j];
    }

    public static class JOB implements Comparable<JOB>{
        private final int s; // start time
        private final int f; // end time
        private final int w; // weight

        public JOB(int s, int f, int w) {
            this.s = s;
            this.f = f;
            this.w = w;
        }

        public static boolean valid(JOB j) {
            return (j != null) && (j.s < j.f) && (j.w > 0);
        }

        /*
        *   JOBs are sorted based on finishing times
        *   -1 of this job finishes earlier than the given job
        *   0  if both finishes at the same time
        *   +1 if the given job finishes later than this job
        */
        @Override
        public int compareTo(JOB o) {
            if (f == o.f) return 0;
            if (f < o.f) return -1;
            else return 1;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("JOB{");
            sb.append("s=").append(s);
            sb.append(", f=").append(f);
            sb.append(", w=").append(w);
            sb.append('}');
            return sb.toString();
        }
    }
}
