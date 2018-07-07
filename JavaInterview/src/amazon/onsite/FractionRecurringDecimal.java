package amazon.onsite;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

 * @author hbhavsar
 *
 */
public class FractionRecurringDecimal {

	
	public static void main(String[] args) {
		
		System.out.println(fractionToDecimal(-1, -2147483648));
	}
	
	
	public static String fractionToDecimal(int numerator, int denominator) {
		
		if(denominator == 0) {
			return "0";
		}
		
		StringBuilder answer = new StringBuilder();
		
		// Determine the signs
		// We can not determine by simply multiplying as we might need a bigger data type to store it
		String sign = Math.signum(numerator) * Math.signum(denominator) >= 0 ? "" : "-";
		answer.append(sign);
		
		// We can also do the same thing with XOR instead of signum operator
		// String sign1 = ((numerator > 0) ^ (denominator > 0)) ? "-" : "";

		// without sign
		long numerator1 = Math.abs((long) numerator);
		long denominator1 = Math.abs((long) denominator);
		
		answer.append((numerator1/denominator1));
		
		numerator1 = numerator1 % denominator1;
		if(numerator1 == 0) {
			return answer.toString();
		}
		
		// Add fraction
		answer.append(".");
		
		// Handle Fractional part
		
		// Map to maintain index of the value
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(numerator1, answer.length());
		
		while (numerator1 != 0) {
			numerator1 = numerator1 * 10;
			answer.append((numerator1 / denominator1));
			numerator1 = numerator1 % denominator1;
			
			if (map.containsKey(numerator1)) {
				int index = map.get(numerator1);
				answer.insert(index, "(");
				answer.append(")");
				break;
			}else {
				map.put(numerator1, answer.length());
			}
		}
		return answer.toString();
	}
	
}
