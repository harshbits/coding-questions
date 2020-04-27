package facebook.leetcode_2020.array;

public class MaximumProductSubarray {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {-2, 3, -4};
        int[] nums = {-2, 0, -1};
        int ans = new MaximumProductSubarray().maxProduct(nums);
        System.out.println(ans);
    }

    // Time: O(n)
    // Space: O(1)
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxCurrent = nums[0];
        int minCurrent = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // for negatives
            if (nums[i] < 0) {
                int temp = maxCurrent;
                maxCurrent = minCurrent;
                minCurrent = temp;
            }

            minCurrent = Math.min(nums[i], minCurrent * nums[i]);
            maxCurrent = Math.max(nums[i], maxCurrent * nums[i]);
            max = Math.max(max, maxCurrent);
        }
        return max;
    }
}

//n = 2
// minMul = 2
// maxMul = 2

// n = 2, 3
// minMul = 2
// maxMul = 6

// n = 2, 3, -2
// minMul = 2 =>
// maxMul = 6 =>


// [-2,3,-4]
// -2
// -2 * 3 = -6
// -2 * 3 * -4 = 24

