package facebook.leetcode_2020.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int ans = new KthLargestElement().findKthLargest(nums, k);
        System.out.println(ans);

        int[] nums1 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k1 = 4;
        int ans1 = new KthLargestElement().findKthLargest2(nums1, k1);
        System.out.println(ans1);
    }

    // Using heap
    // Time: O(N log K )
    // Space: O(K)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            // we will remove 3rd smallest always
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    // Using Quick Select
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    // Time:
    // O(N) average case
    // O(N^2) worst case
    int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[k];
        }
        int left = start, right = end;

        int pivot = start + (end - start) / 2;
        while (left <= right) {
            while (left <= right && nums[left] < nums[pivot]) {
                left++;
            }
            while (left <= right && nums[right] > nums[pivot]) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (k >= left) {
            return quickSelect(nums, left, end, k);
        }
        if (k <= right) {
            return quickSelect(nums, start, right, k);
        }
        return nums[k];
    }


    // O(1) time and space
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
