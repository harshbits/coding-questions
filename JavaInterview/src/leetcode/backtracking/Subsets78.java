package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 };
		var ans = new Subsets78().subsets(nums);
		System.out.println(ans);
	}

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		ans.add(temp);
		
		dfsHelper(nums, 0, temp, ans);
		return ans;
	}
	
	private void dfsHelper(int[] nums, int n, List<Integer> temp, List<List<Integer>> ans) {

		if (n < nums.length) {
			for (int i = n; i < nums.length; i++) {

				temp.add(nums[i]);
				ans.add(new ArrayList<>(temp));
				dfsHelper(nums, n + 1, temp, ans);
				temp.remove(temp.size() - 1);
			}

		}
	}
}
