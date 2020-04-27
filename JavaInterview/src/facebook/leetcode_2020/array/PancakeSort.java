package facebook.leetcode_2020.array;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {

    public static void main(String[] args) {

        int[] A = {3, 2, 4, 1};
        var ans = new PancakeSort().pancakeSort(A);
        System.out.println(ans);
    }


    // Steps:

    //    Find max
//    swap max to top
//    swap max to bottom
//    reduce size
//    repeat
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        int n = A.length;

        // for all indexes
        while (n > 1) {
            // step 1. find max element
            int max = A[0];
            int maxIndex = 0;
            for (int i = 1; i < n; i++) {
                if (A[i] > max) {
                    max = A[i];
                    maxIndex = i;
                }
            }

            // step 2.
            //if max is at last position, no need to do any flips
            if (maxIndex == n - 1) {
                n--;
                continue;
            }

            // step 3
            // find the max, bring it to the front
            flips.add(maxIndex + 1);
            reverse(A, maxIndex + 1);

            // step 2 (b).
            //pancake flip the max from the front to the back
            flips.add(n);
            reverse(A, n);
            n--;
        }
        return flips;
    }

    // reverse upto n digits
    private void reverse(int[] A, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }
    }
}

