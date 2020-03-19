package google.leetcode_2020.string;

import java.util.*;

public class SentenceSimilarity2 {

    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        List<List<String>> pairs = List.of(List.of("great", "fine"),
                List.of("acting", "drama"), List.of("skills", "talent"));

        boolean ans = new SentenceSimilarity2().areSentencesSimilar(words1, words2, pairs);
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
            if (word1.equals(word2)) {
                continue;
            }
            if (!map.containsKey(word1)) {
                return false;
            }
            // DFS
            if (!dfs(word1, word2, map, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(String source, String target, Map<String, Set<String>> graph, Set<String> visited) {

        if (graph.get(source).contains(target)) {
            return true;
        }

        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(next, target, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Disjoint set union
    // Data structure
    class DSU {

        int[] parent;

        public DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        // union method
        public void union(int x, int y) {

        }


    }
}
