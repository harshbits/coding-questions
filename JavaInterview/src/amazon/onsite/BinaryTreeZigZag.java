package amazon.onsite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * @author hbhavsar
 *
 */
public class BinaryTreeZigZag {

	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		printZigZag(root, result, 0);
		return result;
	}

	private void printZigZag(TreeNode root, List<List<Integer>> result, int level) {

		if (root == null) {
			return;
		}

		if (result.size() <= level) {
			List<Integer> newLevel = new LinkedList<>();
			result.add(newLevel);
		}

		List<Integer> collection = result.get(level);

		if (level % 2 == 0) {
			collection.add(root.val);
		}

		else {
			collection.add(0, root.val);
		}

		// All Left nodes
		printZigZag(root.left, result, level + 1);
		// All right nodes
		printZigZag(root.right, result, level + 1);

	}
}
