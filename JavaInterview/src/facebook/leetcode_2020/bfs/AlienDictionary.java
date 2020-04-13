package facebook.leetcode_2020.bfs;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String order = new AlienDictionary().alienOrder(words);
        System.out.println(order);

    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        StringBuilder result = new StringBuilder();

        if (words == null || words.length == 0) {
            return result.toString();
        }
        // Initially for all characters put degree as 0.
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        // w = 0
        // r = 0
        // t = 0
        // f = 0
        // e = 0

        // making a graph
        // character and next character falls afterl
        for (int i = 0; i < words.length - 1; i++) {

            String cur = words[i];
            String next = words[i + 1];

            int length = Math.min(cur.length(), next.length());

            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {

                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());

                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // t -> [f]
        // w -> [e]
        //

//        System.out.println(map);

        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result.toString();
    }
}
