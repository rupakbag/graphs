package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeightedJobScheduleTest {
    WeightedJobSchedule.JOB j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11;
    WeightedJobSchedule wis;

    @Before
    public void setUp() throws Exception {
        wis = new WeightedJobSchedule();
        j1 = new WeightedJobSchedule.JOB(0,2,2);
        j2 = new WeightedJobSchedule.JOB(1,3,3);
        j3 = new WeightedJobSchedule.JOB(3,4,2);
        j4 = new WeightedJobSchedule.JOB(4,6,2);
        j5 = new WeightedJobSchedule.JOB(2,6,7);

        j6 = new WeightedJobSchedule.JOB(0,4,2);
        j7 = new WeightedJobSchedule.JOB(1,6,4);
        j8 = new WeightedJobSchedule.JOB(5,7,4);
        j9 = new WeightedJobSchedule.JOB(2,10,7);
        j10 = new WeightedJobSchedule.JOB(8,11,2);
        j11 = new WeightedJobSchedule.JOB(9,12,1);
    }

    @Test
    public void first_job_part_of_optimal_solution(){
        wis.addJob(j2);
        wis.addJob(j4);
        wis.addJob(j3);
        wis.addJob(j1);
        wis.addJob(j5);

        Assert.assertEquals(9, wis.getOpt());
    }
    @Test
    public void first_job_not_in_optimal_solution(){
        wis.addJob(j2);
        wis.addJob(j4);
        wis.addJob(j3);
        wis.addJob(j1);

        Assert.assertEquals(7, wis.getOpt());
    }
    @Test
    public void testOptimalSolution(){
        wis.addJob(j6);
        wis.addJob(j7);
        wis.addJob(j8);
        wis.addJob(j9);
        wis.addJob(j10);
        wis.addJob(j11);

        Assert.assertEquals(8, wis.getOpt());
    }
}