package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leetcode.EmployeeFreeTime.Event.TYPE.END;
import static com.leetcode.EmployeeFreeTime.Event.TYPE.START;

//O(nlogn) where n is the total number intervals across all employees
// https://leetcode.com/problems/employee-free-time/description/
// Code can be improved to O(nloge) where e is total number of employee and n is total number of intervals available
public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Event> list = new ArrayList<>();
        for (List<Interval> l : schedule) {
            for (Interval i : l) {
                list.add(new Event(i.start, START));
                list.add(new Event(i.end, END));
            }
        }
        Collections.sort(list, (o1, o2) -> o1.time - o2.time);
        List<Interval> out = new ArrayList<>();
        int count = 0, start = 0;
        for (Event e : list) {
            count += (e.type == Event.TYPE.START) ? 1 : - 1;
            if (count == 0) {
                start = e.time;
            }
            else if (count == 1 && start != 0) {
                out.add(new Interval(start, e.time));
                start = 0;
            }
        }
        return out;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder().append('{');
            sb.append(start).append(", ").append(end);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Event {
        enum TYPE { START, END }
        int time;
        TYPE type;
        Event(int time, TYPE type){
            this.time = time;
            this.type = type;
        }
    }
}
