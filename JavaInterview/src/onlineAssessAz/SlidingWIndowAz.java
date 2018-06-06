package onlineAssessAz;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Michelle has created a word game for her students. The word game begins with
 * Michelle writing a string and a number, K, on the board. The students must
 * find a substring of size K such that there is exactly one character that is
 * repeated one; in other words, there should be k - 1 distinct characters in
 * the substring.
 * 
 * Write an algorithm to help the students find the correct answer. If no such
 * substring can be found, return an empty list; if multiple such substrings
 * exist, return all them, without repetitions. The order in which the
 * substrings are does not matter.
 * 
 * Input: The input to the function/method consists of two arguments -
 * inputString, representing the string written by the teacher; num an integer
 * representing the number, K, written by the teacher on the board.
 * 
 * Output: Return a list of all substrings of inputString with K characters,
 * that have k-1 distinct character i.e. exactly one character is repeated, or
 * an empty list if no such substring exist in inputString. The order in which
 * the substrings are returned does not matter.
 * 
 * Constraints: The input integer can only be greater than or equal to 0 and
 * less than or equal to 26 (0 <= num <= 26) The input string consists of only
 * lowercase alphabetic characters.
 * 
 * Example Input: inputString = awaglk num = 4
 * 
 * Output: [awag]
 * 
 * Explanation: The substrings are {awag, wagl, aglk} The answer is awag as it
 * has 3 distinct characters in a string of size 4, and only one character is
 * repeated twice.
 * 
 * @author hbhavsar
 *
 */
public class SlidingWIndowAz {

	public static void main(String[] args) {
		String s = "awaglk";
		int k = 4;

		List<String> ans = getK1SubStrings(s, k);

		ans.stream().forEach(System.out::println);
	}

	private static List<String> getK1SubStrings(String s, int k) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() == 0 || s.length() < k)
			return result;

		// DP
		int charCount[] = new int[26];

		int len = s.length();

		int count = 0;

		// O(N)
		for (int i = 0; i < len; i++) {
			if (charCount[s.charAt(i) - 'a'] == 0)
				count++;
			charCount[s.charAt(i) - 'a']++;
			if (i >= k - 1) {
				int startIndex = i - k + 1;
				if (count == k - 1)
					result.add(s.substring(startIndex, i + 1));
				charCount[s.charAt(startIndex) - 'a']--;
				if (charCount[s.charAt(startIndex) - 'a'] == 0)
					count--;
			}
		}
		return result;
	}

}
