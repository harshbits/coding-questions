package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

		System.out.println("Using Reccurssion:-");
		combinations.stream().forEach(System.out::println);

		combinations = combinationsIterative(input);
		System.out.println("\nUsing Iterative method:-");
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

	// Method to handle thread safe
	public static List<String> combinationsIterative(String str) {

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

		// initialize queue.
		// We can take stack or set or vector
		Queue<String> queue = new LinkedList<>();
		queue.add(str);

		int index;

		while (!queue.isEmpty()) {
			String current = queue.poll();
			if ((index = current.indexOf('?')) != -1) {
				// Replace '?' with '0' and '1' and push it to the Queue
				for (char ch = '0'; ch <= '1'; ch++) {
					current = current.substring(0, index) + ch + current.substring(index + 1);
					// System.out.println(current);
					queue.add(current);
				}
			}
			// If there is no wildcard pattern found
			else {
				combinations.add(current);
			}
		}
		return combinations;
	}

}
