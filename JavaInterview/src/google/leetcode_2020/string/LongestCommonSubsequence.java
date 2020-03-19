package google.leetcode_2020.string;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTABAGGTABAGGTABAGGTABAGGTABAGGTAB";
		String s2 = "GXTXAYBGXTXAYBGXTXAYBGXTXAYBGXTXAYBGXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		long start = System.currentTimeMillis();
//		int ans = lcs.lcs(X, Y, m, n);
		long end = System.currentTimeMillis();
//		System.out.println("Recursion: " + (start - end) + ", Length of LCS is" + " " + ans);

		start = System.currentTimeMillis();
		int ans1 = lcs.lcsDP(X, Y, m, n);
		end = System.currentTimeMillis();
		System.out.println("DP: " + (start - end) + ", Length of LCS is" + " " + ans1);
	}

	// takes alot of time
	// Exponential
	private int lcs(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (X[m - 1] == Y[n - 1]) {
			return 1 + lcs(X, Y, m - 1, n - 1);
		} else {
			return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
		}
	}

	private int lcsDP(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				 if (i == 0 || j == 0) {
					dp[i][j] = 0;
				 }
				 else if(X[i-1] == Y[j-1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				 }else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				 }
			}
		}

		return dp[m][n];
	}

}
