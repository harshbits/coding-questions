package facebook.leetcode_2020.greedy;

public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2763));
        System.out.println(maximumSwap(9976));
    }

    // Time: O(n)
    // Space: O(1)
    public static int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        //Use buckets to record the last position of digit 0 ~ 9 in this num.
        int[] buckets = new int[10];
//        int max = digits[0] - '0';
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
//            max = Math.max(max, digits[i] - '0');
        }

        // O(n * 10) = O(10)
        for (int i = 0; i < digits.length; i++) {
            // at max k = 9
//            for (int k = max; k > digits[i] - '0'; k--) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}
