package google.leetcode;

public class CountNumberOfUniqueDigits357 {

	public static void main(String[] args) {
		int n = 2;
		CountNumberOfUniqueDigits357 c = new CountNumberOfUniqueDigits357();
		int ans = c.countNumbersWithUniqueDigits(n);
		System.out.println(ans);
		
		ans = c.countNumbersWithUniqueDigitsRecursive(2);
		System.out.println(ans);
	}

	// Using DP
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		
		int result = 10;
		int uniqueDigits = 9;
		int availNumber = 9;
		
		while (n-- > 1 && availNumber > 0) {
			uniqueDigits = uniqueDigits * availNumber;
			result += uniqueDigits;
			availNumber--;
		}

		return result;
	}

	// Using Recursion
	public int countNumbersWithUniqueDigitsRecursive(int n) {

		if (n == 0) {
			return 1;
		}

		// As there are no unique digits after n ^ 10
		if (n > 10) {
			countNumbersWithUniqueDigitsRecursive(10);
		}

		int sum = 1;
		int k = 0;
		while (k < n) {
			if (k == 0) {
				sum *= 9;
			}else {
				sum *= (10 - k);
			}
			k++;
		}

		return sum + countNumbersWithUniqueDigitsRecursive(n - 1);
	}
}
