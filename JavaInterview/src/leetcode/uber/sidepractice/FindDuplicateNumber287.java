package leetcode.uber.sidepractice;

public class FindDuplicateNumber287 {

	public static void main(String[] args) {
		
		int[] nums = { 1, 3, 4, 2, 2 };
		int ans = new FindDuplicateNumber287().findDuplicate(nums);
		System.out.println(ans);
		
		int[] nums1 = { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 };
		ans = new FindDuplicateNumber287().findDuplicate(nums1);
		System.out.println(ans);
	}

	public int findDuplicate(int[] nums) {

		int turtle = nums[0];
		int rabbit = nums[0];

		// Phase 1
		// Find the intersection of both the values., i.e. index
		do {

			turtle = nums[turtle];
			rabbit = nums[nums[rabbit]];
		} while (turtle != rabbit);

		// Phase 2
		// find the actual value from the intersection
		int p1 = nums[0];
		int p2 = turtle;

		while (p1 != p2) {
			p1 = nums[p1];
			p2 = nums[p2];
		}

		return p1;
	}

}
