package facebook.leetcode_2020.string;

public class LongestSubStringWithKMost {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("abcc", 2));
    }

    // Time: O(n)
    // Space: O(256) = O(1)
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // it could be 26, 128 or 256 too, based on extended ascii
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;

        for (int j = 0; j < s.length(); j++) {
            // if count[s.charAt(j)] == 0, we know that it is a distinct character
            if (count[s.charAt(j)]++ == 0) {
                num++;
            }

            // sliding window
            while (num > k && i < s.length()) {
                if (--count[s.charAt(i++)] == 0) {
                    num--;
                }
            }
            // window
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
