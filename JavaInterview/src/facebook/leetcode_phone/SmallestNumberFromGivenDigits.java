package facebook.leetcode_phone;

import java.util.Arrays;

public class SmallestNumberFromGivenDigits {


    public static void main(String[] args) {
        int[] nums = {9, 0, 0};
        int lowerBound = 0;
        int ans = new SmallestNumberFromGivenDigits().findNextPermutation(nums, lowerBound);
        System.out.println(ans);
    }

    //
    public int findNextPermutation(int[] nums, int lowerBound) {

        if (nums.length == 0) {
            return 0;
        }

        int[] sortArr = new int[10];
        for (int i = 0; i < nums.length; i++) {
            sortArr[nums[i]]++;
        }

        String temp = Integer.toString(lowerBound);
        int[] lower = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            lower[i] = temp.charAt(i) - '0';
        }

        System.out.println(Arrays.toString(lower));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = lower[i]; j < sortArr.length; j++) {
//                System.out.println(j);
                if (sortArr[j] != 0) {
                    sb.append(j);
                    sortArr[j]--;
                    break;
                }

            }
        }
        return Integer.parseInt(sb.toString());
    }
}
