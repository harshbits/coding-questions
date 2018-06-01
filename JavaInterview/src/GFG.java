class GFG {
	int min(int x, int y, int z) {
		if (x < y && x < z)
			return x;
		if (y < x && y < z)
			return y;
		else
			return z;
	}

	public int minDistance(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		// Create a table to store results of subproblems
		// To process a row, we just need the previous rows value. So 1d array should be
		// enough.
		int dp[] = new int[n + 1];

		// For first row m=0(first string is empty), we have to insert all the char in
		// second string.
		for (int i = 0; i <= n; i++) {
			dp[i] = i;
		}
		// Fill d[][] in bottom up manner
		for (int i = 1; i <= m; i++) {
			// Prev will holed the previous row's previous column.
			// This is replacement for dp[i-1][j-1] in two dp;
			// Take first value for i-1 th row.
			int prev = dp[0];
			// If second string is empty, only option is to
			// remove all characters of first string
			dp[0] = i;
			for (int j = 1; j <= n; j++) {
				int t = 0;
				// If last characters are same, ignore last char
				// and recur for remaining string
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					// dp[i][j] = dp[i-1][j-1];
					t = prev;

				// If last character are different, consider all
				// possibilities and find minimum
				else
					t = 1 + min(dp[j - 1], // Insert
							dp[j], // Remove
							prev); // Replace

				prev = dp[j];
				dp[j] = t;
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		GFG gfg = new GFG();
		System.out.println(gfg.minDistance("bat", "boat"));
	}
}