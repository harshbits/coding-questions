package google.leetcode_2020;


//Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Output: 5
//
//        Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        return its length 5.
//
//Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: 0
//
//        Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        int ans = new WordLadder().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ans);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        // o(1)  look up
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return ans;
        }

        // will use breadth first search
        Queue<String> queue = new LinkedList<>();
        // offer will return false if it fails
        // queue.offer(beginWord);
        // add method will throw an error
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            // iterate all the words in queue
            for (int i = queue.size(); i > 0; i--) {
                // return and delete
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return ans + 1;
                }
                // for each character of thr word
                // form a tree if they are present in our word set
                for (int j = 0; j < word.length(); j++) {
                    char[] cw = word.toCharArray();
                    // try to
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        cw[j] = ch;
                        String newWord = new String(cw);
                        if (set.contains(newWord) && !newWord.equals(word)) {
                            queue.add(newWord);
                            // since we already iterate over this
                            set.remove(newWord);
                        }
                    }
                }
            }
            // processed 1 step
            ans++;
        }
        return ans;
    }
}
