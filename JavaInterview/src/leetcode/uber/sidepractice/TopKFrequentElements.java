package leetcode.uber.sidepractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		var ans = new TopKFrequentElements().topKFrequent(nums, k);
		System.out.println(ans);
		
		int[] nums1 = { 1};
		k = 1;

		ans = new TopKFrequentElements().topKFrequent(nums1, k);
		System.out.println(ans);
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return Collections.emptyList();
		}

		List<Integer> answer = new ArrayList<>();

		Map<Integer, Frequency> count = new HashMap<>();
		for (int s : nums) {
			count.putIfAbsent(s, new Frequency(s, 0));
			count.get(s).count++;
		}

		// Max Heap to store as per the count of the words
		PriorityQueue<Frequency> maxHeap = new PriorityQueue<>();
		maxHeap.addAll(count.values());

		// get k max word by count
		while (k-- > 0) {
			int num = maxHeap.poll().num;
			answer.add(num);
		}

		return answer;
	}

	class Frequency implements Comparable<Frequency> {

		int num;

		int count = 0;

		Frequency(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Frequency o) {

			// if count of 2 words are same,
			// then return as per topological order (alphabetic order word first)
			if (this.count == o.count) {
				return this.num - o.num;
			}

			return o.count - this.count;
		}

	}
}
