package facebook.leetcode_2020.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

    }

    // Greedy Approach
    // O(n) time
    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> intervalList = new LinkedList<>();

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        int i = 0, n = intervals.length;

        // Add all intervals before newStart
        while (i < n && intervals[i][1] < newStart) {
            intervalList.add(intervals[i++]);
        }

        // merge all overlapping intervals
        while (i < n && intervals[i][0] <= newEnd) {
            newStart = Math.min(intervals[i][0], newStart);
            newEnd = Math.max(intervals[i][1], newEnd);
            i++;
        }
        intervalList.add(new int[]{newStart, newEnd});

        // add remaining intervals
        while (i < n) {
            intervalList.add(intervals[i++]);
        }

        return intervalList.toArray(new int[intervalList.size()][2]);
    }
}
