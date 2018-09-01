package google.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 * 
 * @author hbhavsar
 *
 */
public class MinimumWindowSubstring76 {
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring76 m = new MinimumWindowSubstring76();
		String ans = m.minWindow(s, t);
		System.out.println(ans);

	}

	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		
		char[] sc = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int start = 0;
		int end = 0;
		int counter = map.size();
		int head = 0;
		int length = Integer.MAX_VALUE;
		
		while (end < sc.length) {

			char c = sc[end];
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					counter--;
				}
			}
			end++;
			
			while (counter == 0) {
				char first = sc[start];
				if(map.containsKey(first)) {
					map.put(first, map.get(first) + 1);
					if (map.get(first) > 0) {
						counter++;
					}
				}
				
				if(end - start < length) {
					length = end - start;
					head = start;
				}
				start++;
			}
		}
		
		if (length == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(head, head + length);
		
	}
}
