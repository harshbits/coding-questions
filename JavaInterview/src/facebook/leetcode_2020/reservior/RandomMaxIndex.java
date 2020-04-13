package facebook.leetcode_2020.reservior;

import java.util.Random;

public class RandomMaxIndex {

    public static void main(String[] args) {
        int[] nums = {11, 30, 2, 30, 30, 30, 6, 2, 62, 62};
        int ans = new RandomMaxIndex().maxRandomIndex(nums);
        System.out.println(ans);
    }

    // Time: O(N)
    // Space: O(1)
    public int maxRandomIndex(int[] nums) {
        Random rd = new Random();

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
                count = 1;
            } else if (nums[i] == max) {
                count++;
                if (rd.nextInt(count) == 0) {
                    maxIndex = i;
                }
            }
            // index here in case if we need to return
            // all the values have seen sofar.
            // list.add(maxIndex)
        }
        return maxIndex;
    }
}
