package facebook.leetcode_2020.trie;

import java.util.ArrayList;
import java.util.List;

public class StreamChecker {

    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker streamChecker = new StreamChecker(words); // init the dictionary.
        System.out.println(streamChecker.query('a'));          // return false
        System.out.println(streamChecker.query('b'));          // return false
        System.out.println(streamChecker.query('c'));          // return false
        System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
        System.out.println(streamChecker.query('e'));          // return false
        System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
        System.out.println(streamChecker.query('g'));          // return false
        System.out.println(streamChecker.query('h'));          // return false
        System.out.println(streamChecker.query('i'));          // return false
        System.out.println(streamChecker.query('j'));          // return false
        System.out.println(streamChecker.query('k'));          // return false
        System.out.println(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist

        String[] words1 = {"dog", "cat", "at"};
        StreamChecker streamChecker1 = new StreamChecker(words1);
        System.out.println(streamChecker1.queryGetWords('d'));
        System.out.println(streamChecker1.queryGetWords('o'));
        System.out.println(streamChecker1.queryGetWords('g'));
        System.out.println(streamChecker1.queryGetWords('c'));
        System.out.println(streamChecker1.queryGetWords('a'));
        System.out.println(streamChecker1.queryGetWords('t'));

    }

    ////////////////////////////////////
    // IMPLEMENTATION
    ////////////////////////////////////

    // Time => insert and query => O(word)
    // Space => O(26 * word * N); N => Number of words in trie

    TrieNode root;

    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                node = node.insert(word.charAt(i));
            }
            node.isWord = true;
            node.word = word;
        }
    }

    // leetcode
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            node = node.children[sb.charAt(i) - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }


    // fb asked
    StringBuilder sb1 = new StringBuilder();

    public List<String> queryGetWords(char letter) {
        List<String> words = new ArrayList<>();
        sb1.append(letter);
        TrieNode node = root;
        for (int i = sb1.length() - 1; i >= 0 && node != null; i--) {
            node = node.children[sb1.charAt(i) - 'a'];
            if (node != null && node.isWord) {
                words.add(node.word);
            }
        }
        return words;
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
            this.word = "";
        }

        public TrieNode insert(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            return children[c - 'a'];
        }
    }
}
