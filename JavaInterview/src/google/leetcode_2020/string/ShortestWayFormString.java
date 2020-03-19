package google.leetcode_2020.string;

import java.util.Arrays;

public class ShortestWayFormString {

    public static void main(String[] args) {

        int ans = new ShortestWayFormString().shortestWay("abc", "abcbc");
        System.out.println(ans);
    }

    public int shortestWay(String source, String target) {

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int m = source.length();
        int n = target.length();

        // Build inverted index for source
        // occurrence of alphabets for given source
        int[][] dict = new int[m][26];

        Arrays.fill(dict[m - 1], -1); // -1 represents no occurrence of the character
        dict[m - 1][s[m - 1] - 'a'] = m - 1;

        for (int x = m - 2; x >= 0; --x) {

            dict[x] = Arrays.copyOf(dict[x + 1], 26);
            dict[x][s[x] - 'a'] = x;
        }
//        System.out.println(Arrays.deepToString(dict));

        int ans = 0;
        int idx = 0;
        // Go through target and account for each character
        for (char c : t) {

            // If there are no occurrences of c
            if (dict[0][c - 'a'] == -1) return -1;

            if (dict[idx][c - 'a'] == -1) {
                ++ans;
                idx = 0;
            }

            idx = dict[idx][c - 'a'] + 1;

            if (idx == m) {
                ++ans;
                idx = 0;
            }
        }

        return ans;
    }
}
