package facebook.leetcode_2020.greedy;

import java.util.PriorityQueue;

public class RearrangeString {
    public static void main(String[] args) {
    }

    public String reorganizeString(String S) {
        int N = S.length();
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<MultiChar> heap = new PriorityQueue<>();
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                // Impossible to form a solution
                if (count[i] > (N + 1) / 2) {
                    return "";
                }
                heap.add(new MultiChar((char) (i + 'a'), count[i]));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (heap.size() >= 2) {

            MultiChar mc1 = heap.poll();
            MultiChar mc2 = heap.poll();

            ans.append(mc1.letter);
            ans.append(mc2.letter);

            if (--mc1.count > 0) {
                heap.add(mc1);
            }
            if (--mc2.count > 0) {
                heap.add(mc2);
            }
        }

        if (heap.size() > 0) {
            ans.append(heap.poll().letter);
        }

        return ans.toString();

    }

    private class MultiChar implements Comparable<MultiChar> {
        char letter;
        int count;

        public MultiChar(char c, int count) {
            this.letter = c;
            this.count = count;
        }

        @Override
        public int compareTo(MultiChar that) {
            return that.count - this.count;
        }
    }
}
