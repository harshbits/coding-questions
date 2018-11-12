package leetcode.uber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * input: Is two parameters, a list of string, and a string target. output: Look
 * for the longest string in the list that contains all the characters in the
 * target.
 * 
 * @author habhavsar
 *
 */
public class Fan1P2Acrs {

	public static void main(String[] args) {
		var strings = List.of("bc", "ab", "abc", "abcd", "abaab");
		var target = "aaa";

		var ans = new Fan1P2Acrs().longestString1(strings, target);
		System.out.println(ans);
	}

	public String longestString(List<String> strings, String target) {
		
		
		Map<Character, Integer> countMap = new HashMap<>();
		// O (target length)
		for (char c : target.toCharArray()) {
			countMap.put(c, countMap.getOrDefault(c, 0) + 1);
		}
		String ans = "";
		int max = 0;

		// Time complexity : O (dict length * Max(word length) * target length)

		// O (dictionary length)
		for (String s : strings) {

			// O (Word Length)
			Map<Character, Integer> dictMap = new HashMap<>();
			for (char c : s.toCharArray()) {
				dictMap.put(c, dictMap.getOrDefault(c, 0) + 1);
			}

			// O (target length)
			for (Entry<Character, Integer> e : countMap.entrySet()) {
				if (dictMap.getOrDefault(e.getKey(), 0) < e.getValue()) {
					continue;
				}
			}
			if (s.length() > max) {
				ans = s;
				max = s.length();
			}
		}

		return ans;
	}

	public String longestString1(List<String> strings, String target) {
		
		
		int[] targetCount = new int[26];
		for (char c : target.toCharArray()) {
			targetCount[c - 'a'] += 1;
		}
		
		System.out.println(Arrays.toString(targetCount));
		String ans = "";
		int max = 0;

		return ans;
	}
}
