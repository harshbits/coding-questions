package google.leetcode_2020.string;

import java.util.*;

public class SentenceSimilarity {

    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = List.of(List.of("great", "fine"),
                List.of("acting", "drama"), List.of("skills", "talent"));

        boolean ans = new SentenceSimilarity().areSentencesSimilar(words1, words2, pairs);
        System.out.println(ans);
    }


    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            map.putIfAbsent(pair.get(0), new HashSet<>());
            map.putIfAbsent(pair.get(1), new HashSet<>());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (!word1.equals(word2) || !map.containsKey(word1) || !map.get(word1).contains(word2)) {
                return false;
            }
        }
        return true;
    }
}
