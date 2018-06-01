package leetcode;

import java.util.Stack;

public class StackListTest {

	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("ABC");
		stack.push("XYZ");
		
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.get(i));
		}
		
		
	}
}
