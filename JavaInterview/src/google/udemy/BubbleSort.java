package google.udemy;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 20, 35, -15, 7, 55, 1, -22 };
		BubbleSort b = new BubbleSort();
		b.bubbleSort(array);
		System.out.println(Arrays.toString(array));
	}

	public void bubbleSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, i, j);
				}
			}
		}
	}

	public void swap(int[] array, int i, int j) {

		if (i == j) {
			return;
		}

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
