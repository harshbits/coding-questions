package leetcode.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

	public static void main(String[] args) {

		String s = "()";
		var ans = new ValidParentheses20().isValid(s);
		System.out.println(ans);
		
		s = "()[]{}";
		ans = new ValidParentheses20().isValid(s);
		System.out.println(ans);
		
		s = "(]";
		ans = new ValidParentheses20().isValid(s);
		System.out.println(ans);
		
		s = "([)]";
		ans = new ValidParentheses20().isValid(s);
		System.out.println(ans);
		
		s = "{[]}";
		ans = new ValidParentheses20().isValid(s);
		System.out.println(ans);
	}

	
	Map<Character, Character> map = new HashMap<>() {
		private static final long serialVersionUID = 1L;

		{
			put(')', '(');
			put(']', '[');
			put('}', '{');

		}
	};

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty() || stack.peek() != map.get(c)) {
				stack.add(c);
			} else {
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
