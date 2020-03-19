package google.leetcode_2020.string;

import java.util.*;

public class LongestStringChain {


    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int ans = new LongestStringChain().longestStrChain1(words);
        System.out.println(ans);
    }


    // Using DP
    public int longestStrChain(String[] words) {
        if (words.length < 2) {
            return words.length;
        }

        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestChain = 0;
        for (String word : words) {
            System.out.println(word);
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                System.out.println(prev);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            longestChain = Math.max(best, longestChain);
            System.out.println(longestChain);
            System.out.println(dp);
            System.out.println("----------------------\n");
        }
        return longestChain;
    }

    //
    //1 <= words.length <= 1000
    //1 <= words[i].length <= 16
    //words[i] only consists of English lowercase letters.
    public int longestStrChain1(String[] words) {

        if (words.length < 2) {
            return words.length;
        }

        int maxLen = 0;
        // Size Given in question
        List<String>[] map = new List[17];

//        List<String>[] map = new List[17];

//        String[][] dp = new String[17][2];
        HashMap<DepthCall, Integer> dp = new HashMap<>();
        // O(17)
        for (int i = 0; i < 17; i++) {
            map[i] = new ArrayList<>();
        }

        // O(N); N = num of words
        for (String word : words) {
            int len = word.length();
            map[len].add(word);
            maxLen = Math.max(len, maxLen);
        }

//        System.out.println(Arrays.toString(map));

        int longestChain = 0;
        // Start in reverse
        for (int j = maxLen; j > 1 && j > longestChain; j--) {
            longestChain = Math.max(longestChain, calculateMaxDepth(map, dp, j, null));
        }
        return longestChain;
    }

    private int calculateMaxDepth(List<String>[] map, Map<DepthCall, Integer> dp, int len, String prev) {
        if (dp.containsKey(new DepthCall(len, prev))) {
            return dp.get(new DepthCall(len, prev));
        }

        System.out.println("map, " + len + ", " + prev);
        List<String> words = map[len];
        if (words.size() == 0) {
            return 0;
        }
        int max = 0;
        for (String s : words) {
            if (isPredecessor(s, prev)) {
                int depth = calculateMaxDepth(map, dp, len - 1, s);
                max = Math.max(max, depth + 1);
            }
        }
        dp.put(new DepthCall(len, prev), max);
        return max;
    }

    private boolean isPredecessor(String word, String prev) {
        if (prev == null) return true;
        int i = 0, j = 0;

        while (i < prev.length() && j < word.length()) {
            if (prev.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                if (i - j > 1) return false;
            }
        }
        return i - j <= 1;
    }


    class DepthCall {
        int i;
        String s;

        public DepthCall(int i, String s) {
            this.i = i;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DepthCall)) return false;
            DepthCall depthCall = (DepthCall) o;
            return i == depthCall.i &&
                    Objects.equals(s, depthCall.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, s);
        }
    }
}
