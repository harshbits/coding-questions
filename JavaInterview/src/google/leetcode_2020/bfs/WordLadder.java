package google.leetcode_2020.bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * 
 * @author hbhavsar
 *
 */
public class WordLadder {

	public static void main(String[] args) {

	}
	
	
	public int ladderLengthTwoEnd(String beginWord, String endWord, List<String> wordList) {

		// Covert words list into set
		Set<String> wordSet = new HashSet<>(wordList);

		// IF end word not present in the list, then remove from the list
		if (!wordSet.contains(endWord)) {
			return 0;
		}

		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();

		beginSet.add(beginWord);
		endSet.add(endWord);

		int distance = 1;

		Set<String> visited = new HashSet<>();
		// start by two ends
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {

			// Swap sets
			// Assign begin set to end set.
			// always go with smaller set
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<>();
			for (String word : beginSet) {

				// Initializing it once, instead of doing it in for loop
				char[] chars = word.toCharArray();

				// for every character of each word
				for (int i = 0; i < chars.length; i++) {

					// Try to put different combination
					for (char ch = 'a'; ch <= 'z'; ch++) {
						char old = chars[i];

						// Try all possible characters on index i
						chars[i] = ch;

						String target = String.valueOf(chars);

						// If end set contains the word, then that's the total distance
						if (endSet.contains(target)) {
							return distance + 1;
						}

						if (!visited.contains(target) && wordSet.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						// In order to reassign the original value back
						chars[i] = old;
					}
				}
			}
			beginSet = temp;
			distance++;
		}
		return 0;
	}

	public int ladderLengthOneEnd(String beginWord, String endWord, List<String> wordList) {
		Set<String> reached = new HashSet<>();
		// Covert words list into set
		Set<String> wordSet = new HashSet<>(wordList);

		// IF end word not present in the list, then remove from the list
		if(!wordSet.contains(endWord)) {
			return 0;
		}
		reached.add(beginWord);

		int distance = 1;
		
		while (!reached.contains(endWord)) {
			Set<String> toAdd = new HashSet<>();

			// For each word try to replace characters and check if there's any match.
			for (String word : reached) {
				// for every character of each word
				for (int i = 0; i < word.length(); i++) {
					
					char[] chars = word.toCharArray();
					
					// Try to put different combination
					for (char ch = 'a'; ch <= 'z'; ch++) {
						// Try all possible characters on index i
						chars[i] = ch;
						String w = new String(chars);
						if(wordSet.contains(w)) {
							toAdd.add(word);
							wordSet.remove(word);
						}
					}
				}
			}
			distance++;
			// If there are not words found to be added/ return 0
			if(toAdd.size() ==0) {
				return 0;
			}
			reached = toAdd;
		}
		return distance;
	}
}
