package leetcode.uber;

public class SolveTheEquation640 {

	public static void main(String[] args) {

		String input = "x+5-3+x=6+x-2";
		var ans = new SolveTheEquation640().solveEquation(input);
		System.out.println(ans);
		
	}
	
	private static final String INF_SOL = "Infinite solutions";
	
	private static final String NO_SOL = "No solution";
	
	public String solveEquation(String equation) {

		String[] sides = equation.split("=");

		// int[0] = coefficient
		// int[1] = number
		int[] supportVar = new int[2];

		// left side solve
		equationHelper(sides[0], true, supportVar);

		// right side solve
		equationHelper(sides[1], false, supportVar);

		// if both coefficient and number is 0 then there is infinite solutions
		if(supportVar[0] == 0 && supportVar[1] == 0) {
			return INF_SOL;
		}
		
		// if coefficient is 0, then there is no x present or both side x has the same value.
		if (supportVar[0] == 0) {
			return NO_SOL;
		}
		
//		return "x=" + (supportVar[1] * -1) / supportVar[0];
		StringBuilder sb = new StringBuilder("x=");
		
		// we processed number => supportVar[1] as right hand side value,
		// hence we are multiplying with -1.
		// coefficient value is supportVar[0[, which is supported to be devided by 
		sb.append(((supportVar[1] * -1) / supportVar[0]));
		return sb.toString();
	}

	// L = x + 5 - 3 + x
	// R = 6 + x - 2
	private void equationHelper(String equation, boolean isLeftSide, int[] supportVar) {

		// Initial sign based on the side of equation
		// + = left side
		// - = right side
		int sign = isLeftSide ? 1 : -1;

		char[] sc = equation.toCharArray();

		for (int i = 0; i < sc.length; i++) {

			switch (sc[i]) {

			// Determine sign of the number based on the which side of the equation it is
			case '+':
				sign = isLeftSide ? 1 : -1;
				break;

			// Determine sign of the number based on the which side of the equation it is
			case '-':
				sign = isLeftSide ? -1 : 1;
				break;

			// coefficient of x
			case 'x':
				supportVar[0] += sign * 1;
				break;

			default:

				int index = i;
				// to get the multi-digit number
				while (i != sc.length && Character.isDigit(sc[i])) {
					++i;
				}

				// if not x, increase number ( do not confuse number with index)
				if (i == sc.length || sc[i] != 'x') {
					supportVar[1] += sign * Integer.parseInt(equation.substring(index, i));
					// decrease i
					--i;
				}
				// increase coefficient value
				else {
					supportVar[0] += sign * Integer.parseInt(equation.substring(index, i));
				}
			}
		}
	}
}
