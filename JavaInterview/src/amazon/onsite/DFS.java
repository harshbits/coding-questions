package amazon.onsite;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {

	
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
