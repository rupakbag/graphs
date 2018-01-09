package com.library.greedyAlgo;

import java.util.LinkedList;
import java.util.Queue;

/*
* Algorithm assumes a sorted array of jobs is provided (sort based on finishing times)
* Algorithm outputs the minimum number of resources needed to execute all jobs.
* A queue is maintained to keep all overlapping jobs. Any new job to be added checks for its overlap with the
* first job in the queue (peek). If no overlap, the head is removed. The new job is then added and we maintain a
* variable that stores the maximum queue size seen so far. After all jobs are processed, max queue size seen is
* the number of resources needed. O(n)
 */

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
