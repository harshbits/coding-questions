package facebook.leetcode_2020.array;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {
        int[] A = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(new SortedSquares().sortedSquares(A)));
    }

    // Time: O(n)
    // Space: O(1)
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] ans = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        int index = A.length - 1;

        // two pointer
        // start from the end
        while (start <= end) {
            if (A[start] * A[start] > A[end] * A[end]) {
                ans[index--] = A[start] * A[start];
                start++;
            } else {
                ans[index--] = A[end] * A[end];
                end--;
            }
        }
        return ans;
    }
}
