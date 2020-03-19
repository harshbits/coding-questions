package google.leetcode_2020.string;

import java.util.Arrays;

public class NumberSmallerByFrequency {

    public static void main(String[] args) {

        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};

//        String[] queries = {"cbd"};
//        String[] words = {"zaaaz"};
        int[] ans = new NumberSmallerByFrequency().numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(ans));
    }


    // method 1 => sort and binary search
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
//        int[] q = new int[queries.length], w = new int[words.length];
//        // Update frequency by the smallest character's frequency
//        for (int i = 0; i < q.length; i++) {
//            q[i] = getCount(queries[i]);
//        }
////        System.out.println(Arrays.toString(q));
//
//        for (int i = 0; i < w.length; i++) {
//            w[i] = getCount(words[i]);
//        }
////        System.out.println(Arrays.toString(w));
//
//        int[] ans = new int[q.length];
//
//        // Binary search
//        // n log n
//        Arrays.sort(w);
//        // for each query check
//        // q * log n
//        for (int i = 0; i < q.length; i++) {
//            int l = 0, r = w.length - 1;
//            while (l <= r) {
//                int mid = l + (r - l) / 2;
//                if (w[mid] <= q[i]) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            ans[i] = w.length - l;
//        }
//        return ans;


        int[] freqCount = new int[11];
        for (String word : words) {
            int count = getCount(word);
            freqCount[count]++;
        }
        System.out.println(Arrays.toString(freqCount));

        // count sort
        // sum of all values
        int sum = 0;
        for (int i = 0; i < freqCount.length; i++) {
            sum += freqCount[i];
            freqCount[i] = sum;
        }
        System.out.println(Arrays.toString(freqCount));

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = getCount(queries[i]);
            // last element
            ans[i] = freqCount[freqCount.length - 1] - freqCount[count];
            System.out.println(ans[i] + " : " + freqCount[freqCount.length - 1] + " - " + freqCount[count]);
        }
        return ans;
    }

    // cdb
    // 0, 1, 1, 1, ....
    // return 1

    //zaaaz
    // 3, 0, 0 ..., 2
    // return 3,
    private int getCount(String str) {
//        int[] arr = new int[26];
//        for (char ch : str.toCharArray())
//            arr[ch - 'a']++;
////        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < 26; i++) {
//            // return the first once since we need only smallest character's frequency
//            if (arr[i] != 0)
//                return arr[i];
//        }
//

// Storage optimized
        int count = 0;
        int minChar = str.toCharArray()[0];
        for (char ch : str.toCharArray()) {
            // only need to count minimum
            if (ch == minChar) {
                count++;
            } else if (ch < minChar) {
                minChar = ch;
                count = 1;
            }
        }
        return count;
    }
}
