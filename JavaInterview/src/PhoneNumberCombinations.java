import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

 * @author hbhavsar
 *
 */
public class PhoneNumberCombinations {
	
//	final static Map<Integer, Character[]> digitMap = new HashMap<>();
	
//	final static Character[][]

	private static final String[] DICTIONARY = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
	};
	
	private static final char[][] CHAR_DICTIONARY = {{'0'}, 
			{'1'},
			{ 'a', 'b', 'c' },
			{ 'd', 'e', 'f' },
			{ 'g', 'h', 'i' },
			{ 'j', 'k', 'l' },
			{ 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' },
			{ 't', 'u', 'v' },
			{ 'w', 'x', 'y', 'z' }};
	
	public static void main(String[] args) {
		
		
		String digits = "23";
		List<String> answer = letterCombinations(digits);
		System.out.println(answer);
	}
	
	
	// Using BFS
	public static List<String> letterCombinations(String digits) {
		
//		Map<Integer, Character[]> digitMap = new HashMap<>();
//		digitMap.put(0, new Character[] {'0'});
//		digitMap.put(1, new Character[] {'1'});
//		digitMap.put(2, new Character[] { 'A', 'B', 'C' });
//		digitMap.put(3, new Character[] { 'D', 'E', 'F' });
//		digitMap.put(4, new Character[] { 'G', 'H', 'I' });
//		digitMap.put(5, new Character[] { 'J', 'K', 'L' });
//		digitMap.put(6, new Character[] { 'M', 'N', 'O' });
//		digitMap.put(7, new Character[] { 'P', 'Q', 'R', 'S' });
//		digitMap.put(8, new Character[] { 'T', 'U', 'V' });
//		digitMap.put(9, new Character[] { 'W', 'X', 'Y', 'Z' });
		
		LinkedList<String> answer = new LinkedList<String>();
		if (digits == null || digits.trim().isEmpty()) {
			return answer;
		}
		answer.add("");
		// loop will terminate when length of the answer will be equal as digits
		while (answer.peek().length() != digits.length()) {
			// This is same as poll, except it throws an exception if no elements are
			// present
			String remove = answer.remove();
//			Character[] letters = digitMap.get(digits.charAt(remove.length()) - '0');
//			Arrays.stream(letters).forEach(c -> {
//				answer.addLast(remove + c);
//			});
			
			// Slower than for loop
//			mapping[digits.charAt(remove.length()) - '0'].codePoints().forEach(c ->{
//				answer.addLast(remove + (char) c);
//			});
			
			String map = DICTIONARY[digits.charAt(remove.length()) - '0'];
			for (char c : map.toCharArray()) {
				answer.addLast(remove + c);
			}
		}
		return answer;
	}
	
	List<String> answer = new ArrayList<>();

	public List<String> letterCombinationsRecurrsion(String digits) {

		if (digits == null || digits.equals("")) {
			return answer;
		}

		digitCombinations(digits, 0, "");

		return answer;
	}

	private void digitCombinations(String digits, int index, String s) {
		if (index == digits.length()) {
			answer.add(s);
			return;
		}

		char current = digits.charAt(index);

		String letters = DICTIONARY[current - '0'];
		for (int i = 0; i < letters.length(); i++) {
			digitCombinations(digits, index + 1, s + letters.charAt(i));
		}

	}
}
