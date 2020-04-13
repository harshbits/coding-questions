package facebook.leetcode_2020.dp;

public class LongestIncreasingSubSequence {


    // Using BInary Search and DP
    // O(N) Space, O( N log N) Time
    public int longestIncreasingSubseqBS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int length = 0;

        for (int n : nums) {
            int low = 0;
            int high = length;

            while (low < high) {
                int mid = (low + high) / 2;
                if (dp[mid] <= n) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            dp[low] = n;
            if (low == length) {
                length++;
            }
        }
        return length;
    }
}
