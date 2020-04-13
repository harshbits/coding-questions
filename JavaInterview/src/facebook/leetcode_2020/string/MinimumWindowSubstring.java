package facebook.leetcode_2020.string;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
//        String ans = new MinimumWindowSubstring().minWindow("azjskfzts", "sz");
        String ans = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }


    // Time: O(n)
    // Space: O(26) = O(1)
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int minStart = 0;
        int start = 0, end = 0;
        int totalT = t.length();
        int min = Integer.MAX_VALUE;
        while (end < s.length()) {
            if (charCount[s.charAt(end)]-- > 0) {
                totalT--;
            }
            end++;
            // Move the start pointer when total  = 0.
            while (totalT == 0) {
                if (end - start < min) {
                    min = end - start;
                    minStart = start;
                }
//                System.out.println(start);
                if (++charCount[s.charAt(start)] > 0) {
                    totalT++;
                }
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);

    }
}
