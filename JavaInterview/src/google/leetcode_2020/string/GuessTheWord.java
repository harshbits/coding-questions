package google.leetcode_2020.string;

import java.util.*;

public class GuessTheWord {

    public static void main(String[] args) {

        String[] wordList = {"acckzz", "ccbazz", "eiowzz", "abcczz"};

        new GuessTheWord().findSecretWord2(wordList, null);

    }


    // Approach 1
    // USING RANDOM GUESS
    //
    // Step 1. Guess the random word from word list
    // Step 2. Update the wordList based on x return by guess function
    // Step 2.a Only add words which has match with guess equivalent x value
    //
    // Time = O (N * 10 * 6) = O(N); N = word list
    // Space = O (N); N = word list
    public void findSecretWord1(String[] wordList, Master master) {
        // we only have 10 guesses
        // x = length of word
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordList[new Random().nextInt(wordList.length)];
            x = master.guess(guess);
            // updated word list based on x.
            List<String> wordList2 = new ArrayList<>();
            for (String w : wordList) {
                if (match(guess, w) == x) {
                    wordList2.add(w);
                }
            }
            // update the word list
            wordList = wordList2.toArray(new String[wordList2.size()]);
        }
    }

    public GuessTheWord() {
    }

    // Approach 2
    // USING MINMAX ALGORITHM
    // minimize a certain maxima heuristic
    //
    //
    //
    // Time =
    // Space =
    public void findSecretWord2(String[] wordList, Master master) {

        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordList) {
                for (String w2 : wordList) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            String guess = "";
            int min0 = 100;
            for (String w : wordList) {
                if (count.getOrDefault(w, 0) < min0) {
                    guess = w;
                    min0 = count.getOrDefault(w, 0);
                }
            }
            x = master.guess(guess);

            // prepare new word list
            List<String> wordList2 = new ArrayList<>();
            for (String w : wordList) {
                if (match(guess, w) == x) {
                    wordList2.add(w);
                }
            }
            wordList = wordList2.toArray(new String[0]);

        }
    }

    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i)
            if (a.charAt(i) == b.charAt(i))
                matches++;
        return matches;
    }

    /**
     * // This is the Master's API interface.
     * // You should not implement it, or speculate about its implementation
     */
    interface Master {
        public int guess(String word);
    }

}

