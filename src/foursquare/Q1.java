package foursquare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*   First sort the given intervals based on their start times. O(nlogn) where n is number of intervals
*   Then loop through each interval once in sorted order. O(n)
*       For each interval we find if it overlaps with the previous interval. If so we find the end time of the merged interval which will be the
*           max of the end times of these two intervals.
*       If they don't overlap then we have found an interval that is not covered. We add it to the output
*   Total time Complexity: O(nlogn) + O(n) = O(nlogn) Higher order term dominates
*   Total space complexity: O(1) since we use constant amount of space
 */
public class Q1 {
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static List<Interval> uncoveredIntervals(List<Q1.Interval> intervals) {
        List<Interval> uncovered = new ArrayList<Q1.Interval>();
        Collections.sort(intervals, (i1, i2) -> i1.start < i2.start ? -1 : i1.start == i2.start ? 0 : 1);
        int endTime = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval ci = intervals.get(i);
            if (ci.start <= endTime) { //Overlap
                endTime = Math.max(endTime, ci.end);
            } else {
                uncovered.add(new Interval(endTime, ci.start));
                endTime = ci.end;
            }
        }
        return uncovered;
    }

    /*
     *  Hey! You probably don't need to edit anything below here
     */

    private static List<Q1.Interval> readIntervals(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<Q1.Interval> intervals = new ArrayList<Q1.Interval>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            intervals.add(toInterval(line));
        }
        return intervals;
    }

    private static Q1.Interval toInterval(String line) {
        final String[] tokenizedInterval = line.split(" ");

        return new Interval(Integer.valueOf(tokenizedInterval[0]),
                Integer.valueOf(tokenizedInterval[1]));
    }

    public static void main(String... args) throws IOException {
        List<Q1.Interval> intervals = Q1.readIntervals(System.in);
        List<Q1.Interval> uncovered = Q1.uncoveredIntervals(intervals);
        for (Interval i : uncovered) {
            System.out.println(i.start + " " + i.end);
        }
    }
}

