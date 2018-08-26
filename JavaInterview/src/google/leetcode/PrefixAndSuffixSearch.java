package google.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only.

 * @author hbhavsar
 *
 */
public class PrefixAndSuffixSearch {
	
//	List<char[]> words;
	String[] words;
	
	public PrefixAndSuffixSearch(String[] words) {
//		this.words = new ArrayList<>();
//		for (String w : words) {
//			this.words.add(w.toCharArray());
//		}
		this.words = words;
	}
	
	public static void main(String[] args) {
		
		String[] words = { "apple" };
		PrefixAndSuffixSearch p = new PrefixAndSuffixSearch(words);
		int ans = p.f("a", "e");
		System.out.println(ans);
	}

	public int f(String prefix, String suffix) {
		int max = -1;
		int weight = 0;
//		for (char[] w : this.words) {
//			if (String.valueOf(w[0]).equals(prefix) && String.valueOf(w[w.length - 1]).equals(suffix)) {
//				return weight;
//			}
//			weight++;
//		}
		for (String w : this.words) {
			if(w.startsWith(prefix) && w.endsWith(suffix)) {
				weight =  weight;
			}
		}
		return max;
	}

}
