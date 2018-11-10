package leetcode.uber;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses22 {

	public static void main(String[] args) {

		var ans = new GenerateParantheses22().generateParenthesis(3);
		System.out.println(ans);
	}

	public List<String> generateParenthesis(int n) {

		List<String> ans = new ArrayList<>();

		// Back Tracking
		// String builder twice faster than string in LC Performance
		generateParenthesisBackTracking(ans, new StringBuilder(), 0, 0, n);

		return ans;
	}

	public void generateParenthesisBackTracking(List<String> ans, StringBuilder current, int open, int close, int max) {

		if (current.length() == max * 2) {
			ans.add(current.toString());
			return;
		}

		if (open < max) {
			generateParenthesisBackTracking(ans, current.append("("), open + 1, close, max);
			// backtrack
			current.deleteCharAt(current.length() - 1);
		}

		if (close < open) {
			generateParenthesisBackTracking(ans, current.append(")"), open, close + 1, max);
			// backtrackvo
			current.deleteCharAt(current.length() - 1);
		}

	}

}
