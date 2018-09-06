package google.leetcode.dp;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence). The matching should cover the entire input
 * string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like ? or *. Example
 * 1:
 * 
 * Input: s = "aa" p = "a" Output: false Explanation: "a" does not match the
 * entire string "aa". Example 2:
 * 
 * Input: s = "aa" p = "*" Output: true Explanation: '*' matches any sequence.
 * Example 3:
 * 
 * Input: s = "cb" p = "?a" Output: false Explanation: '?' matches 'c', but the
 * second letter is 'a', which does not match 'b'. Example 4:
 * 
 * Input: s = "adceb" p = "*a*b" Output: true Explanation: The first '*' matches
 * the empty sequence, while the second '*' matches the substring "dce". Example
 * 5:
 * 
 * Input: s = "acdcb" p = "a*c?b" Output: false
 * 
 * @author hbhavsar
 *
 */
public class WildcardMatching44 {

	public static void main(String[] args) {
		WildcardMatching44 w = new WildcardMatching44();
		String s = "adceb";
		String p = "*a*b";
		boolean ans = w.isMatch(s, p);
		System.out.println(ans);
	}

	public boolean isMatch(String s, String p) {

		// both strings are empty
		if ((s == null && p == null) || (s.isEmpty() && p.isEmpty())) {
			return true;
		}
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();

		if (pc.length == 1 && pc[0] == '*') {
			return true;
		}

		// replace multiple * with one *
		// e.g a**b***c --> a*b*c
		// This will help in decreased size.
		boolean isFirst = true;
		int index = 0;
		for (int i = 0; i < pc.length; i++) {
			if (pc[i] == '*') {
				if (isFirst) {
					pc[index++] = pc[i];
					isFirst = false;
				}
			} else {
				pc[index++] = pc[i];
				isFirst = true;
			}
		}
		
		// initialize dp matrix
		boolean[][] dp = new boolean[sc.length + 1][index + 1];
		
		// if both strings are empty, answer will be true
		dp[0][0] = true;

		if (index > 0 && pc[0] == '*') {
			dp[0][1] = true;
		}
		
		// calculation of sub problems
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				
				// If both characters are same for string
				if(sc[i -1] == pc[j -1] || pc[j-1] == '?') {
					// pick the diagonal element
					dp[i][j] = dp[i-1][j-1];
				}
				else if (pc[j - 1] == '*') {
					// check top or left adjacent cell value
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
				// commented this method, as boolean values are default false.
//				else {
//					dp[i][j] = false;
//				}
			}
		}
		
		return dp[sc.length][index];
	}

}
