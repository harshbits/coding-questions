package leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII126 {

	public static void main(String[] args) {
//		String beginWord = "hit";
//		String endWord = "cog";
//		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
		
		String beginWord = "a";
		String endWord = "c";
		List<String> wordList = List.of("a", "b", "c");
		
		var ans = new WordLadderII126().findLadders(beginWord, endWord, wordList);
		System.out.println(ans);
	}
	
//	private static final char[] az = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
//			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		// ans
		List<List<String>> ans = new ArrayList<>();
		if (wordList == null || beginWord == null || endWord == null) {
			return ans;
		}

		// convert list to set for O(1) look up
//		Set<String> wordDict = wordList.stream().collect(Collectors.toSet());
		Set<String> wordDict = new HashSet<>(wordList);
		if (!wordDict.contains(endWord)) {
			return ans;
		}
		wordDict.remove(beginWord);

		// start of the list
		List<String> start1 = new ArrayList<>();
		start1.add(beginWord);
		
		// all the list inititalize
		List<List<String>> start = new ArrayList<>();
		start.add(start1);
		
		HashMap<String, List<List<String>>> map = new HashMap<>();
		map.put(beginWord, start);
		
//		Set<String> visited = new HashSet<>();
//		Queue<String> queue = new LinkedList<>();
//		queue.add(beginWord);
//		while (!queue.isEmpty()) {
//
//			char[] word = queue.poll().toCharArray();
//
//			for (int i = 0; i < word.length; i++) {
//				for (char c = 'a'; c <= 'z'; c++) {
//					if (word[i] != c) {
//						word[i] = c;
//						String w = String.valueOf(word);
//
//						if (!visited.contains(w) && wordDict.contains(w)) {
//							queue.add(w);
//						}
//					}
//				}
//			}
//		}
		
		while (!map.isEmpty()) {
			HashSet<String> visited = new HashSet<>();
			// add all map keys
			HashSet<String> keySet = new HashSet<>(map.keySet());
			
			for (String key : keySet) {
				char[] word = key.toCharArray();
				for (int i = 0; i < word.length; i++) {
					char tmp = word[i];
					for (char c = 'a'; c <= 'z'; c++) {
						word[i] = c;
						String w = String.valueOf(word);
						if (wordDict.contains(w)) {
							visited.add(w);
							if (!map.containsKey(w)) {
								map.put(w, new ArrayList<>());
							}
							
							for (List<String> curList : map.get(key)) {
								List<String> nextList = new ArrayList<>();
								nextList.addAll(curList);
								nextList.add(w);
								map.get(w).add(nextList);
							}
						}
					}
					word[i] = tmp;
				}
				map.remove(key);
			}
			if (map.containsKey(endWord)) {
				return map.get(endWord);
			}
			
			for (String key : visited) {
				wordDict.remove(key);
			}
		}

		return ans;
	}
	
	
}
