package facebook.leetcode_2020.bfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {


    public static void main(String[] args) {

        String beginWord = "hot";
        String endWord = "dog";
        var wordList = List.of("hot", "dog");

        int ans = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);

    }

    // Time: O(M × N × 26) = O(M × N)
    // Space: O(M × N)
    // M is the length of words and NN is the total number of words in the input word list
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // assumtions
        // begin and end are same length words
        // wordList is non empty
        // all words in wordList are of same length

        Set<String> wordDictionary = new HashSet<>(wordList);
        if (!wordDictionary.contains(endWord)) {
            return 0;
        }

        // Bi directional BFS
        Set<String> start = new HashSet<>();
        start.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        int totalSteps = 1;
        while (!start.isEmpty() && !end.isEmpty()) {

            // always consider smaller first
            if (start.size() > end.size()) {
                Set<String> temp = start;
                start = end;
                end = temp;
            }

            Set<String> current = new HashSet<>();
            for (String word : start) {

                for (int i = 0; i < word.length(); i++) {
                    char[] cw = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        cw[i] = ch;
                        String newWord = new String(cw);
                        if (end.contains(newWord)) {
                            return totalSteps + 1;
                        }
                        if (wordDictionary.contains(newWord)) {
                            current.add(newWord);
                            wordDictionary.remove(newWord);
                        }
                    }
                }
            }
            start = current;
            totalSteps++;
        }
        return 0;
    }
}
