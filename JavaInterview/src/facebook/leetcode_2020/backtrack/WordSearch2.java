package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {

    public static void main(String[] args) {
        WordSearch2 w = new WordSearch2();

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        var ans = w.findWords(board, words);

        System.out.println(ans);
    }


    // Time:
    //      1. Build Trie: O(N); N = total number of letters
    //      2. backtracking: O(M * (4 * 3 ^ L - 1)) ; M = total cells in board,
    //              4= directions, 3 possible movement from current
    // Space:
    //      1. Trie: O(N); total number of letters
    //      2. Backtrack: O(L); L = length of word
    public List<String> findWords(char[][] board, String[] words) {
        List<String> foundWords = new ArrayList<>();

        // Build Trie
        TrieNode root = buildTrie(words);

        // find word
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, i, j, root, foundWords);
            }
        }

        return foundWords;
    }

    private void backtrack(char[][] board, int x, int y, TrieNode node, List<String> foundWords) {

        // breaking condition: out of bound
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }

        char c = board[x][y];

        // breaking condition: visited or not valid
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];

        // found word
        if (node.word != null) {
            foundWords.add(node.word);
            // de duplicate
            node.word = null;
        }

        // mark visited
        board[x][y] = '#';

        backtrack(board, x + 1, y, node, foundWords);
        backtrack(board, x - 1, y, node, foundWords);
        backtrack(board, x, y + 1, node, foundWords);
        backtrack(board, x, y - 1, node, foundWords);

        // mark un visited
        board[x][y] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    private class TrieNode {
        // a to z index
        TrieNode[] children;
        String word;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

}
