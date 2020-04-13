package facebook.leetcode_2020.reservior;

import java.util.Random;

public class RandomPickIndex {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex r = new RandomPickIndex(nums);

        System.out.println(r.pick(3));
    }

    private int[] nums;

    private Random rd;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rd = new Random();
    }

    //O(N)
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i] && rd.nextInt(++count) == 0) {
                result = i;
            }
        }
        return result;
    }
}
