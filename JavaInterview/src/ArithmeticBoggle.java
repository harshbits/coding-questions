import java.util.ArrayList;
import java.util.List;

public class ArithmeticBoggle {

	public static void main(String[] args) {
//		var numbers = List.of(1, 3, 6, 9, 5, 5);
//		var magicNumber = 19;
//		var ans = new ArithmeticBoggle().arithmeticBoggle(magicNumber, numbers);
//		System.out.println(ans);
//
//		numbers = List.of();
//		magicNumber = 0;
//		ans = new ArithmeticBoggle().arithmeticBoggle(magicNumber, numbers);
//		System.out.println(ans);
//
//		numbers = List.of();
//		magicNumber = 43;
//		ans = new ArithmeticBoggle().arithmeticBoggle(magicNumber, numbers);
//		System.out.println(ans);
//
//		numbers = List.of(42);
//		magicNumber = 42;
//		ans = new ArithmeticBoggle().arithmeticBoggle(magicNumber, numbers);
//		System.out.println(ans);
//
//		numbers = List.of(99);
//		magicNumber = 0;
//		ans = new ArithmeticBoggle().arithmeticBoggle(magicNumber, numbers);
//		System.out.println(ans);
		
		var numbers = List.of(1, 1, 1, 1, 1);
		var magicNumber = 3;
		var ans = new ArithmeticBoggle().arithmeticBoggleTotalWays(magicNumber, numbers);
		System.out.println(ans);
	}

	/**
	 * +ve = values which are supposed to be added -ve = values which are supposed
	 * to be subtracted
	 * 
	 * -- Answer Target = SUM (+ve) - SUM (-ve)
	 * 
	 * -- Add sum both sides SUM (+ve) + SUM (-ve) + Target = SUM (+ve) - SUM (-ve)
	 * + SUM (+ve) + SUM (-ve)
	 * 
	 * -- SUM (ALL) + Target = 2 * SUM (+ve)
	 * 
	 * SUM (+ve) = (SUM (ALL) + Target) /2
	 * 
	 * 
	 * @param magicNumber
	 * @param numbers
	 * 
	 * @return whether we can achieve our magic number
	 */
	public boolean arithmeticBoggle(int magicNumber, List<Integer> numbers) {

		// Sum of all numbers
		int sumAll = numbers.stream().reduce(0, Integer::sum);

		// Please refer comment for this logic
		// SUM (+ve) = (SUM (ALL) + Target) /2
		// So if doing module has some reminder, which means there is no way we can get
		// to the final answer

//		return (sumAll < magicNumber || (magicNumber + sumAll) % 2 > 0 ? false : true;
		return !(sumAll < magicNumber || (magicNumber + sumAll) % 2 > 0);
	}

	/**
	 * +ve = values which are supposed to be added -ve = values which are supposed
	 * to be subtracted
	 * 
	 * -- Answer Target = SUM (+ve) - SUM (-ve)
	 * 
	 * -- Add sum both sides SUM (+ve) + SUM (-ve) + Target = SUM (+ve) - SUM (-ve)
	 * + SUM (+ve) + SUM (-ve)
	 * 
	 * -- SUM (ALL) + Target = 2 * SUM (+ve)
	 * 
	 * SUM (+ve) = (SUM (ALL) + Target) /2
	 * 
	 * 
	 * @param magicNumber
	 * @param numbers
	 * 
	 * @return whether we can achieve our magic number
	 */
	public boolean arithmeticBoggle(int magicNumber, ArrayList<Integer> numbers) {

		// Sum of all numbers
		int sumAll = numbers.stream().reduce(0, Integer::sum);

		// Please refer comment for this logic
		// SUM (+ve) = (SUM (ALL) + Target) /2
		// So if doing module has some reminder, which means there is no way we can get
		// to the final answer

//		return (sumAll < magicNumber || (magicNumber + sumAll) % 2 > 0 ? false : true;
		return !(sumAll < magicNumber || (magicNumber + sumAll) % 2 > 0);
	}

	public int arithmeticBoggleTotalWays(int magicNumber, List<Integer> numbers) {

		// Sum of all numbers
		int sumAll = numbers.stream().reduce(0, Integer::sum);

		// Please refer comment for this logic
		// SUM (+ve) = (SUM (ALL) + Target) /2
		// So if doing module has some reminder, which means there is no way we can get
		// to the final answer

		return sumAll < magicNumber || (magicNumber + sumAll) % 2 > 0 ? 0
				: arithmeticBoggleTotalWaysDP((magicNumber + sumAll) / 2, numbers);
	}

	private int arithmeticBoggleTotalWaysDP(int magicNumber, List<Integer> numbers) {

		int[] dp = new int[magicNumber + 1];
		// At least one solution is available, assuming we had validation earlier.
		dp[0] = 1;

		for (int n : numbers) {
			for (int i = magicNumber; i >= n; i--) {
				dp[i] += dp[i - n];
			}

		}

		return dp[magicNumber];
	}

}
