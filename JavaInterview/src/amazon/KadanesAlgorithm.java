package amazon;

import java.util.Arrays;

// Sum of maximum sub array
public class KadanesAlgorithm {
	
	int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int ans = maxSubArray(A);
		System.out.println(ans);
		
		int ans2 = new KadanesAlgorithm().maxSub(0);
		System.out.println(ans2);
		
		var range = maxSubArrayRange(A);
		System.out.println(Arrays.toString(range));
		
		
//		//1110110
//		//0001111
//		//---------
//		//0000110
//		
//		System.out.println(Integer.toBinaryString(118));
//		System.out.println(Integer.toBinaryString(15));
//		
//		System.out.println(118 & 15);
	}


	public static int[] maxSubArrayRange(int[] A) {

		if (A == null || A.length == 0) {
			return new int[0];
		}
		int n = A.length;
		int max = A[0];
		int newSum = A[0];

		int[] range = new int[2];

		for (int i = 1; i < n; i++) {

			newSum += A[i];

			if (newSum > max) {
				max = newSum;
				range[1] = i;
			}

			if (newSum < 0) {
				newSum = 0;
				range[0] = i;
			}
		}

		return range;
	}
	
	
	public static int maxSubArray(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int n = A.length;
		int max = A[0];
		int newSum = A[0];
		
		// If we have to return an array instead of Sum
//		int startIndex = 0;
//		int endIndex = 0;

		for (int i = 1; i < n; i++) {
			newSum = Math.max(newSum + A[i], A[i]);
			max = Math.max(max, newSum);
//			if (max == A[i]) {
//				startIndex = i;
//			} else if (max == newSum) {
//				endIndex = i;
//			}
		}
		
//		int[] answerA = Arrays.copyOfRange(A, startIndex, endIndex + 1);
//		System.out.println(Arrays.toString(answerA));
		return max;
	}
	
	int maxSub(int pos) {
		if (pos == 0)
			return a[0];
		else {
			return Math.max(maxSub(pos - 1) + a[pos], a[pos]);
		}
	}

}
