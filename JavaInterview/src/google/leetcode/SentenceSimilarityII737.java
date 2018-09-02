package google.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are
 * similar.
 * 
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine",
 * "drama", "talent"] are similar, if the similar word pairs are pairs =
 * [["great", "good"], ["fine", "good"], ["acting","drama"],
 * ["skills","talent"]].
 * 
 * Note that the similarity relation is transitive. For example, if "great" and
 * "good" are similar, and "fine" and "good" are similar, then "great" and
 * "fine" are similar.
 * 
 * Similarity is also symmetric. For example, "great" and "fine" being similar
 * is the same as "fine" and "great" being similar.
 * 
 * Also, a word is always similar with itself. For example, the sentences words1
 * = ["great"], words2 = ["great"], pairs = [] are similar, even though there
 * are no specified similar word pairs.
 * 
 * Finally, sentences can only be similar if they have the same number of words.
 * So a sentence like words1 = ["great"] can never be similar to words2 =
 * ["doubleplus","good"].
 * 
 * Note:
 * 
 * The length of words1 and words2 will not exceed 1000. The length of pairs
 * will not exceed 2000. The length of each pairs[i] will be 2. The length of
 * each words[i] and pairs[i][j] will be in the range [1, 20].
 * 
 * @author hbhavsar
 *
 */
public class SentenceSimilarityII737 {

	public static void main(String[] args) {
		SentenceSimilarityII737 s = new SentenceSimilarityII737();
		String[] words1 = { "great", "acting", "skills" };
		String[] words2 = { "fine", "drama", "talent" };
		String[][] pairs = { { "great", "good" }, { "fine", "good" }, { "acting", "drama" }, { "skills", "talent" } };
		boolean ans = s.areSentencesSimilarTwo(words1, words2, pairs);
		System.out.println(ans);
	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

		if (words1.length != words2.length) {
			return false;
		}

		Map<String, String> map = new HashMap<>();
		for (String[] p : pairs) {
			String parent1 = findDFS(map, p[0]);
			String parent2 = findDFS(map, p[1]);
			// if both words are not same, put them into map.
			if (!parent1.equals(parent2)) {
				map.put(parent1, parent2);
			}
		}
		
		for (int i = 0; i < words1.length; i++) {
			String w1 = words1[i];
			String w2 = words2[i];
			String p1 = findDFS(map, w1);
			String p2 = findDFS(map, w2);

			// if both words are not same.
			// and if finding their parents are not same, 
			// then return false.
			if (!w1.equals(w2) && !p1.equals(p2)) {
				return false;
			}
		}

		return true;
	}

	public String findDFS(Map<String, String> map, String w) {

		if (!map.containsKey(w)) {
			map.put(w, w);
		}

		// if words are same, then return the word,
		// or else keep searching for the word
		return w.equals(map.get(w)) ? w : findDFS(map, map.get(w));
	}

}
