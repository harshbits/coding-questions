package facebook.leetcode_2020.trie;

import java.util.*;

public class ShortEncodingOfWords {

    public static void main(String[] args) {

        String[] words = {"time", "me", "bell"};
        new ShortEncodingOfWords().minimumLengthEncoding(words);

    }

    public Solution minimumLengthEncoding(String[] words) {

        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j) {
                cur = cur.get(word.charAt(j));
            }
            nodes.put(cur, i);
        }

        int count = 0;
        List<Integer> indexes = new ArrayList<>();
        for (TrieNode node : nodes.keySet()) {
            if (node.count == 0) {
                count += words[nodes.get(node)].length() + 1;
            }
        }
        System.out.println(nodes);

        System.out.println(indexes);
        System.out.println(count);

        Solution ans = new Solution();
        return ans;
    }


    class Solution {
        String encode;
        int[] indexes;


    }

    class TrieNode {
        TrieNode[] children;
        int count;


        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }

        @Override
        public String toString() {
            String s = "trie[ ";
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    s += ", " + (char) (i + 'a');
                }
            }
            s += " ], count[" + count + "]";
            return s;

//
//            return "TrieNode{" +
//                    "children=" + Arrays.toString(children) +
//                    ", count=" + count +
//                    '}';
        }
    }
}
