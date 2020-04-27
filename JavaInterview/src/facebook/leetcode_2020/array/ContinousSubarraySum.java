package facebook.leetcode_2020.array;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubarraySum {

    public static void main(String[] args) {
        ContinousSubarraySum c = new ContinousSubarraySum();
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(c.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }

    // Time: O(n)
    // Space: O(n)
    public boolean checkSubarraySum(int[] nums, int k) {
        // running sum and index
        Map<Integer, Integer> sum = new HashMap<>();
        int runningSum = 0;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }

            Integer prev = sum.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                sum.put(runningSum, i);
            }
        }
        return false;
    }
}
