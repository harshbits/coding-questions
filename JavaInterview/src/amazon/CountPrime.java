package amazon;

/**
 * Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 * @author hbhavsar
 *
 */
public class CountPrime {
	
	public static void main(String[] args) {
		int ans = new CountPrime().countPrimes(10);
		System.out.println(ans);
	}
	
	
	// Sieve of Eratosthenes
	public int countPrimes(int n) {
		
//		if (n == 1) {
//			return 0;
//		}
//		if (n == 2) {
//			return 0;
//		}
		
		if (n < 3) {
			return 0;
		}

//		int totalPrime = 0;
		
//		for (int i = 2; i < n; i++) {
//			if (isPrime(i)) {
//				totalPrime++;
//			}
//		}
		int totalPrime = n / 2;
		
		boolean[] notPrime = new boolean[n];
		
//		for(int i=0;i<n;i++)
//			notPrime[i] = true;
		
		// This logic is written based on Sieve of Eratosthenes
		for (int i = 3; i * i < n; i += 2) {
			if(notPrime[i]) {
				continue;
			}
			
			for (int j = i * i; j < n; j += 2 * i) {
				if (!notPrime[j]) {
					--totalPrime;
					notPrime[j] = true;
				}
			}
		}
		
		return totalPrime;
	}
    

    boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
    
}
