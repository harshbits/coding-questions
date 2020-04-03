package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static void main(String[] args) {

        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        var ans = new CombinationSum2().combinationSum2(nums, target);
        System.out.println(ans);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> temp, List<List<Integer>> combinations) {
        if (remain == 0) {
            combinations.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                // break because array is sorted
                if (remain - candidates[i] < 0) {
                    break;
                }

                /** skip duplicates */
                // not required if nums is unique
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(candidates, remain - candidates[i], i + 1, temp, combinations);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
