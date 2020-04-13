package facebook.leetcode_2020.array;

public class MissingElementInArray {
    public static void main(String[] args) {

        int[] nums = {4, 7, 9, 10};
        int k = 1;
        int ans = missingElement(nums, k);
        System.out.println(ans);


        int[] nums2 = {4, 5, 6, 7, 8};
        System.out.println(missingElement(nums2, 1));

        int[] nums1 = {4, 7, 9, 10};
        System.out.println(missingElement(nums1, 100));

    }

    // Time: O(log n)
    // Space: O(1)
    public static int missingElement(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        // missingNum < k, then return nums[n - 1] + k - missingNum
        int missingNum = nums[high] - nums[0] - high;
        if (missingNum < k) {
            return nums[high] + k - missingNum;
        }

        while (low < high - 1) {
            // mid
            int mid = low + (high - low) / 2;

            int missing = nums[mid] - nums[low] - (mid - low);

            // when the number is larger than k,
            // then the index won't be located in (mid, high]
            if (missing >= k) {
                high = mid;
            }
            // when the number is smaller than k,
            // then the index won't be located in [low, mid),
            // update k -= missing
            else {
                k -= missing;
                low = mid;
            }
        }

        return nums[low] + k;
    }
}
