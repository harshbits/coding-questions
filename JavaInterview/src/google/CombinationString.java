package google;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//A string consists of ‘0’, ‘1’ and '?'. 
//The question mark can be either '0' or '1'. 
//Find all possible combinations for a string.
public class CombinationString {

	// Not thread safe
	// static List<String> combinations = new ArrayList<>();

	public static void main(String[] args) {
		String input = "1??0?101";

		// String input = "????????????";
		List<String> combinations = combinations(input);

		combinations.stream().forEach(System.out::println);
		
	}

	// Method to handle thread safe
	public static List<String> combinations(String str) {

		// Check 1
		if (str == null || str.trim().length() == 0) {
			return new ArrayList<>();
		}

		// Check 2, if any invalid characters present
		if (!Pattern.matches("[01?]+", str)) {
			throw new RuntimeException("Input String contains invalid characters");
		}

		// Thread safe
		List<String> combinations = new ArrayList<>();

		// Convert to array
		char[] chr = str.toCharArray();
		int length = chr.length;
		print(chr, 0, length, combinations);
		return combinations;
	}

	// Time complexity O(2^N) = Exponential.
	// If there are no ?, then it will be O(N)
	// Can be considered as SUPER RECURRSION EXAMPLE
	public static void print(char[] str, int index, int length, List<String> combinations) {
		if (index == length) {
			// System.out.println(str);
			combinations.add(new String(str));
			return;
		}
		if (str[index] == '?') {
			// replace '?' by '0' and recurse
			str[index] = '0';
			print(str, index + 1, length, combinations);

			// replace '?' by '1' and recurse
			str[index] = '1';
			print(str, index + 1, length, combinations);

			// NOTE: Need to backtrack as string
			// is passed by reference to the
			// function
			/* We can get back to this branch because of an earlier '?' */
			str[index] = '?';
		} else {
			print(str, index + 1, length, combinations);
		}
	}
	

}
