package facebook.leetcode_2020.array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Time: O(n)
    // Space: O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != ptr) {
                    //int tmp = nums[ptr];
                    nums[ptr] = nums[i];
                    nums[i] = 0;
                }
                ptr++;
            }
        }
    }
}
