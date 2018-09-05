package google.leetcode;

/**
 * 
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc" Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb" Seen this question in a real interview
 * before?
 * 
 * @author hbhavsar
 *
 */
public class RemoveDuplicateLetters316 {
	
	
	public static void main(String[] args) {
		RemoveDuplicateLetters316 r = new RemoveDuplicateLetters316();
		String s = "cbacdcbc";
		// 1. find out the last appeared position for each letter;
		// c - 7
		// b - 6
		// a - 2
		// d - 4
		// 2. find out the smallest index from the map in step 1 (a - 2);
		// 3. the first letter in the final result must be the smallest letter from index 0
		// to index 2;
		// 4. repeat step 2 to 3 to find out remaining letters.
		// the smallest letter from index 0 to index 2: a
		// the smallest letter from index 3 to index 4: c
		// the smallest letter from index 4 to index 4: d
		// the smallest letter from index 5 to index 6: b
		String ans = r.removeDuplicateLetters(s);
		System.out.println(ans);
	}

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int[] cnt = new int[26];
		char[] sc = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			cnt[sc[i] - 'a']++;
		}

		// Instead of going entire cnt[26],
		// we will just go through the string.
		int pos = 0; // the position for the smallest s[i]
		for (int i = 0; i < s.length(); i++) {
			if (sc[i] < sc[pos]) {
				pos = i;
			}

			if (--cnt[sc[i] - 'a'] == 0) {
				break;
			}
		}

		return sc[pos] + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}
}
