package com.library.dynamicprogramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WeightedIntervalScheduleTest {
    WeightedIntervalSchedule.JOB j1, j2, j3, j4, j5;

    @Before
    public void setUp() throws Exception {
        j1 = new WeightedIntervalSchedule.JOB(0,2,2);
        j2 = new WeightedIntervalSchedule.JOB(1,3,3);
        j3 = new WeightedIntervalSchedule.JOB(3,4,2);
        j4 = new WeightedIntervalSchedule.JOB(4,6,2);
        j5 = new WeightedIntervalSchedule.JOB(2,6,7);
    }

    @Test
    public void testWeightedInterval(){
        WeightedIntervalSchedule wis = new WeightedIntervalSchedule();
        wis.addJob(j2);
        wis.addJob(j4);
        wis.addJob(j3);
        wis.addJob(j1);
        wis.addJob(j5);

        Assert.assertEquals(9, wis.getOpt());
    }
}