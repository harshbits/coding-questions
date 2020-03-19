package google.leetcode_2020.backtracking;

import java.util.Arrays;

public class StrobogrammaticNumberIII {


    public static void main(String[] args) {
        int ans = new StrobogrammaticNumberIII().strobogrammaticInRange("0", "1680");
        System.out.println(ans);
    }


    char[] singles = new char[]{'0', '1', '8'};
    // Sorted by the first char in ascending order
    char[][] pairs = new char[][]{{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    char[] ans; // buffer of storing the number
    int count = 0; // total count
    char[] l; // char array of low
    char[] h; // char array of high

    // Compare two numbers' char array. Longer one is the larger one.
    // If have same length then compare each char from left to right
    // return positive when s2 > s1, 0 when s2==s1, nagetive when s2 < s1
    int comp1(char[] s1, char[] s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 != len2) {
            return len2 - len1;
        } else {
            for (int i = 0; i < len1; i++) {
                if (s1[i] != s2[i]) {
                    return s2[i] - s1[i];
                }
            }
            return 0;
        }
    }


    int comp(char[] s1, char[] s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        if (len1 != len2) {
            return len2 - len1;
        } else {
            int l = 0;
            int r = len1 - 1;
            // bi - directional
            while (l <= r) {
                if (s1[l] != s2[l]) {
                    return s2[l] - s1[l];
                }
                if (s1[r] != s2[r]) {
                    return s2[r] - s1[r];
                }
                l++;
                r--;
            }
            return 0;
        }
    }


    // Recursion for generating Strobogrammatic numbers of length n
    // starting from both ends. As a result, the numbers are
    // generate in ascending order.
    // Therefore, when when a number is greater than high it returns false
    // and then terminate the loop.
    boolean helper(int n, int s, int e, int len) {

        if (n == 0) return false;
        if (len == n) { // a resulting number
            // checking the range

            int c1 = comp(l, ans);
            int c2 = comp(ans, h);

            int c11 = comp1(l, ans);
            int c21 = comp1(ans, h);

//            System.out.println(c1 + "    " + c11);
//            System.out.println(c2 + "    " + c21);


            if (comp(l, ans) >= 0 && comp(ans, h) >= 0) count++;
            if (comp(ans, h) < 0) return false; // the nubmer is greater than high
            return true;
        } else if (s == e) { // odd length at the middle position, apply single digit
            for (int i = 0; i < singles.length; i++) {
                if (!(s == 0 && i == 0 && n > 1)) { // first digit can't be 0
                    ans[s] = singles[i];
                    if (!helper(n, s + 1, e - 1, len + 1)) return false;
                }
            }
        } else { // placing two digits at both ends
            for (int i = 0; i < pairs.length; i++) {
                char[] pair = pairs[i];
                if (!(s == 0 && i == 0)) { // first digit can't be 0
                    ans[s] = pair[0];
                    ans[e] = pair[1];
                    if (!helper(n, s + 1, e - 1, len + 2)) return false;
                }
            }
        }
        return true;
    }

    // counting the total Strobogrammatic numbers of lengh n
    // without considering the range
    int counts(int n, int next) {
        if (next <= 0) return 0;
        if (next == 1) return 3;
        if (next == 2) return n == next ? 4 : 5; // first digit can't be 0
        return n == next ? 4 * counts(n, next - 2) : 5 * counts(n, next - 2);
    }

    public int strobogrammaticInRange(String low, String high) {
        int low_len = low.length();
        int high_len = high.length();
        l = low.toCharArray();
        h = high.toCharArray();
        for (int i = low_len; i <= high_len; i++) {
            // generating the numbers only when the length is equal to low or high
            if (i == low_len || i == high_len) {
                ans = new char[i];
                helper(i, 0, i - 1, 0);
            } else {
                // counting the total numbers without acctualy generating them
                count += counts(i, i);
            }
        }
        return count;
    }
}
