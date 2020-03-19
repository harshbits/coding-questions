package google.leetcode_2020.string;

public class SubstringWithNotEveryAlphabet {

    public static void main(String[] args) {

        int ans = new SubstringWithNotEveryAlphabet().allSubstrings("cab", new char[]{'a', 'c'});
        System.out.println(ans);
    }

    public int allSubstrings(String s, char[] alphabets) {
        // Only Alphabets = 26
        // Regular ASCII table = 128
        // Extended ASCII values = 256
        int[] map = new int[128];
        for (char c : alphabets) {
            map[c]++;
        }

        int total = alphabets.length;
        int result = 0;
        int start = 0;

        // Sliding Window
        for (int i = 0; i < s.length(); i++) {
            // compare and decrement
            if (map[s.charAt(i)]-- > 0) {
                total--;
            }

            while (total == 0) {
                if (++map[s.charAt(start++)] > 0) {
                    total++;
                }
            }
            result += i - start + 1;
        }
        return result;
    }
}
