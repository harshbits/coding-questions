package facebook.leetcode_2020.array;

import java.util.Arrays;

public class FirstAndLastPositionOfElement {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        var ans = new FirstAndLastPositionOfElement().searchRange(nums, 8);
        System.out.println(Arrays.toString(ans));

    }

    // Time = O(log n) + O(log n)
    // Space = O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = findRangeIndex(nums, target, true);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = findRangeIndex(nums, target, false) - 1;
        return new int[]{start, end};
    }

    // isStart = true will give first index
    // Time = O(log n)
    private int findRangeIndex(int[] nums, int target, boolean isStart) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (isStart && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // TLE, not recommended
    // Worst case => o(n)
    public int[] searchRangeTLE(int[] nums, int target) {
        int[] range = new int[2];
        int start = -1;
        int end = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
                while (i >= 0 && j <= high &&
                        nums[i] == target && nums[j] == target) {
                    if (nums[i] == target) {
                        start = i--;
                    }
                    if (nums[j] == target) {
                        end = ++j;
                    }
                }
                break;
            } else if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        range[0] = start;
        range[1] = end;
        return range;
    }
}
