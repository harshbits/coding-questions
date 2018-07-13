package amazon.onsite;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @author hbhavsar
 *
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {

		
		
	}

	// Similar to BFS
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		// Insert root
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<>();
			for (int i = 0; i < levelNum; i++) {
				// Current node
				TreeNode node = queue.poll();
				// add left to the queue
				if (node.left != null) {
					queue.offer(node.left);
				}
				// add right to the queue
				if (node.right != null) {
					queue.offer(node.right);
				}
				subList.add(node.val);
			}
			result.add(subList);
		}

		return result;
	}
}
