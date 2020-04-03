package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        var ans = new PermutationsWithDuplicate().permuteUnique(nums);
        System.out.println(ans);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        return permutations;
    }

    private void backtrack(int[] nums, List<Integer> temp, boolean[] visited, List<List<Integer>> permutations) {
        if (temp.size() == nums.length) {
            permutations.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // check for duplicates
                if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                // permutations
                visited[i] = true;
                temp.add(nums[i]);
                backtrack(nums, temp, visited, permutations);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
