package google.leetcode_2020.array;

public class SplitArrayConsecutiveSubseq {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
//        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        boolean ans = new SplitArrayConsecutiveSubseq().isPossible(nums);
        System.out.println(ans);
    }

    public boolean isPossible(int[] nums) {
        // we need at least 3 numbers
        if (nums == null || nums.length < 3) {
            return false;
        }

        int previous = Integer.MIN_VALUE;
        // Keeps previous number of subsequence of array of length 1
        int previousEnd1 = 0;
        // Keeps previous number of subsequence of array of length 2
        int previousEnd2 = 0;
        // Keeps previous number of subsequence of array of length >=3
        int previousEnd3 = 0;

        int current = 0;
        // Keeps the last element of current subsequence of array of length 1
        int currentEnd1 = 0;
        // Keeps the last element of current subsequence of array of length 2
        int currentEnd2 = 0;
        // Keeps the last element of current subsequence of array of length >=3
        int currentEnd3 = 0;

        for (int i = 0; i < nums.length; ) {

            current = nums[i];

            // find similar
            int count = 0;
            while (i < nums.length && current == nums[i]) {
                i++;
                count++;
            }

            // If it's not continuous (previous + 1 != previous)
            if (previous != current - 1) {
                // chains ending at pre number with length 1 and 2
                // are non-zero, just return false.
                if (previousEnd1 != 0 || previousEnd2 != 0) {
                    return false;
                }
                currentEnd1 = count;
                currentEnd2 = currentEnd3 = 0;
            } else {// When it's continuous (previous + 1 == current)

                // if current number cannot cover the number of chains ending at
                // pre number with length 1 and 2, just return false.
                if (count < previousEnd1 + previousEnd2) {
                    return false;
                }

                // extended length 1 chain to be length 2.
                currentEnd2 = previousEnd1;
                // extended length 2 chain to be length 3.
                currentEnd3 = previousEnd2;

                // update current chain

                // Then remaining current will be distributed to either preEndL3
                // or create new chain.
                // always prefer to extend old chain first
                int remaining = count - previousEnd1 - previousEnd2;
                // number to extend old chain
                int extend = Math.min(previousEnd3, remaining);
                currentEnd3 += extend;

                // create new chain
                currentEnd1 = Math.max(0, remaining - extend);
            }

            previous = current;
            previousEnd1 = currentEnd1;
            previousEnd2 = currentEnd2;
            previousEnd3 = currentEnd3;
        }
        // both of the array Endgth has to be 0.
        return previousEnd1 == 0 && previousEnd2 == 0;
    }
}
