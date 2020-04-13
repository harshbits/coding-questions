package facebook.leetcode_2020.string;

public class IsPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "abcd";
        boolean ans = new IsPalindrome().isPalindrome(s);
        System.out.println(ans);
    }

    // Part 1
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (start < end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Part 2, max we can remove one character
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int s, int t) {
        while (s <= t) {
            if (str.charAt(s) == str.charAt(t)) {
                s++;
                t--;
            } else
                return false;
        }
        return true;
    }
}
