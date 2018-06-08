package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * @author hbhavsar
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 13;

		int[] ans = twoSum(nums, target);

		System.out.println(Arrays.toString(ans));
	}

	
	// 1
	// Naive solution would be => 2 for loops.
	// Brute Force Attack => Time = O(n^2), Space = O(1)
	
	// 2
	// Using Hash Map
	// Time => O(n), Space O(n)
	// 2.a => Using 2 pass => O(n) + O(n)
	// 2.b => Using just 1 pass => O(n), while storing
	
	// 2.b is the feasible solution
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		
//		Using Java 8 Stream
//		AtomicInteger atomicInteger = new AtomicInteger(0);
//		Arrays.stream(nums).forEach(num -> {
//			int i = atomicInteger.getAndIncrement();
//			System.out.println(i);
//			if (map.containsKey((target - num))) {
//				result[1] = i + 1;
//				result[0] = map.get(target - nums[i]);
//			}
//			map.put(nums[i], i + 1);
//		});
//		return result;
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i ;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}
}
