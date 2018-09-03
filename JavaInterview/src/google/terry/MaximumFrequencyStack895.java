package google.terry;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].
 

Note:

Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
The total number of FreqStack.push calls will not exceed 10000 in a single test case.
The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.

 * @author hbhavsar
 *
 */
public class MaximumFrequencyStack895 {
	
	public static void main(String[] args) {

		FreqStack f = new FreqStack();
		f.push(5);
		f.push(7);
		f.push(5);
		f.push(7);
		f.push(4);
		f.push(5);

		System.out.println(f.pop());
		System.out.println(f.pop());
		System.out.println(f.pop());
		System.out.println(f.pop());
		System.out.println(f.pop());
		System.out.println(f.pop());
	}

}

class FreqStack {

	private Map<Integer, StackNode> map;
	
	private StackNode first;
	
	private StackNode last;
	
	public FreqStack() {
		this.map = new HashMap<>();
		this.first = new StackNode(0);
		this.first.setNext(last);
	}

	public void push(int x) {
		StackNode node;
		if (!map.containsKey(x)) {
			if (first.getNext() == null) {
				node = new StackNode(1);
				first.setNext(node);
				last = node;
				last.setPrev(first);
			}
			node = first.getNext();
		} else {
			node = map.get(x);
			if (node.getNext() == null) {
				StackNode temp = node;
				node = new StackNode(node.getFrequency() + 1);
				last = node;
				temp.setNext(node);
				last.setPrev(temp);
			} else {
				node = node.getNext();
			}
		}
		node.getStack().push(x);
		map.put(x, node);
	}

	public int pop() {
		if (last == null) {
			return -1;
		}
		int val = last.getStack().pop();

		if (last.getStack().size() == 0) {
			last = last.getPrev();
		}

		return val;
	}
}



class StackNode {

	private int frequency;

	private StackNode prev;

	private StackNode next;

	private Stack<Integer> stack;
	
	public StackNode(int frequency) {
		this.frequency = frequency;
		this.stack = new Stack<>();
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public StackNode getPrev() {
		return prev;
	}

	public void setPrev(StackNode prev) {
		this.prev = prev;
	}

	public StackNode getNext() {
		return next;
	}

	public void setNext(StackNode next) {
		this.next = next;
	}

	public Stack<Integer> getStack() {
		return stack;
	}

	public void setStack(Stack<Integer> stack) {
		this.stack = stack;
	}

}