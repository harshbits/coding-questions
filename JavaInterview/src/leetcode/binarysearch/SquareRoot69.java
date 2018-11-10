package leetcode.binarysearch;

/**
 * 
 * Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

 * @author habhavsar
 *
 */
public class SquareRoot69 {

	public static void main(String[] args) {

		int x = 10;
		int ans = new SquareRoot69().mySqrt(x);
		System.out.println(ans);
	}

	public int mySqrt(int x) {

		if (x == 0) {
			return x;
		}

		int start = 1;
		int end = x;
		while (true) {
			int mid = start + (end - start) / 2;
			if (mid > x / mid) {
				end = mid - 1;
			} else if (mid + 1 > x / (mid + 1)) {
				return mid;
			} else {
				start = mid + 1;
			}
		}
	}

}
