package facebook.leetcode_2020.math;

public class CountNumberOf1 {

    public static void main(String[] args) {
        CountNumberOf1 one = new CountNumberOf1();
        System.out.println(one.count1InBase10(1021221));
    }

    public int count1InBase10(int num) {
        int count = 0;
        while (num != 0) {
            count += num % 10 == 1 ? 1 : 0;
            num /= 10;
        }
        return count;
    }

    // Returns XOR of counts 0s and 1s
    // in binary representation of n.
    public int count1InBinary(int num) {
        int count0 = 0, count1 = 0;
        while (num != 0) {
            //calculating count of zeros and ones
            if (num % 2 == 0) {
                count0++;
            } else {
                count1++;
            }
            num /= 2;
        }
        // XOR
        return (count0 ^ count1);
    }
}
