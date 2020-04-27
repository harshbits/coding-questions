package facebook.leetcode_2020.string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println(r.removeDuplicates("abbaca"));
        System.out.println(r.removeAllDuplicates("aaccccadddb"));
    }

    // remove adjacent duplicates (pair)
    // O(len(s)) , using stack
    public String removeDuplicates(String S) {

        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char c : S.toCharArray()) {
            // current character in sb (assume as stack, since it's like array)
            char lastChar = c;
            if (sbLength != 0 && lastChar == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;

            } else {
                sb.append(c);
                sbLength++;
            }
        }
        return sb.toString();
    }

    // remove all adjacent duplicates
    public String removeAllDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        int n = S.length();
        // Stack
        Deque<Letter> stack = new ArrayDeque<>(n);

        // o(n)
        // IMP: For candy crush problem it will be from i = 0.
        for (int i = n - 1; i >= 0; i--) {
            char c = S.charAt(i);
            int charCount = 1;
            while (i > 0 && S.charAt(i - 1) == c) {
                charCount++;
                i--;
            }

            if (!stack.isEmpty() && stack.peek().val == c) {
                charCount += stack.pop().count;
            }

            // IMP: For candy crush problem it will be less than 3.
            // Less than 2 means there are no adjacent characters,
            if (charCount < 2) {
                stack.push(new Letter(c, charCount));
            }
        }

        // Prepare String
        // O(n) max, if all chars are unique
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().val);
        }
        return sb.toString();
    }

    private class Letter {
        char val;
        int count;

        public Letter(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
