package facebook.leetcode_2020.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(new amazon.string.GroupAnagrams().groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {

        //first 26 prime numbers.
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
                103 };

        HashMap<Integer, List<String>> map = new HashMap<>();

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
