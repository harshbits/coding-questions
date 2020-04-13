package facebook.leetcode_2020.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    public static void main(String[] args) {

    }

    // Time: O(n^3)
    // Space: O(N^3)
    public List<String> wordBreakDP(String s, Set<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }


    public List<String> wordBreakDFS(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // Time: O(2^N) (worst); best case O(N^2)
    // Space: O(2^N)
    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
