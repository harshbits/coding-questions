package givenbyfriend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 
 * 
 * @author habhavsar
 * 
 * given by Kasi Kikkisetti
 *
 */
public class KeypadCombination {

	private Map<Integer, char[]> keypad = new HashMap<>();

	public KeypadCombination() {
		keypad.put(0, new char[] { '0' });
		keypad.put(1, new char[] { '1' });
		keypad.put(2, new char[] { 'a', 'b', 'c' });
		keypad.put(3, new char[] { 'd', 'e', 'f' });
		keypad.put(4, new char[] { 'g', 'h', 'i' });
		keypad.put(5, new char[] { 'j', 'k', 'l' });
		keypad.put(6, new char[] { 'm', 'n', 'o' });
		keypad.put(7, new char[] { 'p', 'q', 'r', 's' });
		keypad.put(8, new char[] { 't', 'u', 'v' });
		keypad.put(9, new char[] { 'w', 'x', 'y', 'z' });
	}

	public static void main(String[] args) {

		int[] input1 = { 1, 3, 5, 8 };
		String input = "1358";

		int[] input2 = { 1, 3, 3, 6, 5, 8 };
		String input22 = "@132658";
		
		
		
		
		KeypadCombination k = new KeypadCombination();

		List<String> ans = k.keyPadCombinations(input2);
		System.out.println(ans.size());
		System.out.println(ans);
		ans = k.keyPadCombinations(input22);
		System.out.println(ans.size());
		System.out.println(ans);

		
	}
	
	
	public List<String> keyPadCombinations(String digits) {
		
		List<String> ans = new ArrayList<>();
		
		// Approach 1.
		// Calculate all combination, and start with for loop
		
		// Approach 2.
		// Reccurssion
//		
//		for (int i : input) {
//			
//			
//		}
		if(digits != null && digits.trim().length() > 0) {
			helper(ans, digits, "");
		}

		return ans;
	}


	public List<String> keyPadCombinations(int[] digits) {

		List<String> ans = new ArrayList<>();

		// Approach 1.
		// Calculate all combination, and start with for loop

		// Approach 2.
		// Reccurssion
		//
		// for (int i : input) {
		//
		//
		// }

		// Approach 3.
		// Iterative using Queue (BFS)
		if (digits !=null && digits.length > 0) {
			helper(ans, digits, "", 0);
		}

		return ans;
	}

	private void helper(List<String> ans, int[] digits, String s, int index) {
		// Once all digits are done
		if (digits.length == index) {
			ans.add(s);
			// terminate loop
			return;
		}
		for (char c : keypad.get(digits[index])) {
			// truncte the string
			helper(ans, digits, s + c, index + 1);
		}
	}


	private void helper(List<String> ans, String digits, String s) {

		// Once all digits are done
		if (digits.length() == 0) {
			ans.add(s);
			// terminate loop
			return;
		}
		int id = Integer.parseInt(digits.substring(0, 1));
		char[] ca = keypad.get(id);

		for (char c : ca) {
			// truncte the string
			helper(ans, digits.substring(1, digits.length()), s + c);
		}

	}


}
