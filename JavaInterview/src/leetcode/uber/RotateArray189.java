package leetcode.uber;

import java.util.Arrays;

public class RotateArray189 {

	
	// IP = 1, 2, 3, 4, 5, 6, 7
	// OP = 5, 6, 7, 1, 2, 3, 4
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		var k = 3;
		new RotateArray189().rotate(nums, k);
		System.out.println(Arrays.toString(nums));

	}

	
	public void rotate(int[] nums, int k) {
		
		k %= nums.length;
		
		// Reverse Entire Array
		reverse(nums, 0, nums.length);
		
		// Rotate up to k elements
		reverse(nums, 0, k);
		
		// Rotate from k to n elements
		reverse(nums, k, nums.length);
	}
	

	// o(n) time, In real o(n/2) time
	public void reverse(int[] nums, int start, int end) {
		end--;
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	
	// Cyclic Replacements
	// 1 -> 4
	// 4 -> 7
	// 7 -> 3
	// 3 -> 6
	// 6 -> 2
	// 2 -> 5
	// 5 -> 1
	
	public void rotateCR(int[] nums, int k) {
		if (k < 1 || nums == null || nums.length == 0) {
			return;
		}
		
//		int[] temp = new int[k];
//		for (int i = k - 1; i >= 0; i--) {
//			
//			System.out.println("i " + i );
//			System.out.println("n " + (nums.length - i - 1));
//			temp[i] = nums[nums.length - i - 1];
//		}
//		System.out.println(Arrays.toString(temp));

		k = k % nums.length;
		int total = 0;
		int start = 0;
		while (total < nums.length) {
			int current = start;
			int prev = nums[start];
			do {
				// K'th position, handles > nums.length
				int next = (current + k) % nums.length;
				// temp of next
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				total++;
			} while (start != current);
			start++;
		}
	}
	
}
