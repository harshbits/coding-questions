package google.leetcode_2020.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber {

    public static void main(String[] args) {
//        boolean ans = new StrobogrammaticNumber().isStrobogrammatic("6");
//        System.out.println(ans);
//
//        List<String> ans1 = new StrobogrammaticNumber().findStrobogrammatic(2);
//        System.out.println(ans1);

        int ans2 = new StrobogrammaticNumber().strobogrammaticInRange("50", "100");
        System.out.println(ans2);

        ans2 = new StrobogrammaticNumber().strobogrammaticInRangeOptimized("50", "100");
        System.out.println(ans2);
    }

    /// 1.
    int[] mapping = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

    public boolean isStrobogrammatic(String num) {
        if (num == null || num.isEmpty()) {
            return true;
        }

        char[] nc = num.toCharArray();
        int l = 0, r = nc.length - 1;
        while (l <= r) {
//            System.out.println(nc[l] - '1');
//            System.out.println(nc[r] - '1');
            if (mapping[nc[l] - '0'] == -1 || mapping[nc[r] - '0'] == -1
                    || mapping[nc[l] - '0'] != nc[r] - '0') {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    /// 2.
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        // if not 1.
        if ((n & 1) == 0) {
            ans.add("");
        } else {
            ans.add("0");
            ans.add("1");
            ans.add("8");
        }

        if (n < 2) {
            return ans;
        }
        // move 2 times
        List<String> current;
        for (; n > 1; n -= 2) {
            current = ans;
            ans = new ArrayList<>();
            for (String i : current) {
                if (n > 3) {
                    ans.add('0' + i + '0');
                }
                ans.add('1' + i + '1');
                ans.add('8' + i + '8');
                ans.add('6' + i + '9');
                ans.add('9' + i + '6');
            }
        }
        return ans;
    }


    /// 3.
    private static final char[][] PAIRS = new char[][]{
            {'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    char[] SINGLES = new char[]{'0', '1', '8'};

    public int strobogrammaticInRange(String low, String high) {
        // basic conditions
        if (low == null || high == null || low.length() > high.length()
                || (low.length() == high.length() && low.compareTo(high) > 0)) {
            return 0;
        }
        int count = 0;
        for (int len = low.length(); len <= high.length(); len++) {
            count += dfs(low, high, new char[len], 0, len - 1);
        }

        return count;
    }

    private int dfs(String low, String high, char[] ch, int left, int right) {
        // Basic
        // termination condition
        if (left > right) {
            String s = new String(ch);
            if ((ch.length == low.length() && s.compareTo(low) < 0)
                    || (ch.length == high.length() && s.compareTo(high) > 0)) {
                return 0;
            } else {
                return 1;
            }
        }

        int count = 0;
        for (char[] p : PAIRS) {
            ch[left] = p[0];
            ch[right] = p[1];

            //don't start with 0
            if (ch.length != 1 && ch[0] == '0') {
                continue;
            }

            //don't put 6/9 at the middle of string.
            if (left == right && (p[0] == '6' || p[0] == '9')) {
                continue;
            }
            count += dfs(low, high, ch, left + 1, right - 1);
        }
        return count;
    }


    // 3. Optimized

    int optimizedCount = 0;

    public int strobogrammaticInRangeOptimized(String low, String high) {
        // length
        int lowLen = low.length();
        int highLen = high.length();

        // convert to char array
        char[] lc = low.toCharArray();
        char[] hc = high.toCharArray();

        int count = 0;
        for (int len = lowLen; len <= highLen; len++) {
            // generating the numbers only when the length is equal to low or high
            if (len == lowLen || len == highLen) {
                char[] buffer = new char[len];
//                count += dfsHelper(len, 0, len - 1, lc, hc, 0, buffer);
                dfsHelper(len, 0, len - 1, lc, hc, 0, buffer);
            } else {
                // count numbers for given size
                // for ex: if low = 1 and high = 9999
                // we will calculate between 10 and 999 using math.
                optimizedCount += getStrobogrammaticCount(len, len);
            }
        }
        return optimizedCount;
//        return count;
    }


    // Recursion for generating Strobogrammatic numbers of length n
    // starting from both ends. As a result, the numbers are
    // generate in ascending order.

    //        private int dfsHelper(int len, int start, int end, char[] lc, char[] hc, int bufLen, char[] buffer) {
    private boolean dfsHelper(int len, int start, int end, char[] lc, char[] hc, int bufLen, char[] buffer) {

        if (len == 0) {
//            return 0;
            return false;
        }
        int count = 0;
        // when buffer running length is equal to len.
        if (bufLen == len) {
            // compare hc and lc with buffer.
            int compareHigh = compare(buffer, hc);
            if (compare(lc, buffer) >= 0 && compareHigh >= 0) {
//                optimizedCount++;
                optimizedCount++;
//                return 1;
            } else if (compare(buffer, hc) < 0) {
                // the number is greater than high
                // break the calculation.
//                return 0;
                return false;
            }
            return true;
//            return count;
        }
        // when both pointers are same, means they are in the middle
        // apply only single digit
        else if (start == end) {
            for (int i = 0; i < SINGLES.length; i++) {
                // if first digit is not 0.
                if (!(start == 0 && i == 0 && len > 1)) {
                    buffer[start] = SINGLES[i];
//                    int c = dfsHelper(len, start + 1, end - 1, lc, hc, bufLen + 1, buffer);
//                    if (c == 0) {
//                        return 0;
//                    }
//                    count += c;
                    if (!dfsHelper(len, start + 1, end - 1, lc, hc, bufLen + 1, buffer)) {
                        return false;
                    }
                }
            }
        }
        // Digits are towards the left and right end
        else {
            for (int i = 0; i < PAIRS.length; i++) {
                if (!(start == 0 && i == 0)) {
                    buffer[start] = PAIRS[i][0];
                    buffer[end] = PAIRS[i][1];
//                    int c = dfsHelper(len, start + 1, end - 1, lc, hc, bufLen + 2, buffer);
//                    if (c == 0) {
//                        return 0;
//                    }
//                    count += c;
                    if (!dfsHelper(len, start + 1, end - 1, lc, hc, bufLen + 2, buffer)) {
                        return false;
                    }
                }
            }
        }
//        return count;
        return true;
    }

    // Compare two numbers' char array. Longer one is the larger one.
    // If have same length then compare each char from left to right
    // return positive when s2 > s1, 0 when s2==s1, negative when s2 < s1
    int compare(char[] s1, char[] s2) {
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

    // counting the total Strobogrammatic numbers of length n
    // without considering the range
    private int getStrobogrammaticCount(int n, int next) {
        if (next <= 0) return 0;
        if (next == 1) return 3;
        // first digit can't be 0
        if (next == 2) return n == next ? 4 : 5;
        return n == next ? 4 * getStrobogrammaticCount(n, next - 2) : 5 * getStrobogrammaticCount(n, next - 2);
    }
}
