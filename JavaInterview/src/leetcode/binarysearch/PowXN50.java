package leetcode.binarysearch;

public class PowXN50 {

	public static void main(String[] args) {

		double ans = new PowXN50().myPow(2.00000, 10);
		System.out.println(ans == 1024.00000);
		System.out.println(ans);

		ans = new PowXN50().myPow(2.10000, 3);
		System.out.println(ans == 9.26100);
		System.out.println(ans);

		ans = new PowXN50().myPow(2.00000, -2);
		System.out.println(ans == 0.25000);
		System.out.println(ans);
		
		
		ans = new PowXN50().myPow(2.00000, -2147483648);
		System.out.println(ans == 0.0);
		System.out.println(ans);

		int x = -2147483648;
		System.out.println(-x);
		
	}

	public double myPow(double x, int n) {

		if (x == 1 || n == 0) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}

		long c = n;
		double x1 = x;
		if (n < 0) {
			c = -n;
//			if(c == n) {
//				return 0;
//			}
			x1 = 1 / x;
		}

		double ans = 1;
		// all values of n
//		while (c < Math.abs(n) - 1) {
//			ans *= x;
//			c++;
//		}

		// Binary Search
		while (c != 0) {
			// if odd number
			if (c % 2 == 1) {
				ans *= x1; 
			}
			x1 *= x1;
			c /= 2;
		}

//		if (n < 0) {
//			return 1 / ans;
//		}

		return ans;
	}

	public double myPowRecursive(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}

		if (n < 0) {
			return myPowRecursive(1 / x, (n + 1) * -1) * 1 / x;
		}

		double half = myPowRecursive(x, n / 2);

		// If even multiply with the calculate half
		// Time => O(log n)
		return n % 2 == 0 ? half * half : half * half * x;
	}
}
