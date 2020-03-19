package google.leetcode_2020.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {0, 0};
//        int[] ans1 = new ProductOfArrayExceptSelf().productExceptSelf1(nums);
//        System.out.println(Arrays.toString(ans1));

        int[] ans2 = new ProductOfArrayExceptSelf().productExceptSelf2(nums);
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = new ProductOfArrayExceptSelf().productExceptSelf3(nums);
        System.out.println(Arrays.toString(ans3));
    }

    // Approach 1: Using Division
    // Time = O(N + N) = O(N)
    // Space = O(1)
    // This does not work for 0, 0
    public int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) {
            return ans;
        }
        int mul = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i];
        }
//        System.out.println(Arrays.toString(ans));
        // divide by nums
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mul / nums[i];
        }
        return ans;
    }

    // Approach 2: Using 2 arrays / without division
    // Time = O(N + N) = O(N)
    // Space = O (N + N= O(N)
    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) {
            return ans;
        }

        int[] leftMul = new int[nums.length];
        int[] rightMul = new int[nums.length];
        leftMul[0] = 1;
        leftMul[1] = nums[0];
        rightMul[nums.length - 1] = 1;
        rightMul[nums.length - 2] = nums[nums.length - 1];
        for (int i = 2, j = nums.length - 3; i < nums.length && j >= 0; i++, j--) {
            leftMul[i] = nums[i - 1] * leftMul[i - 1];
            rightMul[j] = nums[j + 1] * rightMul[j + 1];
        }

//        System.out.println(Arrays.toString(leftMul));
//        System.out.println(Arrays.toString(rightMul));

        // Multiply left and right
        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftMul[i] * rightMul[i];
        }
        return ans;
    }

    // Approach 3: Without division
    // It is similar to above approach, except one of the array will be computed on the go
    // Time = O(N + N) = O(N)
    // Space = O(1)
    public int[] productExceptSelf3(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 0) {
            return ans;
        }
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        // O(1) space
        // track multiplication from right side
        int mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul *= nums[i + 1];
            ans[i] *= mul;
        }
        return ans;
    }
}
