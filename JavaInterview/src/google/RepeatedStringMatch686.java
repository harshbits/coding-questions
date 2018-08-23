package google;

/**
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * @author hbhavsar
 *
 */
public class RepeatedStringMatch686 {

	public static void main(String[] args) {
		String A = "abcd";
		String B = "cdabcdab";

		RepeatedStringMatch686 r = new RepeatedStringMatch686();
		int ans = r.repeatedStringMatch(A, B);
		System.out.println("SB: " + ans);
		ans = r.repeatedStringMatchKMP(A, B);
		System.out.println("KMP: " + ans);
	}

	public int repeatedStringMatch(String A, String B) {

		StringBuilder sb = new StringBuilder(A);
		int totalRepeated = 1;
		// if (A == null || B == null) {
		// return 0;
		// }

		// if(A.length() < B.length()) {
		// sb.append(A);
		// totalRepeated++;
		// }
		while (sb.length() < B.length()) {
			sb.append(A);
			totalRepeated++;
		}

		// while (A.indexOf(B) == -1) {
		// A += A;
		// totalRepeated++;
		// }

		while (!sb.toString().contains(B)) {
			sb.append(A);
			totalRepeated++;
		}

		return totalRepeated;
	}

	public int repeatedStringMatchKMP(String A, String B) {
		// get prefix table for pattern (B)
		int[] patArr = computePatternString(B);

		// A is our text
		// and B is our pattern
		int lA = A.length();
		int lB = B.length();
		// i = index for B and j = index for j
		int i = 0, j = 0;
		char[] CA = A.toCharArray();
		char[] CB = B.toCharArray();
		while (j < lA) {

			if (CA[j] == CB[i]) {
				i++;
				j++;
			}

			// if pattern matches it's length
			if (i == lB) {
				return j - i;
			} else if (j < lA && CA[j] != CB[i]) {
				if (i != 0) {
					i = patArr[i - 1];
				} else {
					j++;
				}
			}
		}
		return -1;
	}

	private boolean KMP(String string, String pattern) {

		int[] patArr = computePatternString(pattern);
		int i = 0, j = 0;
		char[] text = string.toCharArray();
		char[] pat = pattern.toCharArray();
		while (i < string.length() && j < pattern.length()) {
			if (text[i] == pat[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = patArr[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length()) {
			return true;
		}
		return false;

	}

	private int[] computePatternString(String pattern) {
		char[] sc = pattern.toCharArray();
		int[] patArr = new int[pattern.length()];
		patArr[0] = 0;
		// int i = 1, j = 0;
		int index = 0;
		for (int i = 1; i < sc.length;) {
			// for(char c: pattern.toCharArray()) {
			if (sc[index] == sc[i]) {
				patArr[i] = index + 1;
				i++;
				index++;
			} else {
				if (index != 0) {
					index = patArr[index - 1];
				} else {
					patArr[i] = 0;
					i++;
				}
			}
		}
		return patArr;
	}

}
