package google.leetcode;

/**
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 
 * @author hbhavsar
 *
 */
public class DecodeString394 {

	private static final int MUL = 10;
	public static void main(String[] args) {
		DecodeString394 d = new DecodeString394();
		String s = "3[a]2[bc]";
		String ans = d.decodeString(s);
		System.out.println(ans);
	}

	public String decodeString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		char[] sc = s.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < s.length(); index++) {
			char c = sc[index];

			if (c >= '0' && c <= '9') {
				int times = c - '0';
				index++;
				c = sc[index];
				while (c != '[' && c >= '0' && c <= '9') {
					times = MUL * times + c - '0';
				}
				int openBracket = 1;
				int subStringStart = index;

				// Handle multiple open brackets.
				while (openBracket > 0) {
					index++;
					c = sc[index];
					if (c == '[') {
						openBracket++;
					}
					if (c == ']') {
						openBracket--;
					}
				}
				
				String subStr = decodeString(s.substring(subStringStart + 1, index));
				while (times > 0) {
					sb.append(subStr);
					times--;
				}

			} else if ((sc[index] >= 'a' && sc[index] <= 'z') || (sc[index] >= 'A' && sc[index] <= 'Z')) {
				sb.append(sc[index]);
			}
		}

		return sb.toString();
	}

}
