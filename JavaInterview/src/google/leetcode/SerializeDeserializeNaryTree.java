package google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree
 * is a rooted tree in which each node has no more than N children. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that an N-ary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following 3-ary tree
 * 
 * 
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so
 * please be creative and come up with different approaches yourself.
 * 
 * Note:
 * 
 * N is in the range of [1, 1000] Do not use class member/global/static
 * variables to store states. Your serialize and deserialize algorithms should
 * be stateless.
 * 
 * @author hbhavsar
 *
 */
public class SerializeDeserializeNaryTree {

	public static void main(String[] args) {

	}

	// Encodes a tree to a single string.
	// Serialize in preorder
	public String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		serializePreorder(sb, root);
		return sb.toString();
	}

	private void serializePreorder(StringBuilder sb, Node root) {
		if (root == null) {
			return;
		}

		sb.append(root.val);
		if (root.children != null) {
			sb.append(root.children.size());
		}

		for (Node n : root.children) {
			serializePreorder(sb, n);
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {
		if (data == null || data.isEmpty()) {
			return null;
		}

		String[] ss = data.split(",");
		Queue<String> q = new LinkedList<>(Arrays.asList(ss));
		return deserializePreorder(q);
	}

	private Node deserializePreorder(Queue<String> queue) {
		Node root = new Node();
		root.val = Integer.parseInt(queue.poll());

		int size = Integer.parseInt(queue.poll());
		root.children = new ArrayList<Node>(size);

		for (int i = 0; i < size; i++) {
			root.children.add(deserializePreorder(queue));
		}
		return root;
	}

}

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};
