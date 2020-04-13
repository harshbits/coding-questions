package facebook.leetcode_2020.array;

import leetcode.uber.MergeIntervals56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            // Overlapping intervals, move the end if needed
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            // Disjoint intervals, add the new interval to the list
            else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;

    }

    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

    }
}