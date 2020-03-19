package google.leetcode_2020;

public class CanJump {


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean ans = new CanJump().canJump1(nums);
        System.out.println(ans);
    }

    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
            System.out.println(lastPos);
        }
        return lastPos == 0;
    }

    public boolean canJump1(int[] nums) {
        return helper(nums, nums.length-1);
    }


    public boolean helper(int[] nums, int idx) {
        System.out.println(idx);
        if (idx == 0) return true;
        for (int i = idx - 1; i >= 0; i--) {
            if (i + nums[i] >= idx) {
                return helper(nums, i);
            }
        }
        return false;
    }
}
