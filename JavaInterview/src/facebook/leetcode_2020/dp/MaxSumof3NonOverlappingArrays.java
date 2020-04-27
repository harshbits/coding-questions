package facebook.leetcode_2020.dp;

import java.util.Arrays;

public class MaxSumof3NonOverlappingArrays {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] ans = new MaxSumof3NonOverlappingArrays().maxSumOfThreeSubarrays(nums, 2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int maxSum = 0;
        int[] sum = new int[n + 1];
        // posLeft[i] is the starting index for the left interval in range [0, i];
        int[] posLeft = new int[n];
        // posRight[i] is the starting index for the right interval in range [i, n-1];
        int[] posRight = new int[n];
        int[] ans = new int[3];

        // sum of all indexs at given index
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k] - sum[0]; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                posLeft[i] = i + 1 - k;
                tot = sum[i + 1] - sum[i + 1 - k];
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n - k] = n - k;
        for (int i = n - k - 1, tot = sum[n] - sum[n - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i + k] - sum[i];
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        // test all possible middle interval
        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int tot = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (tot > maxSum) {
                maxSum = tot;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }

        return ans;
    }
}
