package google.leetcode;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 * 
 * @author hbhavsar
 *
 */
public class ValidPalindrome125 {
	
	public static void main(String[] args) {
		ValidPalindrome125 v = new ValidPalindrome125();
		boolean ans = v.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(ans);
	}
	
	public boolean isPalindrome(String s) {

		char[] sc = s.toLowerCase().toCharArray();
		int i = 0;
		int j = sc.length - 1;
		
		while(i < j) {
			while (i < j && !isAlphaNumeric(sc[i])) {
				i++;
			}

			while (i < j && !isAlphaNumeric(sc[j])) {
				j--;
			}
			
			if (i >= j) {
				return true;
			}
			if(!isMatch(sc[i], sc[j])) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;
	}
	
	private boolean isMatch(char a, char b) {
		// System.out.println(c1);
		// System.out.println(c2);
		// return Character.toLowerCase(c1) == Character.toLowerCase(c2);
		if (a == b)
			return true;
		if (a >= '0' && a <= '9')
			return false;
		if (b >= '0' && b <= '9')
			return false;
		if (a - b != 32 && b - a != 32)
			return false;
		return true;
		
//		System.out.println(a);
//		System.out.println(b);
//		return Character.toLowerCase(a) == Character.toLowerCase(b);
	}
	
	private boolean isAlphaNumeric(char c) {
		// return Character.isDigit(c) || Character.isLetter(c);
		if (c >= 'a' && c <= 'z')
			return true;
		if (c >= 'A' && c <= 'Z')
			return true;
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}

}
