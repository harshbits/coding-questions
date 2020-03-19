package google.leetcode_2020;

public class MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = new MaximumSubarray().maxSubArray(nums);
        System.out.println(ans);
    }

    // DP
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int currentSum = max;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > nums[i] + currentSum) {
                currentSum = nums[i];
            }else {
                currentSum += nums[i];
            }

//            currentSum = Math.max(nums[i], nums[i] + currentSum);
            max = Math.max(max, currentSum);
        }

        return max;
    }
}

// -2  = -2
//[- 2, 1 ]    = 1
//-2, 1, -3  = - 2
// 4, = 4
// 4, -1 = 3
// 4, -1, 2 = 5
// 4, -1, 2, -5, 0
// 4 = 4
