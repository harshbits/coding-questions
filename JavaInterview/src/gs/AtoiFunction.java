package gs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AtoiFunction {

	public static void main(String[] args) {
		System.out.println(myAtoi2("12 "));
		
		Map<String, String> map = new HashMap<>();
		
//		map.values().fo
		
		map.entrySet().stream().forEach(value -> {
			String key = value.getKey();
			String val = value.getValue();
		});
		
		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) it.next();
		}
		
	}
	public static boolean myAtoi2(String str) {
		
		if (str.matches("-?\\d+(\\.\\d+)?")) {
			return true;
		}
		return false;
	}
	public int myAtoi1(String str) {
		if (str == null)
			return 0;
		// Remove whitespaces on both sides and assign to test string
		String test = str.trim();
		if (test.length() == 0)
			return 0;

		long result = 0;
		int i = 0;
		boolean isNegative = false;

		// String starts with a digit or +/-?
		char firstChar = test.charAt(0);
		if (firstChar == '+')
			i = 1;
		else if (firstChar == '-') {
			i = 1;
			isNegative = true;
		} else if (!Character.isDigit(firstChar))
			return 0;

		int len = test.length();
		while (i < len && Character.isDigit(test.charAt(i))) {
			int digit = Character.getNumericValue(test.charAt(i));
			result = (result * 10) + digit;
			if (result > Integer.MAX_VALUE || (result * -1) < Integer.MIN_VALUE) {
				if (isNegative)
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			i += 1;
		}
		return isNegative ? (int) (result * -1) : (int) result;
	}

}
