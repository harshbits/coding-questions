package leetcode.uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutoCompleteSystem642 {

	public static void main(String[] args) {

		String[] sentences = { "i love you", "island", "ironman", "i love leetcode" };
		int[] times = { 5, 3, 2, 2 };

		AutoCompleteSystem642 a = new AutoCompleteSystem642(sentences, times);

		var ans = a.input('i');
		System.out.println(ans);

	}

	TrieNode root;
	String prefix;

	public AutoCompleteSystem642(String[] sentences, int[] times) {
		root = new TrieNode();
		prefix = "";

		for (int i = 0; i < sentences.length; i++) {
			add(sentences[i], times[i]);
		}
	}

	class TrieNode {
		Map<Character, TrieNode> children;
		Map<String, Integer> counts;
		boolean isWord;

		public TrieNode() {
			children = new HashMap<>();
			counts = new HashMap<>();
			isWord = false;
		}
	}

	class Pair {
		String s;
		int c;

		public Pair(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}

	private void add(String s, int count) {
		TrieNode curr = root;
		for (char c : s.toCharArray()) {
			TrieNode next = curr.children.get(c);
			if (next == null) {
				next = new TrieNode();
				curr.children.put(c, next);
			}
			curr = next;
			curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
		}
		curr.isWord = true;
	}

	public List<String> input(char c) {

		if (c == '#') {
			add(prefix, 1);
			prefix = "";
			return Collections.emptyList();
		}

		prefix = prefix + c;
		TrieNode curr = root;
		for (char cc : prefix.toCharArray()) {
			TrieNode next = curr.children.get(cc);
			if (next == null) {
				return Collections.emptyList();
			}
			curr = next;
		}

		// if count's are same then go with the ASCII or go by the bigger count first.
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));

		for (String s : curr.counts.keySet()) {
			maxHeap.add(new Pair(s, curr.counts.get(s)));
		}

		List<String> result = new ArrayList<>();
		// we need only 3 results
		for (int i = 0; i < 3 && !maxHeap.isEmpty(); i++) {
			result.add(maxHeap.poll().s);
		}

		return result;
	}

}
