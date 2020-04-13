package facebook.leetcode_2020.dp;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        boolean ans = new WordBreak().wordBreakDP(s, wordDict);
        System.out.println(ans);
    }

    // BFS
    // Time:  O(n^2)
    // Space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[s.length()];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            // if not visited
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dictionary.contains(s.substring(start, end))) {
                        if (end == s.length()) {
                            return true;
                        }
                        queue.offer(end);
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    // DP
    // Time:  O(n^2)
    // Space: O(n)
    public boolean wordBreakDP(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && dictionary.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
