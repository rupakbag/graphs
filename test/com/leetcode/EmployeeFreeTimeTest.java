package com.leetcode;

import com.leetcode.EmployeeFreeTime.Interval;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTimeTest {
    @Test
    public void test1(){
        List<List<Interval>> intervals = new ArrayList<>();
        List<Interval> emp1 = new ArrayList<>();
        List<Interval> emp2 = new ArrayList<>();
        List<Interval> emp3 = new ArrayList<>();
        emp1.add(new Interval(1,2));
        emp1.add(new Interval(5,6));
        emp2.add(new Interval(1,3));
        emp3.add(new Interval(4,10));
        emp3.add(new Interval(11,12));
        intervals.add(emp1);
        intervals.add(emp2);
        intervals.add(emp3);
        Assert.assertEquals("[{3, 4}, {10, 11}]", EmployeeFreeTime.employeeFreeTime(intervals).toString());
    }
    @Test
    public void test2(){
        List<List<Interval>> intervals = new ArrayList<>();
        List<Interval> emp1 = new ArrayList<>();
        List<Interval> emp2 = new ArrayList<>();
        List<Interval> emp3 = new ArrayList<>();
        emp1.add(new Interval(1,3));
        emp1.add(new Interval(6,7));
        emp2.add(new Interval(2,4));
        emp3.add(new Interval(2,5));
        emp3.add(new Interval(9,12));
        intervals.add(emp1);
        intervals.add(emp2);
        intervals.add(emp3);
        Assert.assertEquals("[{5, 6}, {7, 9}]", EmployeeFreeTime.employeeFreeTime(intervals).toString());
    }
}