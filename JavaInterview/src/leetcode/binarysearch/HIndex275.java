package leetcode.binarysearch;

/**
 * 
 * 
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?


 * @author habhavsar
 *
 */
public class HIndex275 {

	public static void main(String[] args) {
		int[] citations = { 0, 1, 3, 5, 6 };
		int ans = new HIndex275().hIndex(citations);
		System.out.println(ans);
		
//		ans = new HIndex275().hIndex1(citations);
//		System.out.println(ans);
	}

	// o (log n) = > beats 100 % 
	public int hIndex(int[] citations) {

		if (citations == null || citations.length == 0) {
			return 0;
		}

		int len = citations.length;
		int start = 0;
		int end = len - 1;
		int hIndex = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (citations[mid] >= len - mid) {
				hIndex = Math.max(hIndex, len - mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return hIndex;
	}
	
	
	//o (log n) => Beats 46 % of the  results
	public int hIndex1(int[] citations) {

		if (citations == null || citations.length == 0) {
			return 0;
		}

		int len = citations.length;
		int start = 0;
		int end = len - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (citations[mid] == len - mid) {
				return len - mid;
			} else if (citations[mid] < len - mid) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return len - start;
	}
	
	
	// o (n) => beats 4 % of the results
//	public int hIndex2(int[] citations) {
//
//		if (citations == null || citations.length == 0) {
//			return 0;
//		}
//		int len = citations.length;
//		int hIndex = 0;
//		for (int i = 0; i < len; i++) {
//			if (citations[i] >= len - i) {
//				hIndex = len - i;
//				break;
//			}
//		}
//		return hIndex;
//	}

}
