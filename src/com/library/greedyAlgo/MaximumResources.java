package com.library.greedyAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumResources {

    public static int getMaxResources(JOB[] jobs) {
        Queue<JOB> jobQueue = new LinkedList<>();
        int maxQueueSize = 0;
        for (int i = 0 ; i < jobs.length ; i++) {
            JOB head = jobQueue.peek();
            if (head != null && !head.overlap(jobs[i])) {
                jobQueue.remove();
            }
            jobQueue.add(jobs[i]);
            if (maxQueueSize < jobQueue.size()) {
                maxQueueSize = jobQueue.size();
            }
        }
        return maxQueueSize;
    }

    public static class JOB {
        int start;
        int finish;
        public JOB(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public boolean overlap(JOB job) {
            return (job.finish < this.finish && this.start < job.finish)
                    || (this.finish < job.finish && job.start < this.finish);
        }
    }
}
