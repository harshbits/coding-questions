package google.leetcode_2020;

public class LongestSubStrWORepeat {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = new LongestSubStrWORepeat().lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
////        System.out.println(map);
//        return ans;
        int n = s.length(), ans = 0;

        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return ans;
    }
}

// i = 0;
// map [a] = 1
// map [b] = 2
// map [c] = 3
// ans = 3

// i = 1
// map [a] = 4
// map [b] = 8
// map [c] = 6
//

// j = 7, i = 5


