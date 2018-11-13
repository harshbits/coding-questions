package leetcode.binarysearch;

import java.util.Random;

public class RandomPickwithWeight528 {

	
	public static void main(String[] args) {
		int[] w = { 1, 3 };
		RandomPickwithWeight528 r = new RandomPickwithWeight528(w);
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
		System.out.println(r.pickIndex());
	}
	
	
	private int[] summedW;
//	private int total;
	private Random random;
	
	public RandomPickwithWeight528(int[] w) {
		if (w == null || w.length == 0) {
			return;
		}
		summedW = new int[w.length];
		summedW[0] = w[0];
		for (int i = 1; i < w.length; i++) {
//			total += w[i];
//			summedW[i] = total;
			summedW[i] = summedW[i-1] + w[i];
		}
		random = new Random();
	}

	// Pick Index Proportional to weight
	public int pickIndex() {
		// Random number below total weight
//		int randomIndex = random.nextInt(total);
		
		int randomIndex = random.nextInt(summedW[summedW.length - 1]) + 1;

		int start = 0, end = summedW.length - 1;
//		int start = -1, end = summedW.length - 1;
		while (start < end) {
//			int mid = start + (end - start + 1) / 2;
			int mid = start + (end - start) / 2;
			if(summedW[mid] == randomIndex) {
				return mid;
			}
			if (summedW[mid] < randomIndex) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return start;
	}
}

