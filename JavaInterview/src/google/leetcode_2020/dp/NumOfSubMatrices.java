package google.leetcode_2020.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumOfSubMatrices {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 0}
        };


        int ans = numSubmatrixSumTarget(matrix, 0);
        System.out.println(ans);
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {

        // column size
        int[] sumArray = new int[matrix.length];

        int totalSubMatrices = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++) {
            Arrays.fill(sumArray, 0);
            for (int j = i; j < matrix[0].length; j++) {

                // prefix sum
                for (int k = 0; k < sumArray.length; k++) {
                    sumArray[k] += matrix[k][j];
                }

                int sum = 0;
                preSum.clear();
                preSum.put(0, 1);
                for (int k = 0; k < sumArray.length; k++) {
                    sum += sumArray[k];
                    if (preSum.containsKey(sum - target)) {
                        totalSubMatrices += preSum.get(sum - target);
                    }
                    // add count
                    preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return totalSubMatrices;
    }
}
