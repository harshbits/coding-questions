package leetcode.uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
    
    
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * @author habhavsar
 *
 */
public class TopKFrequentWords692 {

	public static void main(String[] args) {

		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;

		var ans = new TopKFrequentWords692().topKFrequent(words, k);
		System.out.println(ans);
	}

	
	
	// beats 99.97 % of the performance
	public List<String> topKFrequent(String[] words, int k) {

		if (words == null || words.length == 0 || k == 0) {
			return Collections.emptyList();
		}

		List<String> answer = new ArrayList<>();
		
		Map<String, Frequency> count = new HashMap<>();
		for (String s : words) {
			count.putIfAbsent(s, new Frequency(s, 0));
			count.get(s).count++;
		}

		// Max Heap to store as per the count of the words
		PriorityQueue<Frequency> maxHeap = new PriorityQueue<>();
		maxHeap.addAll(count.values());
		
		// get k max word by count
		while (k-- > 0) {
			String word = maxHeap.poll().word;
			answer.add(word);
		}
		
		return answer;
	}
	
	
	class Frequency implements Comparable<Frequency> {

		String word;

		int count = 0;

		Frequency(String word, int count) {
			this.word = word;
			this.count = count;
		}

		@Override
		public int compareTo(Frequency o) {

			// if count of 2 words are same,
			// then return as per topological order (alphabetic order word first)
			if (this.count == o.count) {
				return this.word.compareTo(o.word);
			}

			return o.count - this.count;
		}

	}

}
