package facebook.leetcode_2020.math;


import java.util.Arrays;

/**
 * Given dividend and divisor, return quotient and remainder.
 * Using division or mod operator is not allowed.
 * Do it in better than linear time.
 * Example: input: 13, 4; output: 3, 1;
 */
public class DivideTwoNumbers {

    public static void main(String[] args) {

        int[] ans1 = new DivideTwoNumbers().divide11(-14, 4);
        System.out.println(Arrays.toString(ans1));

        int[] ans2 = new DivideTwoNumbers().divide11(-14, -4);
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = new DivideTwoNumbers().divide11(-2147483648, 2);
        System.out.println(Arrays.toString(ans3));

        int[] ans4 = new DivideTwoNumbers().divide11(2147483647, 1);
        System.out.println(Arrays.toString(ans4));

        int[] ans5 = new DivideTwoNumbers().divide11(2147483647, 2);
        System.out.println(Arrays.toString(ans5));


//        System.out.println(new DivideTwoNumbers().divide2(-1, -1));
//        System.out.println(new DivideTwoNumbers().divide2(99, 10));
//        System.out.println(new DivideTwoNumbers().divide2(13, 4));
//        System.out.println(new DivideTwoNumbers().divide2(2147483647, 1));
//        System.out.println(new DivideTwoNumbers().divide2(2147483647, 2));
//        System.out.println(new DivideTwoNumbers().divide3(-2147483648, 2));
    }

    public int[] divide11(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            //ans[0] = quotient
            //ans[1] = remainder
            return new int[]{Integer.MAX_VALUE, 0};
        }
        if (divisor == 1) {
            return new int[]{dividend, 0};
        }

        // Bitwise XOR
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        //ans[0] = quotient
        //ans[1] = remainder
        int[] ans = divideBitMP(dividend, divisor);
        if (isNegative) {
            ans[0] = -ans[0];
        }
        return ans;
    }

    private int[] divideBitMP(int dividend, int divisor) {
        if (divisor < dividend) {
            if (dividend < 0) {
                dividend = -dividend;
            }
            return new int[]{0, dividend};
        }

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        int sum = divisor, quotient = 1;

        while ((Integer.MIN_VALUE - sum < sum) && sum << 1 > dividend) {
            sum <<= 1;
            quotient <<= 1;
        }

        int[] div = divideBitMP(dividend - sum, divisor);
        return new int[]{div[0] + quotient, div[1]};
    }


    public int[] divide(int dividend, int divisor) {
        //ans[0] = quotient
        //ans[1] = remainder
        return divide(dividend, divisor, 1, dividend);
    }

    // O(log dividend)
    private int[] divide(int dividend, int divisor, int low, int high) {
        if (low > high) {
            return new int[]{0, dividend};
        }

        //  mid = 1 + 12/ 2 = 1 + 6 = 7
        int mid = low + (high - low) / 2;
        // n = 13 - ( 4 * 7 ) = 14
        int n = dividend - divisor * mid;
        if (n >= divisor) {
            low = mid + 1;
        } else if (n < 0) {
            high = mid - 1;
        } else {
            return new int[]{mid, n};
        }
        return divide(dividend, divisor, low, high);
    }

    public int divide2(int dividend, int divisor) {
        // for overflow check
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        // Bitwise XOR
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long divd = Math.abs(Long.valueOf(dividend));
        long divr = Math.abs(Long.valueOf(divisor));

        return isNegative ? -divideHelper(divd, divr) : divideHelper(divd, divr);
    }

    // O(log dividend; Max = O(31), since we dont go beyong 2^31
    // This works only for long
    private int divideHelper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        //  Find the largest multiple so that (divisor * multiple <= dividend),
        // curSum = divisor * 2,
        long curSum = divisor;
        int quotient = 1;

        // keep increasing till it's less than dividend.
        while (dividend >= curSum << 1) {
            curSum <<= 1;
            quotient <<= 1;
        }
        return quotient + divideHelper(dividend - curSum, divisor);
    }

    // Without long
    public int divide3(int dividend, int divisor) {
        // for overflow check
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        // Bitwise XOR
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        return isNegative ? -divideHelper1(dividend, divisor) : divideHelper1(dividend, divisor);
    }

    // O(log dividend)
    // This works only for long
    private int divideHelper1(int dividend, int divisor) {
        // base
        // Here values are in negative
        if (divisor < dividend) {
            return 0;
        }
        //  Find the largest multiple so that (divisor * multiple <= dividend),
        int sum = divisor, quotient = 1;

        // 1st condition imagine Integer.MIN_VALUE = -10 and sum = -6.
        // we know sum + sum = -12 which is smaller than -10, so it overflows.
        while ((Integer.MIN_VALUE - sum < sum) && sum << 1 > dividend) {
            sum <<= 1;
            quotient <<= 1;
        }
        return quotient + divideHelper1(dividend - sum, divisor);
    }
}