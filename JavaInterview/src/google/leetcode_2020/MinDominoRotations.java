package google.leetcode_2020;

public class MinDominoRotations {


    public static void main(String[] args) {

        int[] A = {2, 1, 2, 4, 2, 2};

        int[] B = {5, 2, 6, 2, 3, 2};
        int ans = new MinDominoRotations().minDominoRotations(A, B);
        System.out.println(ans);
    }

    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 0) {
            return 0;
        }

        int n = A.length;
        // 1st possibility
        int ans1 = minHelper(A, B, n);
        // 2nd
        if (ans1 != -1 || A[0] == B[0]) return ans1;
        else return minHelper(B, A, n);
    }

    //
    private int minHelper(int[] A, int[] B, int n) {
        int rotationsA = 0;
        int rotationsB = 0;
        for (int i = 0; i < n; i++) {
            if (A[0] != A[i] && A[0] != B[i]) {
                return -1;
            } else if (A[i] == A[0]) {
                rotationsA++;
            } else if (B[i] == A[0]) {
                rotationsB++;
            }
        }
        return Math.min(rotationsA, rotationsB);
    }
}
