package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("25525511135"));
    }

    // Time: O(3^3) = O(27) = O(1)
    // Space: O(3^3) = O(27) = O(1)
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        backtrack(s, list, new StringBuilder(), 0, 0);
        return list;
    }

    // DFS + Backtrack
    private void backtrack(String s, List<String> list, StringBuilder sb, int index, int level) {
        // out of bound check
        if (index > s.length() || level > 4) {
            return;
        }

        // found IP address
        if (index == s.length() && level == 4) {
            list.add(sb.toString());
            return;
        }

        // Maximum it could be only 3 digits only
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) {
                break;
            }

            int num = Integer.valueOf(s.substring(index, index + i));

            // check boundaries for IP between 1 and 255
            if ((i == 1 || i == 2 && num >= 10 && num <= 99)
                    || (i == 3 && num >= 100 && num <= 255)) {
                sb.append(num);
                // we dont need for 4th level
                if (level < 3) {
                    sb.append(".");
                }

                backtrack(s, list, sb, index + i, level + 1);

                // delete last character, i.e. "."
                if (level < 3) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                // delete currently visited
                // backtrack
                sb.delete(sb.length() - i, sb.length());
            }
        }
    }
}
