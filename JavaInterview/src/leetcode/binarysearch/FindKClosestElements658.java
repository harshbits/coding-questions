package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements658 {

	public static void main(String[] args) {

		int[] arr = { 0, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;

		var ans = new FindKClosestElements658().findClosestElements(arr, k, x);
		System.out.println(ans);

	}

	// Beats 98% of the results
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> ans = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return ans;
		}
		int len = arr.length;
		int start = 0, end = len - k;

		while (start < end) {
//			System.out.println("S:" + start +", E: "+ end);
			int mid = (start + end) / 2;

			if (x - arr[mid] > arr[mid + k] - x) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
//		Integer[] res = new Integer[k];
		for (int i = 0; i < k; i++) {
//			res[i] = arr[i + start];
			ans.add(arr[i + start]);
		}

//		return Arrays.asList(res);
		return ans;
	}

	// beats 86% of the results
	public List<Integer> findClosestElements2(int[] arr, int k, int x) {
		List<Integer> ans = new ArrayList<>();
		int len = arr.length;
		int start = 0, end = len;

		// find the x
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] < x)
				start = mid + 1;
			else
				end = mid;
		}

		if (start == len) {
			start--;
		}
		if (start == 0) {
			start++;
		}

		// determine l and r, based on mid element or x
		// If we don't have that element exist, then make start as first index
		int l = start - 1;
		int r = start;

		// Determine boundary
		while (r - l - 1 < k) {
			if (l == -1) {
				++r;
			} else if (r >= arr.length) {
				--l;
			} else if (x - arr[l] <= arr[r] - x) {
				--l;
			} else {
				++r;
			}
		}

		// Add elements to answer
		for (int i = l + 1; i < r; i++) {
			ans.add(arr[i]);
		}
		return ans;
	}

	// Time limit exceeds.
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		List<Integer> ans = new ArrayList<>();
		int len = arr.length;
		int start = 0, end = len;
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] == x) {
//				ans.add(arr[mid]);
				int count = 1;
				int l = mid, r = mid;
				while (count < k) {
					if (l - 1 >= 0 && r + 1 < len) {
						int left = x - arr[l - 1];
						int right = arr[r + 1] - x;
						if (left <= right) {
//							ans.add(arr[mid - l]);
							l--;
						} else {
//							ans.add(arr[mid + r]);
							r++;
						}
					} else if (l - 1 >= 0) {
//						ans.add(arr[mid - l]);
						l--;
					} else if (r + 1 < len) {
//						ans.add(arr[mid + r]);
						r++;
					}
					count++;
				}

				for (int i = l; i <= r; i++) {
					ans.add(arr[i]);
				}
				return ans;
			} else if (arr[mid] < x) {
				start = mid;
			} else {
				end = mid - 1;
			}
		}

		for (int i = 0; i < k; i++) {
			ans.add(arr[i]);
		}

		return ans;
	}

}
