package google.terry;


/**
 * 
 * 
 * We have to paint n boards of length {A1, A2…An}. There are k painters available and each takes 1 unit time to paint 1 unit of board. The problem is to find the minimum time to get
this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Examples:

Input : k = 2, A = {10, 10, 10, 10} 
Output : 20.
Here we can divide the boards into 2
equal sized partitions, so each painter 
gets 20 units of board and the total
time taken is 20. 

Input : k = 2, A = {10, 20, 30, 40} 
Output : 60.
Here we can divide first 3 boards for
one painter and the last board for 
second painter.
 * 
 * @author hbhavsar
 *
 *
 * @see Leeetcode 
 * 
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 */
public class ThepainterPartitionProblem410 {

	public static void main(String[] args) {
		ThepainterPartitionProblem410 t = new ThepainterPartitionProblem410();
		int k = 2;
		int[] A = { 10, 20, 30, 40 };
		System.out.println(t.findMax(A, A.length, k));
	}
	
	
	/**
	 * 
	 * 
	 * @param arr  = boards and time requires to paint
	 * @param n = size of the board
	 * @param k = number of painters
	 * 
	 * @return, minimum time requires to paint the board
	 * 
	 */
	public int findMax(int arr[], int n, int k) {
		
		int improvedDP[] = new int[n];
		int[] sum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + arr[i];
			improvedDP[i] = sum[i + 1];
		}
		
		// initialize dp
		int dp[][] = new int[k + 1][n + 1];
		
		// second row, all column values
		for (int i = 1; i <= n; i++) {
			dp[1][i] = sum(arr, 0, i - 1);
			
		}
		// first column, all row values
		for (int i = 1; i <= k; i++) {
			dp[i][1] = arr[0];
		}
		
	
		

		// rows = painter count
//		for (int i = 2; i <= k; i++) {
//			// columns = board paint time required
//			for (int j = 2; j <= n; j++) {
//		
//				int best = Integer.MAX_VALUE;
//				
//				int best1 = Integer.MAX_VALUE;
//				
//				for (int p = 1; p <= j; p++) {
//					
//					best = Math.min(best, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));
//					
////					best1 = Math.min(best1, Math.max(improvedDP[p - 1], sum(arr, p, j - 1)));
//
//				}
//				dp[i][j] = best;
////				improvedDP[i] = best1;
//			}
//		}
//		return dp[k][n];
		
		// starting from next painter
		for (int p = 1; p < k; p++) {
			int[] next = new int[n];
			for (int i = 0; i < n; i++) {
				int best = Integer.MAX_VALUE;
				for (int j = i - 1; j >= 0; j--) {
					best = Math.min(best, Math.max(improvedDP[j], sum[i + 1] - sum[j + 1]));
				}
				next[i] = best;
			}
			
			// assign next to dp
			improvedDP = next;
		}
		
		return improvedDP[n - 1];
	}
	
	private int sum(int arr[], int from, int to) {
		int total = 0;
		for (int i = from; i <= to; i++)
			total += arr[i];
		return total;
	}

}
