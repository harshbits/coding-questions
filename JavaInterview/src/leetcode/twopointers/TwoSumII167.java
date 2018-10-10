package leetcode.twopointers;

import java.util.Arrays;

/**
 * 
 * 
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * @author habhavsar
 *
 */
public class TwoSumII167 {

	public static void main(String[] args) {
		var numbers = new int[] { 2, 7, 11, 15 };
		var target = 9;
		var answer = new TwoSumII167().twoSum(numbers, target);
		System.out.println(Arrays.toString(answer));
	}

	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return new int[0];
		}
		int si = 0;
		int ei = numbers.length - 1;

		while (numbers[si] + numbers[ei] != target) {
			if (numbers[si] + numbers[ei] > target) {
				ei--;
			} else {
				si++;
			}
		}
		if (numbers[si] + numbers[ei] == target) {
			return new int[] { si + 1, ei + 1 };
		}
		return new int[0];
	}
}
