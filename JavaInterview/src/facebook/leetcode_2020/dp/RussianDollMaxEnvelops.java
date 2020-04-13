package facebook.leetcode_2020.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollMaxEnvelops {

    // Time: O(n log n) + O(log n)
    public int maxEnvelopes(int[][] envelopes) {
        // base check
        if (envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }

        // Step 1. Sort the array.
        // Ascend on width and descend on height if width are same.
        // Time: O(n log n)
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });

        int dp[] = new int[envelopes.length];
        int len = 0;

        // Time: O(n * log n)
        // Step 2: Find the longest increasing subsequence based on height.
        for (int[] envelope : envelopes) {
            // in built
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);

            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
