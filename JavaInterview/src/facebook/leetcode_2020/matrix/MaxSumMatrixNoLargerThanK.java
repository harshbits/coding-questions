package facebook.leetcode_2020.matrix;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxSumMatrixNoLargerThanK {

    public static void main(String[] args) {

    }

    public int maxSumSubmatrix(int[][] matrix, int target) {
        //boundary check
        if (matrix.length == 0) {
            return 0;
        }

        // answer
        int maxSumSubmatrix = Integer.MIN_VALUE;

        // size of rows
        int[] sums = new int[matrix.length];

        // TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
        TreeSet<Integer> treeSet = new TreeSet<>();

        // go column wise
        for (int i = 0; i < matrix[0].length; i++) {
            Arrays.fill(sums, 0);
            for (int j = i; j < matrix[0].length; j++) {
                // for given column
                for (int k = 0; k < sums.length; k++) {
                    sums[k] += matrix[k][j];
                }


                // Extra:
                // Added optimization
                // if we run kadane's algorithm and we hit the target we dont need to run ologn
                int max = Integer.MIN_VALUE;
                int maxSoFar = 0;
                // Kadane
                for (int k = 0; k < sums.length; k++) {
                    maxSoFar = Math.max(maxSoFar + sums[k], sums[k]);
                    max = Math.max(maxSoFar, max);
                    if (max == target) {
                        return target;
                    }
                }

                if (max < target) {
                    // just take the max rectangle sum.
                    maxSumSubmatrix = Math.max(maxSumSubmatrix, max);
                } else {
                    treeSet.clear();
                    //add 0 to cover the single row case
                    treeSet.add(0);
                    int currSum = 0;
                    for (int k = 0; k < sums.length; k++) {
                        currSum += sums[k];
                        Integer num = treeSet.ceiling(currSum - target);
                        if (num != null) {
                            maxSumSubmatrix = Math.max(maxSumSubmatrix, currSum - num);
                        }
                        treeSet.add(currSum);
                    }
                }
            }
        }
        return maxSumSubmatrix;
    }
}