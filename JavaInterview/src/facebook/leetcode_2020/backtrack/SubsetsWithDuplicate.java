package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        var ans = new SubsetsWithDuplicate().subsetsWithDup(nums);
        System.out.println(ans);
    }

//    The recursive function is called 2^n times.
//    Because we have 2 choices at each iteration in nums array.
//    Either we include nums[i] in the current set, or we exclude nums[i].
//    This array nums is of size n = number of elements in nums.
//
//    We need to create a copy of the current set because we reuse the original one to build all the valid subsets.
//    This copy costs O(n) and it is performed at each call of the recursive function,
//    which is called 2^n times as mentioned in above.
//    So total time complexity is O(n x 2^n).
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    // O(2 ^ N)
    private void backtrack(int[] nums, int start, List<Integer> temp, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            // avoid duplicates
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp, subsets);
            // remove last element
            // backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
