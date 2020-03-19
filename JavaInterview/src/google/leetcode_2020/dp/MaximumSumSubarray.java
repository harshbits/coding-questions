package google.leetcode_2020.dp;

import java.util.Arrays;

public class MaximumSumSubarray {

    public static void main(String[] args) {

        int[] arr = {-1, 3, -2, 5, -6, 1};

        int[][] matrix = {
                {-1, 1, 1},
                {1, 1, 1}
        };
//        System.out.println(kadane(arr));

        System.out.println(maxSumSubmatrix(matrix, 0));
    }


    public static int maxSumSubmatrix(int[][] matrix, int target) {

        // boundary point for the sub matrix.
        int left = 0, right = 0, up = 0, down = 0;

        int maxSumSubMatrix = Integer.MIN_VALUE;

        // temp array
        int[] sum = new int[matrix.length];
        // iterate over columns
        for (int i = 0; i < matrix[0].length; i++) {
            // temporary array to store 1 column at a time
            Arrays.fill(sum, 0);

            for (int j = i; j < matrix[0].length; j++) {

                for (int k = 0; k < matrix.length; k++) {
                    sum[k] += matrix[k][j];
                }

                int maxSum = Integer.MIN_VALUE;
                int currentSum = 0;
                int currentStart = 0;
                int start = -1;
                int end = -1;
                for (int k = 0; k < sum.length; k++) {
                    currentSum += sum[k];
                    if (currentSum < sum[k]) {
                        currentSum = 0;
                        currentStart = i + 1;
                    }
                    if (maxSum < currentSum) {
                        maxSum = currentSum;
                        start = currentStart;
                        end = i;
                    }
                }

                if (maxSumSubMatrix < maxSum) {
                    maxSumSubMatrix = maxSum;
                    up = start;
                    down = end;
                    left = i;
                    right = j;
                }
            }
        }

        return maxSumSubMatrix;
    }


    private static int kadane(int[] arr) {

        int currentSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(currentSum + arr[i], arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

}
