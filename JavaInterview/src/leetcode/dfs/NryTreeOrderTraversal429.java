package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class NryTreeOrderTraversal429 {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(Node root) {
//      List<List<Integer>> ans = new ArrayList<>();
//      if(root == null){
//          return ans;
//      }

////         Queue<Node> queue = new Queue<>();
////         queue.add(root);

////         while(!queue.isEmpty()){

////         }

//      return ans;
		return levelOrder(root, 0, new ArrayList<>());
	}

	public List<List<Integer>> levelOrder(Node root, int level, List<List<Integer>> ans) {

		if (root == null) {
			return ans;
		}

		// List<Integer> levelList = ans.get(level) != null ? ans.get(level) : new
		// ArrayList<>();

		List<Integer> levelList = ans.size() > level ? ans.get(level) : new ArrayList<>();
		levelList.add(root.val);

		// if (ans.get(level) == null) {
		if (ans.size() <= level) {
			ans.add(levelList);
		}

		for (Node node : root.children) {
			levelOrder(node, level + 1, ans);
		}

		return ans;
	}
}
