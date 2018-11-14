package leetcode.dfs;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList430 {

	
	public static void main(String[] args) {
		
		
		
	}
	
	
	public FNode flatten(FNode head) {

		if (head == null) {
			return head;
		}

		FNode prev = new FNode();
		prev.next = head;

		Stack<FNode> stack = new Stack<>();

		while (prev.next != null || !stack.isEmpty()) {

			while (prev.next != null) {

				prev = prev.next;
				while (prev.child != null) {
					FNode temp = prev.child;
					prev.child = prev.next;
					prev.next = temp;
					stack.push(prev);
				}
			}

			if (!stack.isEmpty()) {
				FNode temp = stack.pop();
				if (temp.child != null) {
					prev.next = temp.child;
					prev.next.prev = prev;
					temp.child = null;
				}
			}
		}

		return prev.next;
	}
	
	 
//	FNode current;
	
//	public void flattenDFS(FNode node) {
//		if(node == null || (node.next == null && node.child == null)) {
//			return;
//		}
//		
//		if(node.child == null && node.next != null) {
//			flattenDFS(node.next);
//		}
//		
//		if(node.child != null) {
//			FNode temp =  node.next;
//			node.next = node.child;
//			flatten(node.child);
//			
//		}
//		
//	}
	
	
	
}

class FNode {
	public int val;
	public FNode prev;
	public FNode next;
	public FNode child;

	public FNode() {
	}

	public FNode(int _val, FNode _prev, FNode _next, FNode _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}
};