package leetcode.binarysearch;

public class SearchinRotatedSortedArray33 {

	public static void main(String[] args) {

//		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int[] nums = { 5, 1, 3 };
		int target = 5;
		System.out.println(new SearchinRotatedSortedArray33().search(nums, target));
	}

	// Binary Search
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] == nums[low]) {
				low++;
			} else if (nums[mid] > nums[low]) {
				if (nums[mid] > target && nums[low] <= target) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (nums[mid] < target && nums[high] >= target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}
}
