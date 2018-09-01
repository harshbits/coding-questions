package google.leetcode;

/**
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 * 
 * @author hbhavsar
 *
 */
public class ValidPalindromII680 {

	
	public static void main(String[] args) {
		String s = "abcad";
		ValidPalindromII680 v = new ValidPalindromII680();
		boolean ans = v.validPalindrome(s);
		System.out.println(ans);
		
	}
	
	
	public boolean validPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		
		int left = -1;
		int right = s.length();
		char[] sc = s.toCharArray();
		
		while (++left < right--) {
			if (sc[left] != sc[right]) {
				// delete from left or right and check, if it's palindrome
				return isPalindrome(sc, left - 1, right) || isPalindrome(sc, left, right + 1);
			}
		}
		
		return true;
	}
	
	
	public boolean isPalindrome(char[] sc, int left, int right) {
		while (++left < right--) {
			if (sc[left] != sc[right]) {
				return false;
			}
		}
		return true;
	}

}
