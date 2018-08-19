package google.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a C++ program, remove comments from it. The program source is an array where source[i] is the i-th line of the source code. This represents the result of splitting the original source code string by the newline character \n.

In C++, there are two types of comments, line comments, and block comments.

The string // denotes a line comment, which represents that it and rest of the characters to the right of it in the same line should be ignored.

The string /* denotes a block comment, which represents that all characters until the next (non-overlapping) occurrence of should be ignored. (Here, occurrences happen in reading order: line by line from left to right.) To be clear, the string 
does not yet end the block comment, as the ending would be overlapping the beginning.

The first effective comment takes precedence over others: if the string // occurs in a block comment, it is ignored. Similarly, if the string /* occurs in a line or block comment, it is also ignored.

If a certain line of code is empty after removing comments, you must not output that line: each string in the answer list will be non-empty.

There will be no control characters, single quote, or double quote characters. For example, source = "string s = "/* Not a comment.  will not be a test case. (Also, nothing else such as defines or macros will interfere with the comments.)

It is guaranteed that every open block comment will eventually be closed, so /* outside of a line or block comment always starts a new comment.

Finally, implicit newline characters can be deleted by block comments. Please see the examples below for details.

After removing the comments from the source code, return the source code in the same format.
 * 
 * @author hbhavsar
 *
 */
public class RemoveComments722 {
	
	public static void main(String[] args) {
		String[] source = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		RemoveComments722 r = new RemoveComments722();
		List<String> ans = r.removeComments(source);
		System.out.println(ans);
		
	}
	
	
	public List<String> removeComments(String[] source) {

		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean commentMode = false;
		for (String s : source) {
//		for (int j = 0; j<source.length; j++) {
//			String s = source[j];
			char[] sc = s.toCharArray();
			for (int i = 0; i < sc.length; i++) {

				if (commentMode) {
					if (sc[i] == '*' && i < s.length() - 1 && sc[i + 1] == '/') {
						commentMode = false;
						// skip '/' on next iteration of i
						i++;
					}
				}

				else {
					// If we see '//' we stop reading the current line, and add whatever characters
					// we have seen to the result.
					if (sc[i] == '/' && i < sc.length - 1 && sc[i + 1] == '/') {
						// ignore remaining characters on line s
						break;
					} else if (sc[i] == '/' && i < sc.length - 1 && sc[i + 1] == '*') {
						commentMode = true;
						// skip '*' on next iteration of i
						i++;
					} else {
						sb.append(s.charAt(i));
					}
				}
			}
			// We can achieve in place, by resizing the array all the time
			if (!commentMode && sb.length() > 0) {
				ans.add(sb.toString());
//				source[j] = sb.toString();
				sb = new StringBuilder(); // reset for next line of source code
			}
			// not recommended
//			else{
//				source[j] = null;
//			}
		}
		
		return ans;
//		return Arrays.asList(source);
	}
	
	public List<String> removeCommentsRegex(String[] source) {
		List<String> ans = new ArrayList<>();
		
		
		return ans;
	}

}
