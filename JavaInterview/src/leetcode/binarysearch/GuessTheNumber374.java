package leetcode.binarysearch;

public class GuessTheNumber374 extends GuessGame {

	int pick;

	public GuessTheNumber374(int pick) {
		this.pick = pick;
	}

	public static void main(String[] args) {

		int pick = 6;
		int n = 10;
		GuessTheNumber374 g = new GuessTheNumber374(pick);
		g.setPick(pick);
		int ans = g.guessNumber(n);
		System.out.println(ans);

	}

	public int guessNumber(int n) {

		int start = 1;
		int high = n;

		while (start < high) {
			int mid = start + (high - start) / 2;
			int num = guess(mid);
			if (num == 0) {
				return mid;
			} else if (num == -1) {
				high = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;

	}

}

class GuessGame {
	int pick;

	public void setPick(int pick) {
		this.pick = pick;
	}

	public int guess(int n) {

		if (n == pick) {
			return n;
		} else if (n < pick) {
			return -1;
		} else {
			return 1;
		}
	}
}