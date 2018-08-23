package google.udemy;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] input = { 9, 0, 4, 5, 1, 6, 7, 3 };
		m.mergeSort(input);
		System.out.println(Arrays.toString(input));
	}

	public void mergeSort(int[] input) {
		int l = 0;
		int r = input.length;
		sort(input, l, r);
	}

	private void merge(int[] input, int l, int m, int r) {

		// 2 sub arrays
		int n1 = m - l + 1;
		int n2 = r - l;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = input[l + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = input[m + i + 1];
		}
		
		// index of both arrays
		int i = 0, j = 0;
		int k = l;
		
	}

	private void sort(int[] input, int l, int r) {

		if (l < r) {

			int mid = (l + r) / 2;
			sort(input, l, mid);

			sort(input, mid + 1, r);

			merge(input, l, mid, r);
		}

	}

}
