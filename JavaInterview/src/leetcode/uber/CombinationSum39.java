package leetcode.uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum39 {

	public static void main(String[] args) {

		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		var ans = new CombinationSum39().combinationSum(candidates, target);
		System.out.println(ans);

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return Collections.emptyList();
		}
		List<List<Integer>> ans = new ArrayList<>();
		combinationSumDFS(candidates, target, 0, 0, new ArrayList<>(), ans);
		return ans;
	}

	// DFS with back tracking
	private void combinationSumDFS(int[] candidates, int target, int startIndex, int currentSum, List<Integer> current,
			List<List<Integer>> ans) {

		if (currentSum == target) {
//			ans.add(current);
			ans.add(new ArrayList<>(current));
			return;
		}

		// for all candidates
		for (int i = startIndex; i < candidates.length; i++) {

			// if total sum do not surpass target
			if (currentSum + candidates[i] <= target) {
				current.add(candidates[i]);
				// for all candidates
				combinationSumDFS(candidates, target, i, currentSum + candidates[i], current, ans);
				// last element in the list
				current.remove(current.size() - 1);
			}
		}
	}
}
