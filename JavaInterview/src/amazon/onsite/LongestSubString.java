package amazon.onsite;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * @author hbhavsar
 *
 */
public class LongestSubString {

	public static void main(String[] args) {
		String s = "abcabcbb";
		
		int ans = new LongestSubString().lengthOfLongestSubstring(s);
		System.out.println(ans);
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		Map<Character, Integer> dpMap = new HashMap<>();
		int max = 0;
		char[] sc = s.toCharArray();
		for (int i = 0, j = 0; i < sc.length; ++i) {
			if (dpMap.containsKey(sc[i])) {
				j = Math.max(j, dpMap.get(sc[i]) + 1);
			}
			dpMap.put(sc[i], i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
