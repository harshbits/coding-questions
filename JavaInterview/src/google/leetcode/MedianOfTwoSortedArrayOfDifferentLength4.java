package google.leetcode;

/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author hbhavsar
 *
 */
public class MedianOfTwoSortedArrayOfDifferentLength4 {

	public static void main(String[] args) {
		MedianOfTwoSortedArrayOfDifferentLength4 m = new MedianOfTwoSortedArrayOfDifferentLength4();

		int[] nums1 = { 1, 3, 8, 9, 15 };
		int[] nums2 = { 7, 11, 19, 21, 18, 25 };
		double ans = m.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if (nums1.length > nums2.length) {
			findMedianSortedArrays(nums2, nums1);
		}

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = ((x + y + 1) / 2) - partitionX;
			
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
			
			
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
			
			
			// FInal condition, if satisfies, we have our answer
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				// if even
				if ((x + y) % 2 == 0) {
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				}
				// if odd
				else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			}
			else if(maxLeftX > minRightY) {
				high = partitionX - 1;
			}else {
				low = partitionX + 1;
			}
		}

		throw new IllegalArgumentException("Arrays are not sorted.");
	}
}
