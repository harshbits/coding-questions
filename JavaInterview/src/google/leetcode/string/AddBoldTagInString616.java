package google.leetcode.string;

/**
 * 
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].

 * 
 * @author hbhavsar
 *
 */
public class AddBoldTagInString616 {

	
	public static void main(String[] args) {
		String s = "abcxyz123";
		String[] dict = { "abc", "123" };
		
		AddBoldTagInString616 a = new AddBoldTagInString616();
		String ans = a.addBoldTag(s, dict);
		System.out.println(ans);
	}
	
	
	public String addBoldTag(String s, String[] dict) {
		
		if (s == null || s.isEmpty() || dict == null || dict.length == 0) {
			return s;
		}
		
		// we can make it faster by for each loop
//		Set<String> dictSet = new HashSet<>(Arrays.asList(dict));
		// Keep track of index of string, whether it is part of bold or not.
		boolean[] bold = new boolean[s.length()];
		
		char[] sc = s.toCharArray();
		
//		int boldTagStart = -1;
//		int boldTagEnd = 0;
		
		for (String word : dict) {
			// start index of bold tag.
			// <b>
			int start = 0;
			while (start >= 0) {
				
				start = s.indexOf(word, start);
				// if word not found in the dictionary
				// return -1, and stop the while loop
				if (start < 0) {
					break;
				}
				// define end index of the bold tag
				// </b>
				int end = start + word.length();
				
				for (int i = start; i < end; i++) {
					// mark index of string as part of bold tag
					bold[i] = true;
				}
				// increment starting index.
				start++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			// if character is bold
			// and 
			// index is less than zero or last index is not bold.
			// then add starting bold tag
			if (bold[i] && (i - 1 < 0 || !bold[i - 1])) {
				sb.append("<b>");
			}
			sb.append(sc[i]);
			
			// is current character is bold,
			// and
			// index is equal to length of the string, 
			// or next index is not bold.
			// then add closing bold tag
			if(bold[i] && (i+1 == s.length() || !bold[i+1])) {
				sb.append("</b>");
			}
		}

		return sb.toString();
	}
}
