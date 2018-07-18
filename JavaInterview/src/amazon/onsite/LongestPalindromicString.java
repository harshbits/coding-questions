package amazon.onsite;

public class LongestPalindromicString {

	public static void main(String[] args) {
		String s = "babad";
		LongestPalindromicString l = new LongestPalindromicString();
		String ans = l.longestPalindrome(s);
		System.out.println(ans);
	}

	// To support multithreading
	// private int low, maxLen;

	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}

		// use array in order to pass by reference instead of pass by value
		int[] low = new int[1];
		int[] maxLen = new int[1];

		char[] sc = s.toCharArray();
//		for (int i = 0; i < len - 1; i++) {
//			// assume odd length, try to extend Palindrome as possible
//			extendPalindrome(sc, i, i);
//			// assume even length.
//			extendPalindrome(sc, i, i + 1);
//		}
//		return s.substring(low, low + maxLen);
		
		for (int i = 0; i < len - 1; i++) {
			// assume odd length, try to extend Palindrome as possible
			extendPalindrome(sc, i, i, low, maxLen);
			// assume even length.
			extendPalindrome(sc, i, i + 1, low, maxLen);
		}
		return s.substring(low[0], low[0] + maxLen[0]);
	}

	
	private void extendPalindrome(char[] sc, int j, int k, int[] low, int[] maxLen) {
		while (j >= 0 && k < sc.length && sc[j] == sc[k]) {
			j--;
			k++;
		}
		if (maxLen[0] < k - j - 1) {
			maxLen[0] = k - j - 1;
			low[0] = j + 1;
		}
	}
	
	
//	private void extendPalindrome(char[] sc, int j, int k) {
//		while (j >= 0 && k < sc.length && sc[j] == sc[k]) {
//			j--;
//			k++;
//		}
//		if (maxLen < k - j - 1) {
//			maxLen = k - j - 1;
//			low = j + 1;
//		}
//	}

	// private void extendPalindrome(String s, int j, int k) {
	// while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
	// j--;
	// k++;
	// }
	// if (maxLen < j - k - 1) {
	// maxLen = j - k - 1;
	// low = j + 1;
	// }
	// }
}
