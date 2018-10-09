package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinderStream295 {

	public static void main(String[] args) {
		MedianFinderStream295 m = new MedianFinderStream295();
		m.addNum(1);
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());

	}

//	int[] nums;
//	int current;
	
//	private List<Integer> nums;
	
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;

	public MedianFinderStream295() {
//		this.nums = new int[10];
//		this.current = 0;
//		this.nums = new ArrayList<>();
		this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		this.minHeap = new PriorityQueue<>();
		
	}

	public void addNum(int num) {
//		nums[current] = num;
//		current++;
		
//		int index = Collections.binarySearch(nums, num);
//		if (index < 0) {
//			index = -index - 1;
//		}
//		nums.add(index, num);
		
		minHeap.add(num);
		maxHeap.add(minHeap.remove());
		if (minHeap.size() < maxHeap.size()) {
			minHeap.add(maxHeap.remove());
		}
	}

	public double findMedian() {

//		if (current % 2 == 0) {
//			return (double) (nums[current / 2 - 1] + nums[current / 2]) / 2;
//		}
//
//		return nums[current / 2];

//		int size = nums.size();
//		if ((size % 2) == 1) {
//			return nums.get(size / 2);
//		}
//		return ((nums.get(size / 2 - 1) + (double) nums.get(size / 2)) / 2);
		
		if(minHeap.size() > maxHeap.size()) {
			return minHeap.peek();
		}
		
		return (double)(minHeap.peek() + maxHeap.peek()) / 2;
	}

}
