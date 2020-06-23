package facebook.leetcode_2020.array;

public class MonotonicArray {

    public static void main(String[] args) {

    }

    public boolean isMonotonic(int[] A) {

        if (A == null || A.length <= 2) {
            return true;
        }
        boolean isIncreasing = A[0] < A[1];
        for (int i = 2; i < A.length; i++) {
            boolean calc = A[i - 1] < A[i];
            if (calc != isIncreasing) {
                return false;
            }
        }
        return true;
    }
}
