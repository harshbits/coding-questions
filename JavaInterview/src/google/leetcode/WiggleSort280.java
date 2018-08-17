package google.leetcode;

import java.util.Arrays;

/**
 * 
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 * @author hbhavsar
 *
 */
public class WiggleSort280 {
	
	public static void main(String[] args) {
		
		int[] nums = { 3, 5, 2, 1, 6, 4 };
		WiggleSort280 w = new WiggleSort280();
		w.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
		
	}

	public void wiggleSort(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			
//			if ((i % 2 == 1 && nums[i] > nums[i + 1]) || (i % 2 == 0 && nums[i] < nums[i + 1])) {
//				swap(nums, i, i + 1);
//			}
			
			if (((i & 1) == 0) == (nums[i] > nums[i + 1])) {
				swap(nums, i, i + 1);
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	

}
