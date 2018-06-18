package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * @author hbhavsar
 *
 */
public class LongestSubstringWORepeatingChar {

	public static void main(String[] args) {

		String s = "abcabcbb";

		int ans = new LongestSubstringWORepeatingChar().lengthOfLongestSubstring(s);

		System.out.println(ans);
	}

	// Modified Kadane with HashMap
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] arr = s.toCharArray();
		int currentSum = 0, maxSum = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		
		for (int i = 0, start = 0; i < arr.length; i++) {
			Integer j = charMap.get(arr[i]);
			if (j == null || j < start) {
				currentSum++;
			}else {
				start = j + 1;
				currentSum = i - start + 1;
			}
			charMap.put(arr[i], i);
			maxSum = Math.max(currentSum, maxSum);
		}
		return maxSum;
	}
	
	// Without using HashMap, kadane on array
	public int lengthOfLongestSubstringKadane(String s) {
		// Can be 128/256 = As par ASCII
		int lastIndices[] = new int[128];
		Arrays.fill(lastIndices, -1);
		
		int max = 0;
		int currentMax = 0;
		int start = 0;
		char[] arr = s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (lastIndices[ch] < start) {
				currentMax++;
			}else {
				int last = lastIndices[ch];
				start = last + 1;
				currentMax = i - start + 1;
			}
			lastIndices[ch] = i;
//			max = Math.max(currentMax, max);
			if(currentMax > max) {
				max = currentMax;
			}
		}
		return max;
	}

	 public int lengthOfLongestSubstring1(String s) {
			// if (s == null || s.length() == 0) {
			// 	return 0;
			// }
			char[] arr = s.toCharArray();
			int currentSum = 0, maxSum = 0;
			Map<Character, Integer> charMap = new HashMap<>();
			
			for (int i = 0, start = 0; i < arr.length; i++) {
				Integer j = charMap.get(arr[i]);
				if (j == null || j < start) {
					currentSum++;
				}else {
					start = j + 1;
					currentSum = i - start + 1;
				}
				charMap.put(arr[i], i);
				maxSum = Math.max(currentSum, maxSum);
				// if(currentSum > maxSum) {
				// 	maxSum = currentSum;
				// }
			}
			return maxSum;
	        // Can be 128/256 = As par ASCII
//	 		int lastIndices[] = new int[128];
//	 		Arrays.fill(lastIndices, -1);
			
//	 		int max = 0;
//	 		int currentMax = 0;
//	 		int start = 0;
//	 		char[] arr = s.toCharArray();
			
//	 		for (int i = 0; i < arr.length; i++) {
//	 			char ch = arr[i];
//	 			if (lastIndices[ch] < start) {
//	 				currentMax++;
//	 			}else {
//	 				int last = lastIndices[ch];
//	 				start = last + 1;
//	 				currentMax = i - start + 1;
//	 			}
//	 			lastIndices[ch] = i;
	// //			max = Math.max(currentMax, max);
//	 			if(currentMax > max) {
//	 				max = currentMax;
//	 			}
//	 		}
//	 		return max;
	    }
}
