package leetcode.uber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * @author habhavsar
 *
 */
public class RussianDollEnvelopes354 {
	
	public static void main(String[] args) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		var ans = new RussianDollEnvelopes354().maxEnvelopes(envelopes);
		System.out.println(ans);

	}

	public int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		// Part 1
		// Sort by Area of the envelope
		// 1. Ascending order by width
		// 2. Descending order by height, if they are same

		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// Point 2.
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				// Point 1.
				return o1[0] - o2[0];
			}
		});

		// Part 2
		// Find the Longest Increasing Subsequence based on the height
		// Refer Question 300, Leetcode

		int[] dp = new int[envelopes.length];
		int length = 0;

		for (int[] envelope : envelopes) {
			int low = 0;
			int high = length;

			while (low < high) {
				int mid = (low + high) / 2;
				if (dp[mid] < envelope[1]) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}
			dp[low] = envelope[1];
			if (low == length) {
				length++;
			}
		}

		return length;
	}
}
