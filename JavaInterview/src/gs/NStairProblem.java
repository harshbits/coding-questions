package gs;

public class NStairProblem {

	public static int nStairsCount(int n, int k) {
		int[] res = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= k && j <= i; j++) {
				res[i] += res[i - j];
			}
		}
		return res[n - 1];
	}

	public static void main(String[] args) {
		int s = 4, m = 2;
		System.out.println("Nuber of ways = " + nStairsCount(s + 1, m));
	}
}
