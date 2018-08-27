package google;

import java.util.Arrays;

/**
 * Problem Statement:
 *
 * Given an array of n positive integers. Write a program to find the sum of
 * maximum sum subsequence of the given array such that the integers in the
 * subsequence are in increasing order.
 *
 *
 * @author hbhavsar Reference:
 *         http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 */
public class MaximumSubIncreasingSubSequence {

	public static void main(String args[]) {
		MaximumSubIncreasingSubSequence mss = new MaximumSubIncreasingSubSequence();
		int arr[] = { 1, 101, 10, 2, 3, 100, 4 };
		int r = mss.maxSum(arr);
		System.out.print(r);
	}

	public int maxSum(int nums[]) {

		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int max = nums[0];
		
		if(nums.length == 1) {
			return max;
		}
		int n = nums.length;
		int[] dp = Arrays.copyOf(nums, n);
		
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[j] + nums[i], dp[i]);	
				}
			}
			max = Math.max(dp[i], max);
		}
		
//		for (int i = 1; i < dp.length; i++) {
//			if (dp[i] > max) {
//				max = dp[i];
//			}
//		}
		return max;
	}
}
