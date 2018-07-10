package amazon.onsite;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hbhavsar
 *
 */
public class WordSearchII {

	
	public List<String> findWords(char[][] board, String[] words) {
		
		List<String> result = new ArrayList<>();
		
		TrieNode root = buildTree(words);
		
		for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
				dfsSearch(board, i, j, root, result);
	        }
		}
		return result;
	}
	
	public void dfsSearch(char[][] board, int i, int j, TrieNode node, List<String> result) {
		char c = board[i][j];

		if (c == '#' || node.next[c - 'a'] == null) {
			return;
		}
		node = node.next[c - 'a'];
		
		if (node.word != null) {
			// found word
			result.add(node.word);
			node.word = null; // de duplicate
		}

		board[i][j] = '#';
		
		if (i > 0) {
			dfsSearch(board, i - 1, j, node, result);
		}
		if (j > 0) {
			dfsSearch(board, i, j - 1, node, result);
		}
		if (i < board.length - 1) {
			dfsSearch(board, i + 1, j, node, result);
		}
		if (j < board[0].length - 1) {
			dfsSearch(board, i, j + 1, node, result);
		}
		
		board[i][j] = c;
	}
	
	
	public TrieNode buildTree(String[] words) {
		TrieNode root = new TrieNode();

		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null) {
					p.next[i] = new TrieNode();
				}
				p = p.next[i];
				p.word = w;
			}
		}
		return root;
	}
}

class TrieNode {
	TrieNode[] next = new TrieNode[26];
	String word;
}