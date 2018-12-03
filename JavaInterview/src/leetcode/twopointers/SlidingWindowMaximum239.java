package leetcode.twopointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum239 {

	public static void main(String[] args) {

		// 8
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		// 3
		int k = 5;

		var ans = new SlidingWindowMaximum239().maxSlidingWindow(nums, k);

		System.out.println(Arrays.toString(ans));

	}

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 0 || nums.length < k) {
			return new int[0];
		}

		int len = nums.length - k + 1;

		int[] ans = new int[len];

		int maxElementPos = -1;

		for (int i = 0; i < len; i++) {
			// initially it will fall under this condition.
			if (maxElementPos < i) {
				maxElementPos = i;
				// from starting position to till i + k steps
				for (int j = 0; j < k; j++) {
					if (nums[i + j] > nums[maxElementPos]) {
						maxElementPos = i + j;
					}
				}
			} else if (nums[maxElementPos] <= nums[i + k - 1]) {
				maxElementPos = i + k - 1;
			}
			ans[i] = nums[maxElementPos];
		}
		return ans;
	}

	// beats 4.71 % of the result
	public int[] maxSlidingWindow1(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k == 0 || nums.length < k) {
			return new int[0];
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < k; i++) {
			maxHeap.add(nums[i]);
		}

		int len = nums.length - k + 1;

//		List<Integer> ans = new ArrayList<>();
//		ans.add(maxHeap.peek());
		int[] ans = new int[len];
		ans[0] = maxHeap.peek();

		// log n remove
		maxHeap.remove(nums[0]);

		int stW = 1;
		int enW = k;

		while (enW < nums.length) {
			maxHeap.add(nums[enW++]);
//			ans.add(maxHeap.peek());
			ans[stW] = maxHeap.peek();
			maxHeap.remove(nums[stW++]);
		}

//		return ans.stream().mapToInt(i -> i).toArray();
		return ans;
	}

}
