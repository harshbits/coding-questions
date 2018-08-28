package google.leetcode;

/**
 * 
 * Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.

Key 2: (Ctrl-A): Select the whole screen.

Key 3: (Ctrl-C): Copy selection to buffer.

Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.

Example 1:
Input: N = 3
Output: 3
Explanation: 
We can at most get 3 A's on screen by pressing following key sequence:
A, A, A
Example 2:
Input: N = 7
Output: 9
Explanation: 
We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
Note:
1 <= N <= 50
Answers will be in the range of 32-bit signed integer.

 * 
 * @author hbhavsar
 *
 */
public class FourKeysKeyboard651 {
	
	public static void main(String[] args) {
		FourKeysKeyboard651 f = new FourKeysKeyboard651();
		int ans = f.maxA(7);
		System.out.println(ans);
		ans = f.maxADP(7);
		System.out.println(ans);
	}

	public int maxA(int N) {
		// We can have at least N 'A'.
		int max = N;

		for (int i = 1; i <= N - 3; i++) {
			max = Math.max(max, maxA(i) * (N - i - 1));
		}
		return max;
	}
	
	// Using DP
	public int maxADP(int N) {
		// We can have at least N 'A'.
		int[] dp = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j <= N - 3; j++) {
				dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
			}
			
		}
		return dp[N];
	}
}
