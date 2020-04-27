package facebook.leetcode_2020.math;

public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger atoi = new StringToInteger();
        System.out.println(atoi.myAtoi("   -42"));
    }

    private static final char SPACE = ' ';
    private static final char PLUS = '+';
    private static final char MINUS = '-';

    public int myAtoi(String str) {
        //1. Empty string
        if (str.length() == 0) {
            return 0;
        }

        //2. Remove Spaces
        int index = 0;
        while (index < str.length() && str.charAt(index) == SPACE) {
            index++;
        }

        //3. Determing sign
        int sign = 1;
        if (index < str.length() && (str.charAt(index) == PLUS || str.charAt(index) == MINUS)) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Convert number and avoid overflow
        int total = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';

            // Check for overflow
            // after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }
        return sign * total;
    }
}
