package amazon;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these
 * operations of SpecialStack must be O(1). To implement SpecialStack, you
 * should only use standard Stack data structure and no other data structure
 * like arrays, list, .. etc.
 * 
 * @author hbhavsar
 *
 */
public class StackWithO1 extends Stack<Integer> {

	Stack<Integer> min = new Stack<>();

	void push(int x) {
		super.push(x);

		if (isEmpty()) {
			min.push(x);
		} else {
			int y = min.pop();
			min.push(y);

			/*
			 * push only when the incoming element of main stack is smaller than or equal to
			 * top of auxiliary stack
			 */
			if (x <= y) {
				min.push(x);
			}
		}
	}

	/*
	 * SpecialStack's member method to insert an element to it. This method makes
	 * sure that the min stack is also updated with appropriate minimum values
	 */
	public Integer pop() {
		int x = super.pop();
		int y = min.pop();

		// If both are not same, then push it again
		if (x != y) {
			min.push(y);
		}
		return x;
	}

	/* SpecialStack's member method to get minimum element from it. */
	int getMin() {
		return min.peek();
	}

}
