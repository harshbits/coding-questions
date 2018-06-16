package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 * 
 * @author hbhavsar
 *
 *
 * Also in Bloomberg
 */
public class GroupAnagrams {

	
	public static void main(String[] args) {
		
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		
		System.out.println(new GroupAnagrams().groupAnagrams(strs));

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		
		//first 26 prime numbers.
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };

		// We can also generate prime numbers.
		// but for leetcode performance, will use predefined.

		// int[] prime = new int[26];
		// int cur = 2;
		// for (int i = 0; i < 26; i++) {
		// while (!isPrime(cur)) {
		// cur++;
		// }
		// prime[i] = cur;
		// cur++;
		// }
		
		 HashMap<Integer, List<String>> map = new HashMap<>();
		 
		 // Stream out performs the leet code beating %.
		 
//		 Arrays.stream(strs).forEach(s ->{
//			int key = 1;
//			// generate key using each characters
//			// Similar concept as HashCode
//			for (char ch : s.toCharArray()) {
//				key *= prime[ch - 'a'];
//			}
//			List<String> group = map.containsKey(key) ? map.get(key) : new ArrayList<>();
//            group.add(s);
//            map.put(key, group); 
//		 });
		 
		 // Better performance.
		for (String s : strs) {
			// get key, prime number multiplications
			int key = 1;
			for (char ch : s.toCharArray()) {
				key *= prime[ch - 'a'];
			}
			List<String> group = map.containsKey(key) ? map.get(key) : new ArrayList<>();
			group.add(s);
			map.put(key, group); 
		} 
		
		
//		System.out.println(map); 
		return new ArrayList<>(map.values());
	}
	
	boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
