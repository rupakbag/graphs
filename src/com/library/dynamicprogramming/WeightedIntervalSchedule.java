package com.library.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*  We have n jobs labelled 1...n, with each job specifying start time, finish time and value/weight
*  Goal is to find a subset of mutually exclusive jobs that maximises the sum of the values of the selected jobs
*/

public class WeightedIntervalSchedule {
    private List<JOB> jobList = new ArrayList<>(); // Consider using sortset
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
        Arrays.fill(optValues, 0);
        int ret = _opt(jobList.size() - 1);
        printOpt(jobList.size() - 1);
        return ret;
    }

    private int _opt(int j) {
        if (j == -1) return 0;
        if (optValues[j] != 0) return optValues[j];

        optValues[j] = Math.max(jobList.get(j).w  + _opt(p(j)), _opt(j - 1));
        return optValues[j];
    }

    private int p(int j) {
        int start = jobList.get(j).s;
        for (int i = j - 1; i >= 0; i--) {
            if (jobList.get(i).f <= start) return i;
        }
        return -1;
    }

    private void printOpt(int j) {
        if (j == -1) return;
        if (j == 0) {
            System.out.println(jobList.get(0));
            return;
        }

        int optDisjoint = p(j) >= 0 ? optValues[p(j)] : 0;
        if (jobList.get(j).w + optDisjoint >= optValues[j - 1]) {
            System.out.println(jobList.get(j));
            printOpt(p(j));
        }
        else {
            printOpt(j - 1);
        }
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

        /*
        *   Equivalence is based on start time, end time and weight
        *   Two jobs with same start and end time and weight cannot exist
        *   If this criteria doesn't hold, add an id generator to the JOB class
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JOB job = (JOB) o;

            if (s != job.s) return false;
            if (f != job.f) return false;
            return w == job.w;
        }

        @Override
        public int hashCode() {
            int result = s;
            result = 31 * result + f;
            result = 31 * result + w;
            return result;
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
