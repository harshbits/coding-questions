package leetcode.uber.sidepractice;

public class ImplementTrie208 {

	
	public static void main(String[] args) {
		
	}
	
	class TrieNode{
	    TrieNode[] neighbors;
	    boolean isEnd;
	    
	    public TrieNode(){
	        neighbors = new TrieNode[26];
	        isEnd = false;
	    }
	}
	class Trie {
	    private TrieNode root;
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode cur = root;
	        for(char c: word.toCharArray()){
	            if(cur.neighbors[c-'a']==null){
	                cur.neighbors[c-'a'] = new TrieNode();
	            }
	            cur = cur.neighbors[c-'a'];
	        }
	        cur.isEnd = true;
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TrieNode cur = root;
	        for(char c: word.toCharArray()){
	            if(cur.neighbors[c-'a']!=null){
	                cur = cur.neighbors[c-'a'];
	            } else {
	                return false;
	            }
	        }
	        return cur.isEnd;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode cur = root;
	        for(char c: prefix.toCharArray()){
	            if(cur.neighbors[c-'a']!=null){
	                cur = cur.neighbors[c-'a'];
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
