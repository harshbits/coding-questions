package google.leetcode_2020.math;

public class SingleNumberII {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        int ans = new SingleNumberII().singleNumber(nums);
        System.out.println(ans);
    }

    public int singleNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;
        for (int num : nums) {
            // NOT seen twice AND seen once XOR number
            seenOnce = ~seenTwice & (seenOnce ^ num);
            // NOT seen once AND seen twice XOR number
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}
