package facebook.leetcode_2020.matrix;

import java.util.Arrays;
import java.util.HashMap;

public class CountSquares {

    public static void main(String[] args) {

    }

    // Time: O(nLogn) + O(mLogm) + O(m + n)
    // Space: O(m + n)
    public int countSquares(int[] verticalLines, int[] horizontalLines, Point startP, Point endP) {
        // Step 1. sort vertical O(nLogn) and horizontal borders O(mLogm)
        // Bottleneck is to sort lines
        Arrays.sort(verticalLines);
        Arrays.sort(horizontalLines);

        HashMap<Integer, Integer> horizontalSegmentCount = new HashMap<>();

        int topBound = startP.x;
        // Step 2. form all possible line segments lengths from neighbouring vertical borders O(n) and then horizontal borders O(m)
        // Step 3. se hashmap to see the number of horizontal segments that would be equivalent to vertical segments O(m+n)... add to count
        for (int i = 0; i < horizontalLines.length; i++) {

            if (startP.x < horizontalLines[i] && horizontalLines[i] < endP.x && topBound != horizontalLines[i]) {

                int len = horizontalLines[i] - topBound;
                horizontalSegmentCount.put(len, horizontalSegmentCount.getOrDefault(len, 0) + 1);
                topBound = horizontalLines[i];
            }
        }
        if (horizontalLines.length > 0 && topBound != endP.x) {
            horizontalSegmentCount.put(endP.x - topBound, horizontalSegmentCount.getOrDefault(endP.x - topBound, 0) + 1);
        }

        int leftBound = startP.y;
        int squareCount = 0;
        for (int j = 0; j < verticalLines.length; j++) {
            if (startP.y < verticalLines[j] && verticalLines[j] <= endP.y && topBound != verticalLines[j]) {
                int len = verticalLines[j] - leftBound;
                squareCount += horizontalSegmentCount.containsKey(len) ? horizontalSegmentCount.get(len) : 0;
                leftBound = verticalLines[j];
            }
        }
        if (verticalLines.length > 0 && topBound != endP.y) {
            squareCount += horizontalSegmentCount.containsKey(endP.y - topBound) ? horizontalSegmentCount.get(endP.y - topBound) : 0;
        }

        return squareCount;
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
