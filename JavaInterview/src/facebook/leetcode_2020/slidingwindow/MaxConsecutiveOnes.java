package facebook.leetcode_2020.slidingwindow;

public class MaxConsecutiveOnes {


//    Translation:
//    Find the longest subarray with at most K zeros.


//    Explanation
//    For each A[j], try to find the longest subarray.
//    If A[i] ~ A[j] has zeros <= K, we continue to increment j.
//    If A[i] ~ A[j] has zeros > K, we increment i.

    //Time: O(n)
    //Space: O(1)
    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) {
                K--;
            }
            if (K < 0 && A[i++] == 0) {
                K++;
            }
        }
        return j - i;
    }
}

// Variance
//Input char array consistes of 'W' and 'H' for week day and holiday respectively, and an
//int n. We can change 'W' to 'H' n times and return the longest continoust subarray consisting 'H