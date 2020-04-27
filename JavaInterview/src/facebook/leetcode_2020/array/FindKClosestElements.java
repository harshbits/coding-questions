package facebook.leetcode_2020.array;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    // Time: O(log(n-k)) + O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> elements = new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) {
            return elements;
        }

        // lo and hi: range of all possible start of subarray with size k + 1
        // so we could compare both ends
        int low = 0;
        int high = arr.length - k - 1;

        // Binary Search
        // Time: O(log(n-k))
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // sub array
        // Time: O(k)
        for (int i = 0; i < k; i++) {
            elements.add(arr[i + low]);
        }
        return elements;
    }
}
