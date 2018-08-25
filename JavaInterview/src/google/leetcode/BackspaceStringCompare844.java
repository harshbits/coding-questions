package google.leetcode;

public class BackspaceStringCompare844 {

	public static void main(String[] args) {
		// String S = "ab#c";
		// String T = "ad#c";

		// String S = "a##c", T = "#a#c";

		String S = "ab##", T = "c#d#";
		BackspaceStringCompare844 b = new BackspaceStringCompare844();
		boolean ans = b.backspaceCompare(S, T);
		System.out.println(ans);
	}

	private static final char BACK_SPACE = '#';

	private static final String BACK_SPACE_STRING = "#";

	public boolean backspaceCompare(String S, String T) {

		S = applyBackSpace(S);
		T = applyBackSpace(T);
		System.out.println(S);
		System.out.println(T);
		return S.equals(T);
	}

	private String applyBackSpace(String S) {

		StringBuilder sb = new StringBuilder();
		for (char c : S.toCharArray()) {
			if (c != BACK_SPACE) {
				sb.append(c);
			} else if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return sb.toString();
	}

	// private String applyBackSpace(String S) {
	// StringBuilder SB = new StringBuilder();
	// char[] SC = S.toCharArray();
	//
	// for (int i = SC.length - 1; i >= 0; i--) {
	// char c = SC[i];
	// if (c == BACK_SPACE) {
	// if (i > 0) {
	// if (SC[i - 1] != BACK_SPACE) {
	// i--;
	// }
	// }
	// } else {
	// SB.append(c);
	// }
	// }
	// return SB.reverse().toString();
	// }
}
