package google.leetcode.string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * Example 1:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" Output: true Example 2:
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" Output: false
 * 
 * @author hbhavsar
 *
 */
public class InterleavingString97 {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		InterleavingString97 i = new InterleavingString97();
		boolean ans = i.isInterleave(s1, s2, s3);
		System.out.println(ans);
		
		ans = i.isInterleave1DDp(s1, s2, s3);
		System.out.println(ans);

	}

	public boolean isInterleave(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		// store previous sub problems
		// Initialize it size + 1 to store 0 row and column value. (starting point)
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		char[] sc1 = s1.toCharArray();
		char[] sc2 = s2.toCharArray();
		char[] sc3 = s3.toCharArray();
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				int k = i + j - 1;
				if (i == 0 && j == 0) {
					// first element as true
					dp[i][j] = true;
				} else if (i == 0) {
					if (sc3[k] == sc2[j - 1]) {
						dp[i][j] = dp[i][j - 1];
					}
				} else if (j == 0) {
					if (sc3[k] == sc1[i - 1]) {
						dp[i][j] = dp[i - 1][j];
					}
				} else {
					dp[i][j] = (sc3[k] == sc2[j - 1] ? dp[i][j] = dp[i][j - 1] : false)
							|| (sc3[k] == sc1[i - 1] ? dp[i][j] = dp[i - 1][j] : false);
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

	public boolean isInterleave1DDp(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		// store previous sub problems
		// Initialize it size + 1 to store 0 row and column value. (starting point)
		boolean[] dp = new boolean[s2.length() + 1];

		char[] sc1 = s1.toCharArray();
		char[] sc2 = s2.toCharArray();
		char[] sc3 = s3.toCharArray();
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				int k = i + j - 1;
				if (i == 0 && j == 0) {
					// first element as true
					dp[j] = true;
				} else if (i == 0) {
					if (sc3[k] == sc2[j - 1]) {
						dp[j] = dp[j - 1];
					}
				} else if (j == 0) {
					if (sc3[k] == sc1[i - 1]) {
						dp[j] = dp[j];
					}
				} else {
					dp[j] = (sc3[k] == sc2[j - 1] ? dp[j - 1] : false)
							|| (sc3[k] == sc1[i - 1] ? dp[j] : false);
				}
			}
		}

		return dp[s2.length()];
	}

}
