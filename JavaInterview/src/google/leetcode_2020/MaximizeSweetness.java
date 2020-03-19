package google.leetcode_2020;

import java.util.Arrays;

public class MaximizeSweetness {


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ans = new MaximizeSweetness().maximizeSweetness(A, 5);
        System.out.println(ans);
    }

    // O(Nlog(10^9))
    // Space O(1)
    public int maximizeSweetness(int[] A, int K) {
        int left = 1, right = (int) 1e9 / (K + 1);
        // r = sweetness sum / k + 1

        while (left < right) {
            // add 1
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                if ((cur += a) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

//    // for a certian min sum requirement, check whether this can split into m groups
//    private boolean canSplit(int[] nums, int m, int minSum) {
//        int count = 0;
//        long sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if (sum >= minSum) {
//                sum = 0;
//                count++;
//            }
//        }
//        return count >= m;
//    }



//    // O(n log n )
//    public int maximizeSweetness1(int[] sweetness, int K) {
//        int l = 0, r = Arrays.stream(sweetness).sum() / (K + 1);
//        while (l < r) {
//            int mid = l + (r - l + 1) / 2, cnt = 0;
//            for (int i = 0, cur = 0; i < sweetness.length; ++i) {
//                cur += sweetness[i];
//                if (cur >= mid) {
//                    cur = 0;
//                    ++cnt;
//                }
//            }
//            if (cnt >= K + 1) {
//                l = mid;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return l;
//    }
}
