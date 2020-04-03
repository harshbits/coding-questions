package facebook.leetcode_2020.array;

import java.util.Arrays;

public class IsAlienDictionary {


    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean ans = new IsAlienDictionary().isAlienSorted(words, order);
        System.out.println(ans);

        String[] words1 = {"word", "world", "row"};
        String order1 = "worldabcefghijkmnpqstuvxyz";
        boolean ans1 = new IsAlienDictionary().isAlienSorted(words1, order1);
        System.out.println(ans1);

        String[] words2 = {"kuvp", "q"};
        String order2 = "ngxlkthsjuoqcpavbfdermiywz";
        boolean ans2 = new IsAlienDictionary().isAlienSorted(words2, order2);
        System.out.println(ans2);
    }

    // Time : O(S * N)
    // Space: O(1)
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictionary = new int[26];
        for (int i = 0; i < order.length(); i++) {
            dictionary[order.charAt(i) - 'a'] = i;
        }
//        System.out.println(Arrays.toString(dictionary));
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], dictionary)) {
                return false;
            }
        }
        return true;
    }


    private boolean compare(String w1, String w2, int[] dictionary) {
        int m = w1.length();
        int n = w2.length();
        // compare
        for (int i = 0; i < Math.min(m, n); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                return dictionary[w1.charAt(i) - 'a'] < dictionary[w2.charAt(i) - 'a'];
            }
        }
        // after checking all the alphabets
        // if i - 1 string is bigger than current one
        // then return false
        return m < n;
    }
}