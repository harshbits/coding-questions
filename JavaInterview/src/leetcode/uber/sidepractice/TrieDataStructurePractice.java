package leetcode.uber.sidepractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TrieDataStructurePractice {

	public static void main(String[] args) {

		new TrieDataStructurePractice().test();

	}

	public void test() {
		Trie t = new Trie();
		t.insert("amazon");
		t.insert("amazing");
		t.insert("amazon prime");
		t.insert("amazed");
		t.insert("amazing spiderman");
		t.insert("alibaba");
		t.insert("ali express");
		t.insert("ebay");
		t.insert("egg");
		t.insert("walmart");
		
		var auto = t.autoComplete("a");
		System.out.println(auto);
	}

	class Trie {

		private TrieNode root;

		public Trie() {
			super();
			this.root = new TrieNode(' ');
		}

		// insert the new word
		public void insert(String word) {

			if (search(word)) {
				return;
			}
			TrieNode current = root;
			TrieNode pre;

			for (char ch : word.toCharArray()) {
				pre = current;
				TrieNode child = current.getChild(ch);
				if (child != null) {
					current = child;
					child.parent = pre;
				} else {
					// add new if does not exist.
					current.children.add(new TrieNode(ch));
					current = current.getChild(ch);
					current.parent = pre;
				}
			}
			current.isEnd = true;
		}

		// search for the existing word
		public boolean search(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				// if child does not exist, break the search feature
				if (current.getChild(ch) == null) {
					return false;
				} else {
					current = current.getChild(ch);
				}
			}

			return current.isEnd;
		}

		// auto-complete feature
		public List<String> autoComplete(String prefix) {

			TrieNode last = root;
			for (char ch : prefix.toCharArray()) {
				last = last.getChild(ch);
				if (last == null) {
					return Collections.emptyList();
				}
			}

			return last.getWords();
		}

	}

	class TrieNode {
		char data;

		LinkedList<TrieNode> children;

		TrieNode parent;

		boolean isEnd;

		public TrieNode(char data) {
			super();
			this.data = data;
			this.children = new LinkedList<>();
			this.isEnd = false;
		}

		public TrieNode getChild(char data) {
			if (children != null) {
				for (TrieNode child : children) {
					if (child.data == data) {
						return child;
					}
				}
			}
			return null;
		}

		public List<String> getWords() {

			List<String> words = new ArrayList<>();

			if (isEnd) {
				words.add(toString());
			}

			if (children != null) {
				for (TrieNode child : children) {
					words.addAll(child.getWords());
				}
			}

			return words;
		}

		@Override
		public String toString() {
			if (parent == null) {
				return "";

			}
			// this will happen recursively till the parent == null.
			return parent.toString() + new String(new char[] { data });
		}

	}
}
