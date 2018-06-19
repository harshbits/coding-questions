package amazon;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Serialization is the process of converting a data structure or object into 
 * a sequence of bits so that it can be stored in a file or memory buffer,
 *  or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be 
deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Clarification: The above format is the same as how LeetCode serializes a binary tree.
 You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.



 * @author hbhavsar
 *
 */
public class SerializeDeserializeBinaryTree {

	private static final String NULL = "null";

	private static final String DELIMETER = ",";
	
	public static void main(String[] args) {
		
	}
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		searializeTreetoString(root, sb);
		return sb.toString();
		
		// Another approach using String.format
		// Without using StringBuilder
//		if (root == null) {
//			return NULL;
//		}
//			
//		// string value = root.val + root.left + root.right;
//		return String.format("{0},{1},{2}", root.val, serialize(root.left), serialize(root.right));
		
	}
	
	// We will be doing pre order traversal
	// root -> left -> right
	private void searializeTreetoString(TreeNode node, StringBuilder sb) {
		
		if(node == null) {
//			return "null";
			sb.append(NULL).append(DELIMETER);
		}else {
			sb.append(node.val).append(DELIMETER);
			
			// Left Sub Tree
			searializeTreetoString(node.left, sb);
			// Right Sub Tree
			searializeTreetoString(node.right, sb);
		}
		
		
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		// Add all comma separated values to queue
		// Using queue to store pre-order traversal.
		Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(DELIMETER)));
		
		// Build tree
		TreeNode tree = buildTree(nodes);
		
		return tree;
	}
	
	private TreeNode buildTree(Deque<String> nodes) {
		// Removes the head of the queue
		String value = nodes.remove();

		// Tree is empty
		if (value.equals(NULL)) {
			return null;
		} else {
			TreeNode node = new TreeNode(Integer.valueOf(value));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
	}
    
    
    public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}
}
