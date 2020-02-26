package amazon;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author hbhavsar
 *
 */
public class ThreeSum {

	public static void main(String[] args) throws ParseException {

		// new SimpleDateFormat("dd-MMM-yyyy").parse("");
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int target = 0;

		List<List<Integer>> ans = threeSum1(nums, target);

		System.out.println(ans);

		ans = threeSum2(nums, target);

		System.out.println(ans);
	}

	// 1
	// Naive approach O(n^3)

	// 2
	// Sorting and merging
	// beats 86%
	private static List<List<Integer>> threeSum1(int[] nums, int target) {
		
		List<List<Integer>> result = new ArrayList<>();

		// O(n log n)
		Arrays.sort(nums);

//		Arrays.stream(nums).sorted().collect(Collectors.toSet());
		
//		Set<Integer> numSet = Stream.of(nums).sorted().collect(Collectors.toSet());
		
		for (int i = 0; i < nums.length; i++) {
			// since the array has been sorted, below can skip duplicates
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			// inner loop, standard bi-directional sweep
			// this loop has "dynamic boundary", starting from i+1, ending at k
			// i move from beginning toward right, k moves from end toward left
			// j = i + 1 (start of the array)
			// k = length - 1 (end of the array)
			for (int j = i + 1, k = nums.length - 1; j < k;) {

				// evaluate the sum against the target
				// if meet, combine these 3 numbers into ArrayList and put into the
				// result
				if (nums[i] + nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));

					// Move to right
					j++;
					// Move to left
					k--;

					// dealing with situations of duplicate numbers in the sorted array
					// there are 2 situations that could encounter duplicates
					// 1) when j moving forward, current j equals to previous one, skip
					while (j < k && nums[j] == nums[j - 1]) {
						// Continue to move right
						j++;
					}
					// 2) when k moving backward, current k equals to previous one, skip
					while (j < k && nums[k] == nums[k + 1]) {
						// continue to move left
						k--;
					}
				}
				// if sum of three numbers greater than 0
				// means greatest number, nums[k], need to get smaller, move backward k
				else if (nums[i] + nums[j] + nums[k] > target) {
					k--;
				}

				// if sum of three numbers smaller than 0
				// means middle number, nums[j], need to get larger, move forward j
				// this is also because i is fixed in this inner for-loop
				else {
					j++;
				}
			}
		}
		return result;
	}

	// 3
	// Sorting and merging
	// beats 95%
	private static List<List<Integer>> threeSum2(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();

		// O(n log n)
		Arrays.sort(nums);

		//
		for (int i = 0; i < nums.length - 2; i++) {
			if(nums[i] > target){
				break;
			}

			if(i == 0 || (i >0 && nums[i] != nums[i-1]) ){

				int low = i + 1;
				int high = nums.length - 1;

				while(low < high){
					int sum = nums[i] + nums[low] + nums[high];
					if(sum == target){
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						low++;
						high--;
						while (low < high && nums[low] == nums[low + 1]){
							low++;
						}
						while (low < high && nums[high] == nums[high - 1]){
							high--;
						}
					}
					else if(sum > target){
						high--;
					}else {
						low++;
					}
				}
			}
		}
		return result;
	}
}
