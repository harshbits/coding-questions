package facebook.leetcode_2020.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {

    // Time: O(M + N)
    // Space: O(1)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intersections = new ArrayList();

        int i = 0, j = 0;

        while (i < A.length && j < B.length) {


            // Let's check if A[i] intersects B[j].
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);

            // this is intersection
            if (start <= end) {
                intersections.add(new int[]{start, end});
            }

            // Remove the interval with the smallest endpoint
            // which internval to take first
            // sliding window
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return intersections.toArray(new int[intersections.size()][]);
    }
}
