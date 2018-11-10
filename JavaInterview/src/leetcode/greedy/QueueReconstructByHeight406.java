package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructByHeight406 {

	public static void main(String[] args) {

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };

		var ans = new QueueReconstructByHeight406().reconstructQueue(people);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}

	public int[][] reconstructQueue(int[][] people) {

		// Sort people by their height in descending order,
		// if height is same then smaller k should come first
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				// if height is equal than consider the k
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});

		// insertion is faster
		List<int[]> list = new LinkedList<>();
		for (int[] p : people) {
			list.add(p[1], p);
		}

		return list.toArray(new int[people.length][]);
	}

}
