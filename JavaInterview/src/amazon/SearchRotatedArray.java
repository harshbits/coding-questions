package amazon;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

 * @author hbhavsar
 *
 */
public class SearchRotatedArray {

	
	
	public static void main(String[] args) {
		int[] array = { 4, 5, 6, 7, 0, 1, 2 };
	}
	
	
	public int search(int[] nums, int target) {
		return 0;
    }
	
	public int searchArray(int[] nums, int target, int l, int h) {
		
		if (l < h) {
			return -1;
		}
		
		int m = (l + h) / 2;
		
		
		return 0;
    }
	
}
