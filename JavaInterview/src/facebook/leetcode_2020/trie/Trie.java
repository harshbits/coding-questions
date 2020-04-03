package facebook.leetcode_2020.trie;

class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.insert(c);
        }
        node.setEndOfWord();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length() && node != null; i++) {
            node = node.get(word.charAt(i));
        }
        return node != null && node.isWord();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int count = 0;
        for (int i = 0; i < prefix.length() && node != null; i++) {
            node = node.get(prefix.charAt(i));
            count++;
        }
        return node != null && prefix.length() == count;

    }


    class TrieNode {

        private TrieNode[] children;

        private boolean isWord;

        public TrieNode() {
            // a - z
            this.children = new TrieNode[26];
            this.isWord = false;
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

        public void setEndOfWord() {
            isWord = true;
        }

        public boolean isWord() {
            return isWord;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */