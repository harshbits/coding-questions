package leetcode.stack;

import java.util.Stack;

public class EvaulateRPN150 {

	public static void main(String[] args) {
//		String[] tokens = { "2", "1", "+", "3", "*" };
		String[] tokens = { "0", "3", "/" };
		int ans = new EvaulateRPN150().evalRPN(tokens);
		System.out.println(ans);
	}

//	Set<String> signSet = new HashSet<>() {
//		{
//			add("+");
//			add("-");
//			add("*");
//			add("/");
//		}
//	};

	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

//		Stack<String> stack = new Stack<>();
//		for (int i = tokens.length - 1; i >= 0; i--) {
//			stack.add(tokens[i]);
//		}

		Stack<Integer> stack = new Stack<>();
		for (String s : tokens) {
			if (s.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (s.equals("-")) {
				// reverser order to handle minus sign values
				int last = stack.pop();
				stack.push(stack.pop() - last);
//				stack.push(stack.pop() - stack.pop());
			} else if (s.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (s.equals("/")) {
				// as it's reverse order
				// handle for 0 input
				int last = stack.pop();
				stack.push(stack.pop() / last);
//				stack.push(stack.pop() / stack.pop());
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}

//	public int evalRPN(Stack<String> stack) {
//
//		Stack<String> temp = new Stack<>();
//		
//		String s = stack.pop();
//		while (!signSet.contains(s)) {
//			temp.add(s);
//			s = stack.pop();
//		}
//
//		return 0;
//	}
}
