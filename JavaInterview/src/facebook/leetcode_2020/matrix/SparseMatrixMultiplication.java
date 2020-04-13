package facebook.leetcode_2020.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparseMatrixMultiplication {

    public static void main(String[] args) {

        int[][] A = {
                {1, 0, 0},
                {-1, 0, 3}
        };

        int[][] B = {
                {7, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int[][] sparse = new SparseMatrixMultiplication().multiply(A, B);
        System.out.println(Arrays.deepToString(sparse));

    }

    // Time: O(m * nA * nB) (worst, for non zero matrix)
    // Space: O(rB * rC)
    // As per CMU lecture
    public int[][] multiplyCMU(int[][] A, int[][] B) {
        int m = A.length;
        int nA = A[0].length;
        int nB = B[0].length;

        int[][] ans = new int[m][nB];

        List<List<Integer>> list = new ArrayList<>();

        // A's colums are same as B's row
        // add non zero values to row
        for (int i = 0; i < nA; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < nB; j++) {
                if (B[i][j] != 0) {
                    row.add(j);
                }
            }
            list.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nA; j++) {
                if (A[i][j] != 0) {
                    for (int k : list.get(j)) {
                        ans[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return ans;
    }


    // Brute Force:
    // Time: O(m * nA * nB)
    // Space: O(1)
    // we may assume that number of A's columns are similar to B's row
    public int[][] multiply(int[][] A, int[][] B) {

        int m = A.length;
        int nA = A[0].length;
        int nB = B[0].length;

        int[][] ans = new int[m][nB];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nB; j++) {
                for (int k = 0; k < nA; k++) {
                    ans[i][j] += A[i][k] * B[k][j];
                }

            }
        }

        return ans;
    }

}
