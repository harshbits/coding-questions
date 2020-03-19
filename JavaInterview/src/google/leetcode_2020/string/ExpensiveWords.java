package google.leetcode_2020.string;

import java.util.*;

//Example:
//        Input:
//        S = "heeellooo"
//        words = ["hello", "hi", "helo"]
//        Output: 1
//        Explanation:
//        We can extend "e" and "o" in the word "hello" to get "heeellooo".
//        We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
public class ExpensiveWords {

    public static void main(String[] args) {


        Map<Character, Integer> map = new HashMap<>();
        for (Character c : "hello".toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(map);
        Map<Character, Integer> map1 = new LinkedHashMap<>();
        for (Character c : "hello".toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        System.out.println(map1);



        String S = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        int ans = new ExpensiveWords().expressiveWords(S, words);
        System.out.println(ans);
    }


    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        outerLoop:
        for (String word : words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                // condition
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    // breaks only inner loop
                    continue outerLoop;
            }
            ans++;
        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList<>();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N - 1 || ca[i] != ca[i + 1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }
        key = sb.toString();
    }
}



//
//    public int expressiveWords(String S, String[] words) {
//        int res = 0;
//        char[] s = S.toCharArray();
//        for (String w : words) {
//            if (isStretchy(s, w.toCharArray())) {
//                ++res;
//            }//
//        }
//        return res;
//    }
//
//    // think from perspective of iterative through s, not w. w iteration is happenstance.
//    private boolean isStretchy(char[] s, char[] w) {
//        int sLen = s.length, wLen = w.length, sI = 0, wI = 0;
//        while (sI < sLen) {
//            if (wI < wLen && s[sI] == w[wI]) {
//                ++sI;
//                ++wI;
//            }
//            // END OF STRETCH
//            else if (sI > 1 && s[sI - 1] == s[sI] && s[sI - 2] == s[sI]) {
//                ++sI;
//            }
//            // MID OF STRETCH
//            else if (sI > 0 && sI < sLen - 1 && s[sI - 1] == s[sI] && s[sI + 1] == s[sI]) {
//                ++sI;
//            }
//            else {
//                return false;
//            }
//
//        }
//        return wI == wLen;
//    }
//}




// MAP IS BAD IDEA, SINCE MAP DOES NOT maintain the order.

//    public int expressiveWords(String S, String[] words) {
//
//        int ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (Character c : S.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (String word : words) {
//            if (isExpressiveWord(S, map, word)) ans++;
//        }
//        return ans;
//    }
//
//    public boolean isExpressiveWord(String S, Map<Character, Integer> map, String W) {
//
//        Map<Character, Integer> map1 = new HashMap<>();
//        for (Character c : W.toCharArray()) {
//            map1.put(c, map.getOrDefault(c, 0) + 1);
//        }
//
//
//        System.out.println(map);
//        System.out.println(map1);
//
//        for (Map.Entry entry : map1.entrySet()) {
//            if (!map.containsKey(entry.getKey())) {
//                return false;
//            }
//
//            if (map.get(entry.getKey()) == entry.getValue()) {
//                continue;
//            } else if ((map.get(entry.getKey()) - (int) entry.getValue() + 1) < 3) {
//                return false;
//            }
//        }
//        return true;
//    }
//}


//    public int expressiveWords(String S, String[] words) {
//        RLE R = new RLE(S);
//        int ans = 0;
//
//        search: for (String word: words) {
//            RLE R2 = new RLE(word);
//            if (!R.key.equals(R2.key)) continue;
//            for (int i = 0; i < R.counts.size(); ++i) {
//                int c1 = R.counts.get(i);
//                int c2 = R2.counts.get(i);
//                if (c1 < 3 && c1 != c2 || c1 < c2)
//                    continue search;
//            }
//            ans++;
//        }
//        return ans;
//    }
//}

//class RLE {
//    String key;
//    List<Integer> counts;
//
//    public RLE(String S) {
//        StringBuilder sb = new StringBuilder();
//        counts = new ArrayList();
//
//        char[] ca = S.toCharArray();
//        int N = ca.length;
//        int prev = -1;
//        for (int i = 0; i < N; ++i) {
//            if (i == N-1 || ca[i] != ca[i+1]) {
//                sb.append(ca[i]);
//                counts.add(i - prev);
//                prev = i;
//            }
//        }
//
//        key = sb.toString();
//    }
//}
