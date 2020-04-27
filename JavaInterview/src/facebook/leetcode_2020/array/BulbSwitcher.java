package facebook.leetcode_2020.array;

public class BulbSwitcher {

    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4};
        int ans = new BulbSwitcher().solution(A);
        System.out.println(ans);
    }

    // Time O(N)
    // Space O(1); constant
    public int solution(int[] A) {
        int totalMoments = 0;
        if (A == null || A.length == 0) {
            return totalMoments;
        }
        // right = # of right most lighted bulb.
        int right = 0;
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, A[i]);
            // all the previous bulbs (to the left) are turned on.
            if (right == i + 1) {
                totalMoments++;
            }
        }
        return totalMoments;
    }
}
