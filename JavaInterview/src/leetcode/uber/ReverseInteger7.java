package leetcode.uber;

/**
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 * @author habhavsar
 *
 */
public class ReverseInteger7 {

	public static void main(String[] args) {

		var x = 123;
		var ans = new ReverseInteger7().reverse(x);
		System.out.println(ans);

	}

	// 123 -> 321
	// pop:
	public int reverse(int x) {

		int reverse = 0;

		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			// if reverse > Integer.MAX_VALUE / 10, then reverse = reverse * 10 + pop, will
			// result into overflow
			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}

			// if reverse < Integer.MAX_VALUE / 10, then reverse = reverse * 10 + pop, will
			// result into overflow
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}

			reverse = reverse * 10 + pop;
		}
		return reverse;
	}

}
