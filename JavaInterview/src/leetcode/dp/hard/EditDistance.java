package leetcode.dp.hard;

public class EditDistance {

	public static void main(String[] args) {

		String word1 = "geek", word2 = "gesek";
		int ans = new EditDistance().minDistance(word1, word2);
		System.out.println(ans);

	}
	
	public int minDistance(String word1, String word2) {
		
		if (word1 == null && word2 == null) {
			return 0;
		}

		if (word1 == null) {
			return word2.length();
		}

		if (word2 == null) {
			return word1.length();
		}
		
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		char[] wc1 = word1.toCharArray();
		char[] wc2 = word2.toCharArray();
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				
				// if word 1 is empty, then we have to add characters equivalent to word 2.
				if (i == 0) {
					dp[i][j] = j;
				}
				
				// if word 2 is empty, then we have to add characters equivalent to word 1.
				else if (j == 0) {
					dp[i][j] = i;
				}
				
				 // If last characters are same, ignore last char 
                // and recur for remaining string 
				else if (wc1[i - 1] == wc2[j - 1]) {
					// as no modification required
					dp[i][j] = dp[i-1][j-1];
				}
				
				// If the last character is different, consider all 
                // possibilities and find the minimum 
				else {
				
					dp[i][j] = 1 + Math.min(dp[i][j-1], // Insert
									Math.min(dp[i - 1][j - 1], // Replace
											dp[i - 1][j])); // Remove
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
	}
}
