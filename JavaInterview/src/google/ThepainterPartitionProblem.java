package google;


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
 */
public class ThepainterPartitionProblem {

	public static void main(String[] args) {
		ThepainterPartitionProblem t = new ThepainterPartitionProblem();
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
		
		return 0;
		
	}
	
	private int sum(int arr[], int from, int to) {
		int total = 0;
		for (int i = from; i <= to; i++)
			total += arr[i];
		return total;
	}

}
