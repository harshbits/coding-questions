package google.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given two sentences words1, words2 (each represented as an array of strings),
 * and a list of similar word pairs pairs, determine if two sentences are
 * similar.
 * 
 * For example, "great acting skills" and "fine drama talent" are similar, if
 * the similar word pairs are pairs = [["great", "fine"], ["acting","drama"],
 * ["skills","talent"]].
 * 
 * Note that the similarity relation is not transitive. For example, if "great"
 * and "fine" are similar, and "fine" and "good" are similar, "great" and "good"
 * are not necessarily similar.
 * 
 * However, similarity is symmetric. For example, "great" and "fine" being
 * similar is the same as "fine" and "great" being similar.
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
public class SentenceSimilarity734 {
	
	public static void main(String[] args) {
		String[] words1 = {"great"};
		String[] words2 = {"great"};
		String[][] pairs = { {} };
		
		SentenceSimilarity734 s = new SentenceSimilarity734();
		boolean ans = s.areSentencesSimilar(words1, words2, pairs);
		System.out.println(ans);
	}
	
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {

		if(words1.length != words2.length) {
			return false;
		}
		
		// This logic will fail when there is more than one similarites for single word.
		// Such as,
		// [great, nice]
		// [great, fine]
		
		
//		Map<String, String> pairMap = new HashMap<>();
//		for (String[] pair : pairs) {
//			if(pair.length > 0) {
//				pairMap.put(pair[0], pair[1]);
//				pairMap.put(pair[1], pair[0]);	
//			}
//		}
//
////		Set<String> wordSet1 = new HashSet<>(Arrays.asList(words1));
//		Set<String> wordSet2 = new HashSet<>(Arrays.asList(words2));
//		
//		for (String word : words1) {
//			String pairWord = pairMap.get(word);
//			if (pairWord != null) {
//				if (!wordSet2.contains(pairWord)) {
//					return false;
//				}
//			} else if (!wordSet2.contains(word)) {
//				return false;
//			}
//		}

		Map<String, Set<String>> pairInfo = new HashMap<>();
		
		for (String[] pair : pairs) {
			if(!pairInfo.containsKey(pair[0])) {
				pairInfo.put(pair[0], new HashSet<>());
			}
			
			if(!pairInfo.containsKey(pair[1])) {
				pairInfo.put(pair[1], new HashSet<>());
			}
			
			pairInfo.get(pair[0]).add(pair[1]);
			pairInfo.get(pair[1]).add(pair[0]);
		}
		
		for (int i = 0; i < words1.length; i++) {
			// If both words are same
			if (words1[i].equals(words2[i])) {
				continue;
			}
			// if pair info does not have this key
			if (!pairInfo.containsKey(words1[i])) {
				return false;
			}
			
			// If word 1 does not have any similarities.
			if(!pairInfo.get(words1[i]).contains(words2[i])) {
				return false;
			}
		}
		
		return true;
	}

}
