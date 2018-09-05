package google.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 * 
 * Return a list of all possible full binary trees with N nodes. Each element of
 * the answer is the root node of one possible tree.
 * 
 * Each node of each tree in the answer must have node.val = 0.
 * 
 * You may return the final list of trees in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 7 Output:
 * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * 
 * 1 <= N <= 20
 * 
 * @author hbhavsar
 *
 */
public class AllFullBinaryTrees894 {

	private Map<Integer, List<TreeNode>> memo;

	public static void main(String[] args) {
		AllFullBinaryTrees894 a = new AllFullBinaryTrees894();
		int N = 7;
		List<TreeNode> ans = a.allPossibleFBT(N);
		System.out.println(ans);

	}

	public AllFullBinaryTrees894() {
		this.memo = new HashMap<>();
	}

	public List<TreeNode> allPossibleFBT(int N) {

		if (memo.containsKey(N)) {
			return memo.get(N);
		}

		List<TreeNode> allTrees = new ArrayList<>();
		if (N == 1) {
			allTrees.add(new TreeNode(0));
		} else if (N % 2 == 1) {

			for (int x = 0; x < N; ++x) {
				int y = N - x - 1;
				List<TreeNode> leftTree = allPossibleFBT(x);
				List<TreeNode> rightTree = allPossibleFBT(y);
				for(TreeNode l : leftTree){
					for (TreeNode r : rightTree) {
						TreeNode tree = new TreeNode(0);
						tree.left = l;
						tree.right = r;
						allTrees.add(tree);
					}
				}
			}
		}
		memo.put(N, allTrees);
		return allTrees;
	}
	
	
}
