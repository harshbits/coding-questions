package microsoft.leetcode_2020.online;

public class StringBinaryTo0 {

    public static void main(String[] args) {
        int ans = new StringBinaryTo0().approach1("011100");
        System.out.println(ans);

        ans = new StringBinaryTo0().approach1("011100");
        System.out.println(ans);
    }


    // Time:
    // Space:
    public int solution(String S) {
        // write your code in Java SE 8

        // base check
        // if size of binary is 1 then operations would be 0.
        if (S.length() == 1) {
            return 0;
        }

        //int totalOperations = approach1(S);
        return efficientApproach(S);
    }

    // Time: O(N)
    // String to char array
    private static final char ZERO = '0';
//    private static final char ONE = '1';

    private int efficientApproach(String s) {
        int totalOperations = 0;

        char[] sc = s.toCharArray();

        int start = 0;
        // remove leading zeros
        for (int i = 0; i < s.length(); i++) {
            if (sc[i] == ZERO) {
                start++;
            } else {
                break;
            }
        }

        // start in reverse since we read number in reverse
        for (int i = s.length() - 1; i >= start; ) {
//            System.out.println(Arrays.toString(sc));
            // if the value is 0 then increment total count.
            if (sc[i] == ZERO) {
                totalOperations++;
                i--;
            } else {
                totalOperations++;
                if (i == start) {
                    break;
                }
                sc[i] = ZERO;
            }
        }

        return totalOperations;
    }

    // Time: O(N) + O(log number)
    // Convert String to Integer: O(N)
    private int approach1(String S) {
        int totalOperations = 0;
        int number = Integer.parseInt(S, 2);

        while (number != 0) {
            //if even
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number--;
            }
            totalOperations++;
        }
        return totalOperations;
    }

}
