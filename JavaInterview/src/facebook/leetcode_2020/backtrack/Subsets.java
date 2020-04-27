package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        var ans = new Subsets().subsets(nums);
        System.out.println(ans);
    }

    // Time: O(n log n)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        //Time: O(n log n)
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    // Time: O(2^n)
    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, subsets);
            // remove last element
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
