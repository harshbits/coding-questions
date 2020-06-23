package facebook.leetcode_2020.array;

import java.util.HashMap;
import java.util.Map;

public class MaxOccuringNumber {

    public static void main(String[] args) {
        int[][] ranges = {{1, 6}, {2, 3}, {2, 5}, {3, 8}};
        System.out.println(maxOccuringElement(ranges));
    }

    public static int maxOccuringElement(int[][] ranges) {
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 0);

        int start = 0;
        int end = 0;
        for (int[] range : ranges) {
            int left = range[0];
            int right = range[1];

            frequency.put(left, frequency.getOrDefault(left, 0) + 1);
            frequency.put(right + 1, frequency.getOrDefault(right + 1, 0) - 1);

            start = Math.min(start, left);
            end = Math.max(end, right);
        }

        int maxFreq = 0;
        int num = 0;
        for (int i = start + 1; i <= end; i++) {
            if (!frequency.containsKey(i)) {
                frequency.put(i, 0);
            }

            frequency.put(i, frequency.get(i - 1) + frequency.get(i));

            if (frequency.get(i) > maxFreq) {
                maxFreq = frequency.get(i);
                num = i;
            }
        }
        return num;
    }
}
