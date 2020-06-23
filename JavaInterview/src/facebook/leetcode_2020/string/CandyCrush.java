package facebook.leetcode_2020.string;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Input: "aabbccddeeedcba"
 * Output: ""
 * Explanation:
 * 1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
 * 2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
 * 3. Remove 3 'c': "aabbcccba" => "aabbba"
 * 4. Remove 3 'b': "aabbba" => "aaa"
 * 5. Remove 3 'a': "aaa" => ""
 */
public class CandyCrush {

    public static void main(String[] args) {
        System.out.println(candyCrush("aabbccddeeedcba", 3));
        System.out.println(removeDuplicates("aabbccddeeedcba", 3));

        System.out.println(candyCrush("aaabbbacd", 3));
        System.out.println(removeDuplicates("aaabbbacd", 3));

        System.out.println(candyCrush("aabbbacd", 3));
        System.out.println(removeDuplicates("aabbbacd", 3));

        System.out.println(candyCrush("avvvaaavv", 3));
        System.out.println(removeDuplicates("avvvaaavv", 3));

        System.out.println(candyCrush("pbbcggttciiippooaais", 2));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    public static String candyCrush(String s, int k) {

        if (s == null || s.isEmpty()) {
            return s;
        }

        int n = s.length();
        Deque<Letter> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            int count = 1;

            while (i + 1 < n && c == s.charAt(i + 1)) {
                count++;
                i++;
            }

            if (!stack.isEmpty() && stack.peek().val == c) {
                count += stack.pop().count;
            }

            if (count < k) {
                stack.push(new Letter(c, count));
            }
        }

        StringBuilder sb = new StringBuilder(n);
        while (!stack.isEmpty()) {
            Letter letter = stack.pollLast();
            for (int count = letter.count; count > 0; count--) {
                sb.append(letter.val);
            }
        }
        return sb.toString();
    }

    private static class Letter {
        char val;
        int count;

        public Letter(char c, int count) {
            this.val = c;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> counts = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (counts.empty() || s.charAt(i) != counts.peek().ch) {
                counts.push(new Pair(1, s.charAt(i)));
            } else {
                if (++counts.peek().cnt == k) {
                    counts.pop();
                }
            }
        }
        StringBuilder b = new StringBuilder();
        while (!counts.empty()) {
            Pair p = counts.pop();
            for (int i = 0; i < p.cnt; i++) {
                b.append(p.ch);
            }
        }
        return b.reverse().toString();
    }

    private static class Pair {
        int cnt;
        char ch;

        public Pair(int cnt, char ch) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
