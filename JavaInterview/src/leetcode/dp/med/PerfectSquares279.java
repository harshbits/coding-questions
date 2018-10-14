package leetcode.dp.med;

public class PerfectSquares279 {

	
	public static void main(String[] args) {
		int n = 16;
		int ans = new PerfectSquares279().numSquares(n);
		System.out.println(ans);
		
	}
	public int numSquares(int n) {

		if (n < 4) {
			return n;
		}

		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i <= n; i++) {

//			int sq = (int) Math.sqrt(i);
			// As per the Java instructions
			// StrictMath is faster than Math
			//
//			int sq = (int) StrictMath.sqrt(i);
			int min = Integer.MAX_VALUE;
//			while (sq > 0) {
//				min = Math.min(min, dp[i - sq * sq] + 1);
//				--sq;
//			}
			
			int sq = 1;
			
			// multiplication is faster than Square root
			while (i - sq * sq >= 0) {
				min = Math.min(min, dp[i - sq * sq] + 1);
				sq++;
			} 
			
			dp[i] = min;
		}

//		System.out.println(Arrays.toString(dp));

		return dp[n];
	}

//	private void dfs(int[] dp, int i) {
//
//		int sq = (int) Math.sqrt(i);
//		int min = Integer.MAX_VALUE;
//		while (sq > 0) {
//			min = Math.min(min, dp[i - sq * sq] + 1);
//			--sq;
//		}
//		dp[i] = min;
//	}

	// n ans
	// 0 0
	// 1 1
	// 2 2
	// 3 3
	// 4 1
	// 5 2
	// 6 3
	// 7 4
	// 8 2
	// 9 1
	// 10 2
	// 11 3
	// 12 3
	// 13 2
	// 14 3
	// 15 4
	// 16 1

}
