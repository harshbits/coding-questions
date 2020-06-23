package facebook.leetcode_2020.trie;

public class WordDictionary {

    public static void main(String[] args) {
    }

    /**
     * Initialize your data structure here.
     */

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.insert(word.charAt(i));
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }


    // backtracking
    // Time = O(word) for words without '.'
    // Time = O(26 * word * N)  worst case
    // Space = O(26 * word * N)
    private boolean match(char[] ca, int k, TrieNode node) {
        if (k == ca.length) {
            return node.isWord;
        }

        if (ca[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(ca, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[ca[k] - 'a'] != null && match(ca, k + 1, node.children[ca[k] - 'a']);
        }
        return false;
    }


    class TrieNode {

        TrieNode[] children;

        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

        public TrieNode insert(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
            }
            return children[c - 'a'];
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }
    }
}
