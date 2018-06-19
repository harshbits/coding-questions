package amazon;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * @author hbhavsar
 *
 */
public class ValidAnagram {

	public static void main(String[] args) {
		
	}

	public boolean isAnagram(String s, String t) {

		if(s.length() != t.length()) {
			return false;
		}
		
		// ASCII characters
		// We can use 26 for only letters.
		// 256 => extended ASCII
		int[] ascii = new int[128];
		
		
		// Please note that s.toCharArray(); and then go by index is much faster than
		// s.charAt(i).
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		
		// iterating over String s, and put its value in ascii table
		for (int i = 0; i < sc.length; i++) {
//			ascii[s.charAt(i)]++;
			ascii[sc[i]]++;
		}
		
		for (int i = 0; i < tc.length; i++) {
			// reduce before operation
//			if (--ascii[t.charAt(i)] < 0) {
			if (--ascii[tc[i]] < 0) {
				return false;
			}
		}
		
		return true;

	}


	
}
