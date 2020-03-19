package google.leetcode_2020.onsite;

import java.util.Arrays;
import java.util.SortedSet;

public class WaterTaps {

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 0, 1};


        int ans = minimumNumOfTapsToOpen(arr);
        System.out.println(ans);
        ans = minimumNumOfTapsToOpen2(arr);
        System.out.println(ans);


    }

    public static int minimumNumOfTapsToOpen(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        int[] taps = new int[n];
        for (int i = 0; i < n; i++) {
            int l = Math.max(1, i - arr[i]);
            int r = Math.min(n, i + arr[i]);
            taps[l] = Math.max(taps[l], r - l);
        }
        System.out.println(Arrays.toString(taps));

        int maxPos = taps[0];
        int maxSteps = taps[0];

        int total = 1;
        for (int i = 1; i < n; ++i) {
            if (maxSteps < 1) {
                maxSteps = maxPos;
                total++;
            }
            maxPos = Math.max(maxPos, taps[i] + i);
        }
        return total;
    }

    public static int minimumNumOfTapsToOpen2(int[] arr) {
        int n = arr.length;
        if (n < 2) {
            return 0;
        }
        int[][] taps = new int[n][2];
        for (int i = 0; i < n; i++) {
//            int l = Math.max(0, i - arr[i]);
//            int r = Math.min(n - 1, i + arr[i]);
            int l = i - arr[i];
            int r = i + arr[i];
            taps[i] = new int[]{l, r};
        }
        System.out.println(Arrays.deepToString(taps));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int i = 1; i <= n && dp[i - 1] < n; i++) {
            for (int[] tap : taps) {
                if (i >= tap[0] && i <= tap[1]) {
                    dp[i] = Math.min(dp[i], dp[tap[0]] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n] == n + 1 ? -1 : dp[n];
    }
}
