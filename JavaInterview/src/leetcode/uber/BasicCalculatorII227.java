package leetcode.uber;

import java.util.Stack;

public class BasicCalculatorII227 {

	public static void main(String[] args) {

		var s = "3+2*2";
		var ans = new BasicCalculatorII227().calculate(s);
		System.out.println(ans);
	}

	public int calculate(String s) {
		
		if (s == null || s.trim().length() == 0) {
			return 0;
		}
		
		// Hold calculations
//		Stack<Integer> stack = new Stack<>();
		
		char[] sc = s.trim().toCharArray();
		int number = 0, mul = 0, calc = 0;
		
		char sign = '+';
		for (int i = 0; i < sc.length; i++) {
			char c = sc[i];
			if(c == ' ') {
				continue;
			}
			// to keep track of the number, which is multi digits
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			}
			
			if (!Character.isDigit(c)) {
				if (sign == '+') {
					calc += number;
					mul = number;
				} else if (sign == '-') {
					calc += -number;
					mul = -number;
				} else if (sign == '*') {
					calc = calc - mul + (mul * number);
					mul = mul * number;
					
				} else if (sign == '/') {
					calc = calc - mul + (mul / number);
					mul = mul / number;
				}
				sign = c;
				number = 0;
			}
		}
	
		
		return calc;
	}
}
