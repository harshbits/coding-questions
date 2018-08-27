package google.leetcode;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

 * @author hbhavsar
 *
 */
public class RegularExpressionMatching10 {
	
	private static final char WC_SAME = '*';

	private static final char WC_ALL = '.';
	
	public static void main(String[] args) {
		RegularExpressionMatching10 rm = new RegularExpressionMatching10();
		System.out.println(rm.isMatch("Harsh".toCharArray(), "Harsh".toCharArray()));
		System.out.println(rm.isMatch("Hars".toCharArray(), "Harsh*a*b*".toCharArray()));
		System.out.println(rm.isMatch("".toCharArray(), "a*b*".toCharArray()));
		System.out.println(rm.isMatch("abbbbccc".toCharArray(), "a*ab*bbbbc*".toCharArray()));
		System.out.println(rm.isMatch("abbbbccc".toCharArray(), "aa*bbb*bbbc*".toCharArray()));
		System.out.println(rm.isMatch("abbbbccc".toCharArray(), ".*bcc".toCharArray()));
		System.out.println(rm.isMatch("abbbbccc".toCharArray(), ".*bcc*".toCharArray()));
		System.out.println(rm.isMatch("abbbbccc".toCharArray(), ".*bcc*".toCharArray()));
		System.out.println(rm.isMatch("aaa".toCharArray(), "ab*a*c*a".toCharArray()));
		System.out.println(rm.isMatch("aa".toCharArray(), "a*".toCharArray()));
	}

	public boolean isMatch(String s, String p) {
		if(s == null && p == null) {
			return true;
		}
		if(s.isEmpty() && p.isEmpty()) {
			return true;
		}
		return isMatch(s, p);
	}
	
	
	public boolean isMatch(char[] s, char[] p) {

		// Initializes as first row and first column is false.
		boolean[][] dp = new boolean[s.length + 1][p.length + 1];
		// if strings are empty then it is true
		dp[0][0] = true;
		
		//Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < dp[0].length; i++) {
			if (p[i - 1] == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}
		
		// String index = i
		// Pattern index = j
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
		
				// for matching character or "."
				// reducing the size of index as we have added empty row and column in dp matrix
				// So getting actual index of the string
				if (s[i - 1] == p[j - 1] || p[j - 1] == WC_ALL) {
					// diagonal element
					dp[i][j] = dp[i - 1][j - 1];
				}
				// for * 
				else if (p[j - 1] == WC_SAME) {
					
					dp[i][j] = dp[i][j - 2];
					
					// If character moving backward 2 positions for pattern,
					// is similar to character of string
					if (p[j - 2] == WC_ALL || p[j - 2] == s[i - 1]) {
						dp[i][j] = dp[i][j] | dp[i - 1][j]; 
					}
				}else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[s.length][p.length];
	}

}
