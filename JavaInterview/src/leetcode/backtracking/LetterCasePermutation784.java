package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {

	public static void main(String[] args) {

		var S = "a1b2";
		var ans = new LetterCasePermutation784().letterCasePermutation(S);
		System.out.println(ans);

	}

	public List<String> letterCasePermutation(String S) {

		List<String> ans = new ArrayList<>();

		dfsBackTrack(S.toCharArray(), "", 0, ans);
		return ans;
	}

	private void dfsBackTrack(char[] sc, String s, int pos, List<String> ans) {

		if (sc.length == s.length()) {
			ans.add(s);
			return;
		}

		// for each combinations do calculations
		for (char c : getPossibleChar(sc[pos])) {
			dfsBackTrack(sc, s + c, pos + 1, ans);
		}
	}
	
	private char[] getPossibleChar(char c) {

		if (Character.isDigit(c)) {
			return new char[] { c };
		}

		return new char[] { Character.toLowerCase(c), Character.toUpperCase(c) };
	}

}
