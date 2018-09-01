package google.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * @author hbhavsar
 *
 */
public class LongestConsecutiveSequence128 {

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		LongestConsecutiveSequence128 l = new LongestConsecutiveSequence128();
		int ans = l.longestConsecutive(nums);
		System.out.println(ans);
		
	}
	
	// 1. Brute Force (find all) O (n^3)
	// 2. Sort and then find the consecutive O (n log n)
	// 3. with O(n) space into hashset, with O (n) time
	public int longestConsecutive(int[] nums) {

		if (nums.length == 1) {
			return 1;
		}
		
		Set<Integer> allNums = new HashSet<>(nums.length);
		Arrays.stream(nums).forEach(n -> allNums.add(n));
		
		int longest = 0;
		
		for (int n : nums) {
			
			if (!allNums.contains(n - 1)) {
				int currentNum = n;
				int currentLongest = 1;
				
				while (allNums.contains(currentNum + 1)) {
					currentNum++;
					currentLongest++;
				}
				longest = Math.max(currentLongest, longest);
			}
			
		}
		
		return longest;
	}
	
	public boolean isPathWet(int[] rain, int pathLength) {

		if (rain.length != pathLength) {
			return false;
		}
		// store all rain into set
		Set<Integer> allNums = new HashSet<>(rain.length);
		Arrays.stream(rain).forEach(n -> allNums.add(n));

		for (int n : rain) {

		}

		return true;
	}
}
