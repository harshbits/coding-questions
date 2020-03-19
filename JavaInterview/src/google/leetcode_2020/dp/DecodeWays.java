package google.leetcode_2020.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {


    public static void main(String[] args) {
        int ans = new DecodeWays().numDecodings1("226");
        System.out.println(ans);
    }


    // Using DP
    // Iterative Approach
    // Constant SPace.
    public int numDecodings1(String s) {
        // if first element is zero
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        // dp[i - 2]
        int dp1 = 1;
        // dp[i - 1]
        int dp2 = 1;

        for (int i = 1; i < s.length(); i++) {

            //1.for single digit
            // check if it's non zero
            if (s.charAt(i - 1) != '0') {
                dp2 += dp2;
            }

            int p1 = dp1;
            int p2 = dp2;
            //2 for double digit
            int two1 = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            int two = Integer.valueOf(s.substring(i - 1, i + 1));

            System.out.println("t1-> "+two);
            System.out.println("t2-> "+two1);


            if (two < 1 || two > 26) {
                p1 = 0;
            }
            if (two % 10 == 0) {
                p2 = 0;
            }
            dp1 = p2;
            dp2 = p1 + p2;
        }
        return dp2;
    }

    // private char[] dict ={'a', 'b',}
    public int numDecodings(String s) {

        // if first element is zero
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // Memoization with DFS
        return dfsHelper(0, s, new HashMap<>());
    }


    private int dfsHelper(int i, String s, Map<Integer, Integer> memo) {

        System.out.println(i + "i");
        // Termination
        // at the end of the string then return 1
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (i == s.length() - 1) {
            return 1;
        }

        if (memo.containsKey(i)) {
            return memo.get(i);
        }


        int ans = dfsHelper(i + 1, s, memo);
        // check if 2 digits are within the range
//        System.out.println(s.substring(i, i + 2));
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            // skip 2 steps
            ans += dfsHelper(i + 2, s, memo);
        }

        memo.put(i, ans);
        return ans;
    }
}
