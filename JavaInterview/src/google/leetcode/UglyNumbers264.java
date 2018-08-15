package google.leetcode;

import java.util.Arrays;

public class UglyNumbers264 {

	public static void main(String[] args) {
		int n = 10;
		UglyNumbers264 u = new UglyNumbers264();
		int ans = u.nthUglyNumber(n);
		System.out.println(ans);
	}

	public int nthUglyNumber(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] prime = { 2, 3, 5 };
		return nthUglyNumber(n, prime);
	}

	public int nthUglyNumber(int n, int[] prime) {

		int[] ugly = new int[n];
		ugly[0] = 1;

		int[] mul = Arrays.copyOf(prime, prime.length);
		int[] index = new int[prime.length];

		for (int i = 1; i < n; i++) {
			int min = findMin(mul);
			ugly[i] = min;
			for (int j = 0; j < mul.length; j++) {
				if (mul[j] == min) {
					++index[j];
					mul[j] = ugly[index[j]] * prime[j];
				}
			}
		}

		return ugly[n - 1];
	}

	private int findMin(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

}
