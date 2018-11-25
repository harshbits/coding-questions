package leetcode.uber.sidepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII40 {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		if (candidates == null || candidates.length == 0) {
			return Collections.emptyList();
		}

		// Answer
		List<List<Integer>> ans = new ArrayList<>();

		// Sort candidates
		Arrays.sort(candidates);

		// Find all combinations, using backtracking
		combinationSum2DFS(candidates, target, 0, new ArrayList<>(), ans);

		return ans;
	}
		 
	
	private void combinationSum2DFS(int[] candidates, int target, int startIndex, 
			List<Integer> currentList, List<List<Integer>> ans) {

		// If target value becomes less than zero, no more solution
		if (target < 0) {
			return;
		}
		// found the answer
		if (target == 0) {
			ans.add(new ArrayList<>(currentList));
			return;
		}
		
		for (int i = startIndex; i < candidates.length; i++) {
		
			if (i > startIndex && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (candidates[i] > target) {
				break;
			}
			
			currentList.add(candidates[i]);
			combinationSum2DFS(candidates, target - candidates[i], i + 1, currentList, ans);
			currentList.remove(currentList.size() - 1);
		}
		
	}
	
	
}
