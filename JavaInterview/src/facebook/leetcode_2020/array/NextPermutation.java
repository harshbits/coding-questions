package facebook.leetcode_2020.array;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 4, 3, 1, 0};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Time: O(n)
    // Space: O(1)
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        // Step 1. Determine Inverse point
        // Init with second last index
        int inversePoint = nums.length - 2;
        // find actual inverse point
        while (inversePoint >= 0 && nums[inversePoint] >= nums[inversePoint + 1]) {
            inversePoint--;
        }

        // If inverse point is negative then there is no next permutation possible/
        if (inversePoint < 0) {
            reverse(nums, inversePoint + 1);
            return;
        }

        // Step 2. Swap inverse point which is smallest than inverse point
        // Start array from the end
        int end = nums.length - 1;
        while (end >= 0 && nums[end] <= nums[inversePoint]) {
            end--;
        }
        swap(nums, inversePoint, end);

        // Step 3. Reverse array after inverse point
        reverse(nums, inversePoint + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
