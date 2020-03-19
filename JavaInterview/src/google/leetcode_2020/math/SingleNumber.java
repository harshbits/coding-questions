package google.leetcode_2020.math;

public class SingleNumber {

    public static void main(String[] args) {

        int[] nums = {4, 1, 2, 1, 2};
        int ans = new SingleNumber().singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}
