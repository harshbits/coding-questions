package leetcode;

//Given an input string, reverse the string word by word.
//
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//

public class ReverseWordsString {

	public static void main(String[] args) {

		// String s = "the sky is blue";
		String s = "   a   b ";
		ReverseWordsString r = new ReverseWordsString();
		String ans = r.reverseWords(s);

		System.out.println(ans);
	}
	
	public String reverseWords(String str) {
		int space = 0;
		int beginWord = -1;
		int size = str.length();
		int last = 0;
		if (size == 0) {
			return "";
		}
		char[] s = str.toCharArray();
		for (int idx = 0; idx <= size; ++idx) {
			// if reached a space or the end of string, we may need a reverse
			if (idx == size || s[idx] == ' ') {
				if (beginWord != -1) {
					// start is the real idx where we begin to reverse
					int start = beginWord - space;
					// when start is not 0, we need to reduce the space by 1 to remain a space
					// between words
					// start == 0 means we are processing the first word in the string
					// we do not need to remain a space before that word, otherwise, there will be a
					// tailing space in the final answer
					if (start != 0) {
						++start;
						--space;
					}
					reverse(s, start, idx - 1);
					last = idx - space;
					space += 1;
					beginWord = -1;
				} else {
					++space;
				}
			} else {
				if (beginWord == -1) {
					beginWord = idx;
				}
			}
		}
		s[last] = '\0';
		reverse(s, 0, last - 1);
		return String.valueOf(s);
	}

	/**
	 * reverse string
	 * 
	 * @param s
	 * @param begin
	 * @param end
	 */
	void reverse(char[] s, int begin, int end) {
		while (begin < end) {
			char c = s[begin];
			s[begin++] = s[end];
			s[end--] = c;
		}
	}
	
	
	
	
	
	
	public static String reverseWords2(String s) {
		if (s == null || s.trim().equals("")) {
			return s.trim();
		}

		String[] arr = s.split(" ");
		int len = arr.length;
		StringBuilder buffer = new StringBuilder();
		int count = 0;
		for (String s1 : arr) {
			s1 = s1.replace(" ", "");
			s1 = s1.trim();
			if (s1.equals("")) {
				continue;
			}
			StringBuilder temp = new StringBuilder(s1);

			buffer.append(temp.reverse());
			buffer.append(" ");
		}

		int index = buffer.toString().lastIndexOf(" ");
		buffer.replace(index, buffer.length(), "");
		return buffer.reverse().toString();

	}

	public static String reverseWords1(String s) {

		String answer = "";
		if (s != null && s.trim().length() > 0) {
			String currentWord = "";
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == ' ' && currentWord.length() > 0) {
					answer = currentWord + " " + answer;
					currentWord = "";
				} else if (c != ' ') {
					currentWord = currentWord + Character.toString(c);
				}
				if (i == s.length() - 1) {
					answer = currentWord + " " + answer;
				}
			}
		}

		return answer.trim();
	}

}
