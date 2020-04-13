package facebook.leetcode_2020.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAnagrams {

    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {

        if (s.length() == 0 || p.length() == 0) {
            return Collections.emptyList();
        }

        List<Integer> anagrams = new ArrayList<>();
        int[] charCount = new int[128];
        for (char c : p.toCharArray()) {
            charCount[c]++;
        }

        int start = 0, end = 0;
        int totalT = p.length();
        while (end < s.length()) {
            if (charCount[s.charAt(end)]-- > 0) {
                totalT--;
            }
            end++;
            // Move the start pointer when total  = 0.
            while (totalT == 0) {
                if (end - start == p.length()) {
                    anagrams.add(start);
                }
//                System.out.println(start);
                if (++charCount[s.charAt(start)] > 0) {
                    totalT++;
                }
                start++;
            }
        }
        return anagrams;
    }
}
