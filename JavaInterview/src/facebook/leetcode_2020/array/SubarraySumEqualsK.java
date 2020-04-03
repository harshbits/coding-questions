package facebook.leetcode_2020.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {


    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int ans = new SubarraySumEqualsK().subarraySum(nums, 2);
        System.out.println(ans);
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        // total sum at given index
        // key = sum
        // value = count when (sum - k)
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (frequency.containsKey(sum - k)) {
                count += frequency.get(sum - k);
            }

            frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
        }

        System.out.println(frequency);
        return count;

    }
}
