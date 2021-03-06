package leetcode.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]


 * 
 * @author habhavsar
 *
 */
public class KSmallestPairs373 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;
		
		var ans = new KSmallestPairs373().kSmallestPairs(nums1, nums2, k);
		ans.stream().forEach(a -> System.out.println(Arrays.toString(a)));
	}

	
	// Beats 92.40% of the results
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return Collections.emptyList();
		}
		
//		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) { 
//			return Collections.emptyList();
//		}
		
		List<int[]> answer = new ArrayList<>();
		
		// Min Heap
		Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// total of the pair smallest first
				return o1[0] + o1[1] - (o2[0] + o2[1]);
			}
		});
		
		// add initial values to the min heap.
		// nums1[i] value, 0th index value of second array, and index of second array
		// element.
//		for (int i = 0; i < nums1.length && i < k; i++) {
		for (int i = 0; i < Math.min(nums1.length, k); i++) {
			minHeap.add(new int[] { nums1[i], nums2[0], 0 });
		}
		
		
		// Now iterate over the rest of the values from num2
		while (k-- > 0 && !minHeap.isEmpty()) {
			int[] cur = minHeap.poll();
			// take the first value from the min heap, as it will be always minimum.
			answer.add(new int[] { cur[0], cur[1] });
			
			// if we max out the index for second array (nums2)
			if (cur[2] == nums2.length - 1) {
				continue;
			}
			
			// offer second array's other elements
			minHeap.add(new int[] { cur[0], nums2[cur[2] + 1], cur[2] + 1 });
		}
		
		return answer;
	}

}




