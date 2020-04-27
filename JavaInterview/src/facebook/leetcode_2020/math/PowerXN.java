package facebook.leetcode_2020.math;

public class PowerXN {

    public static void main(String[] args) {
        double ans = new PowerXN().myPow(2, 10);
        System.out.println(ans);
    }

    // Time: O(log n)
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        // if n is negative
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;

        // Binary Search
        while (n != 0) {
            // if odd number
            if (n % 2 == 1) {
                ans *= x;
            }
            x *= x;
            n /= 2;
        }

        return ans;
    }

    public double pow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }
}
