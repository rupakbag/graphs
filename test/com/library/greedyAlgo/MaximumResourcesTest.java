package com.library.greedyAlgo;

import com.library.greedyAlgo.MaximumResources.JOB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumResourcesTest {
    JOB j1, j2, j3, j4, j5, j6, j7, j8;
    MaximumResources.JOB[] jobs;
    @Before
    public void setup(){
        j1 = new JOB(1,3);
        j2 = new JOB(2,6);
        j3 = new JOB(4,6);
        j4 = new JOB(5,7);
        j5 = new JOB(5,9);
        j6 = new JOB(9,11);
        j7 = new JOB(10,12);
        j8 = new JOB(10,13);
    }

    @Test
    public void overlap(){
        jobs = new MaximumResources.JOB[6];
        jobs[0] = j1;
        jobs[1] = j2;
        jobs[2] = j3;
        jobs[3] = j4;
        jobs[4] = j5;
        jobs[5] = j6;
        Assert.assertEquals(4, MaximumResources.getMaxResources(jobs));
    }

    @Test
    public void no_overlap(){
        jobs = new MaximumResources.JOB[3];
        jobs[0] = j1;
        jobs[1] = j3;
        jobs[2] = j6;
        Assert.assertEquals(1, MaximumResources.getMaxResources(jobs));
    }

    @Test
    public void multiple_finished_job_before_max_depth(){
        jobs = new MaximumResources.JOB[5];
        jobs[0] = j1;
        jobs[1] = j2;
        jobs[2] = j6;
        jobs[3] = j7;
        jobs[4] = j8;
        Assert.assertEquals(3, MaximumResources.getMaxResources(jobs));
    }
}