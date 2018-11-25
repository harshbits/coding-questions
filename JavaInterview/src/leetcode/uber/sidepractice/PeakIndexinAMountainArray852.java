package leetcode.uber.sidepractice;

/**
 * 
 * Let's call an array A a mountain if the following properties hold:
 * 
 * A.length >= 3 There exists some 0 < i < A.length - 1 such that A[0] < A[1] <
 * ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] Given an array that is
 * definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i]
 * > A[i+1] > ... > A[A.length - 1].
 * 
 * @author habhavsar
 * 
 * Beats 91.54%
 *
 */
public class PeakIndexinAMountainArray852 {

	public static void main(String[] args) {

		int[] A = { 0, 2, 1, 0 };
		var ans = new PeakIndexinAMountainArray852().peakIndexInMountainArray(A);
		System.out.println(ans);
	}

	public int peakIndexInMountainArray(int[] A) {

		int start = 0;
		int end = A.length - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid + 1] && A[mid - 1] < A[mid]) {
				return mid;
			} else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[end] > A[start]) {
			return end;
		}

		return start;
	}
}

//
//int start = 0;
//int end = A.length - 1;
//
//while (start + 1 < end) {
//    int mid = start + (end - start) / 2;
//    if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
//        return mid;
//    } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
//        start = mid;
//    } else {
//        end = mid;
//    }
//}
//
//if (A[end] > A[start]) {
//    return end;
//}
//return start;