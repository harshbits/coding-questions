package google.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

 * @author hbhavsar
 *
 */
public class IsomorphicStrings205 {
	
	public static void main(String[] args) {
		String s = "paper";
		String t = "title";
		IsomorphicStrings205 i = new IsomorphicStrings205();
		boolean ans = i.isIsomorphic(s, t);
		System.out.println(ans);
	}

	public boolean isIsomorphic(String s, String t) {

		if(s.length() != t.length()) {
			return false;
		}
		
//		Map<Character, Character> map = new HashMap<>();
		
		int[] ms = new int[256];
		int[] mt = new int[256];
		
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		for (int i = 0; i < s.length(); i++) {

			if (ms[sc[i]] != mt[tc[i]]) {
				return false;
			}
			ms[sc[i]] = i + 1;
			mt[tc[i]] = i + 1;
		}
		
		
//		for (int i = 0; i < s.length(); i++) {
//			if (!map.containsKey(sc[i])) {
//				map.put(sc[i], tc[i]);
//				continue;
//			}
//
//			Character c = map.get(sc[i]);
//			if (c != tc[i]) {
//				return false;
//			}
//		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
