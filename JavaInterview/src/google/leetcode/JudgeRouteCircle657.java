package google.leetcode;

public class JudgeRouteCircle657 {

	private static final char UP = 'U';

	private static final char LEFT = 'L';

	private static final char RIGHT = 'R';

	private static final char DOWN = 'D';

	public static void main(String[] args) {
		JudgeRouteCircle657 j = new JudgeRouteCircle657();
		String moves = "LLLL";
		boolean ans = j.judgeCircle(moves);
		System.out.println(ans);
	}

	public boolean judgeCircle(String moves) {

		// if string is empty, then robot can't move
		if (moves == null || moves.trim().isEmpty()) {
			return true;
		}

		int height = 0;
		int width = 0;
		for (char c : moves.toCharArray()) {
			if (c == UP) {
				height++;
			} else if (c == DOWN) {
				height--;
			} else if (c == LEFT) {
				width--;
			} else if (c == RIGHT) {
				width++;
			}else {
				throw new RuntimeException("Invalid input");
			}
		}
		
		return height == 0 && width == 0;
	}

	
}
