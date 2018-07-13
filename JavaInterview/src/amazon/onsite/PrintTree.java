package amazon.onsite;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   / 
  3 
 / 
4 
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
Note: The height of binary tree is in the range of [1, 10].


 * 
 * 
 * @author hbhavsar
 *
 */
public class PrintTree {

	
	public static void main(String[] args) {
		
	}
	
	public List<List<String>> printTree(TreeNode root) {

		List<List<String>> result = new ArrayList<>();
		int height = root == null ? 1 : getHeighOfTheTree(root);
		// the number of row is the height of tree
		int rows = height;
		// as range is always between 1 and 10. do not need bigger type
		// the number of columns in each row is 2^(height of tree) – 1
		int columns = (int) Math.pow(2, height) - 1;

		// Prepare empty matrix
		List<String> row = new ArrayList<>();
		for (int i = 0; i < columns; i++) {
			row.add("");
		}
		for (int i = 0; i < rows; i++) {
			result.add(new ArrayList<>(row));
		}

		// DFS helper to insert values
		dfsHelper(root, result, 0, 0, columns - 1);

		return result;

	}
	
	/**
	 * DFS Helper method to fill the values
	 * 
	 * @param root
	 * @param result
	 * @param currentRow
	 * @param left
	 * @param right
	 */
	private void dfsHelper(TreeNode root, List<List<String>> result, int currentRow, int left, int right) {
	
		if (root == null) {
			return;
		}
		
		// Root element
		result.get(currentRow).set((left + right) /2, Integer.toString(root.val));
		
		// Left half of the matrix
		dfsHelper(root.left, result, currentRow + 1, left, (left + right) / 2 - 1);		
		
		// Right half of the matrix
		dfsHelper(root.right, result, currentRow + 1, (left + right) / 2 + 1, right);
	}
	
	
	/**
	 * Get Height of the tree
	 * @param root
	 * @return
	 */
	private int getHeighOfTheTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeighOfTheTree(root.left), getHeighOfTheTree(root.right));
	}
	
}
