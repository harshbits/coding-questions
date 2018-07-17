package amazon.onsite;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {

	
	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal("10.00");
		BigDecimal b2 = new BigDecimal("10.000");
		
		System.out.println(b1.equals(b2));
	}
	public void dfsReccursive() {

	}

	public void dfsIterative(TreeNode root) {

		if(root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> set = new HashSet<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop(); 
			set.add(current);
		}
		
		
	}

}
