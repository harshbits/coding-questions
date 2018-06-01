package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PlatformMeetingMinimum {

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// int n = scanner.nextInt();
		// int[] arrTimes = new int[n];
		// int[] depTimes = new int[n];
		// int count = 0;
		// for (int i = 0; i < n * 2; i++) {
		// int input = scanner.nextInt();
		// if (i % 2 == 0) {
		// arrTimes[count] = input;
		// } else {
		// depTimes[count] = input;
		// count++;
		// }
		// }

		// int arrTimes[] = new int[] { 900, 940, 950, 1100, 1500, 1800 };
		// int depTimes[] = new int[] { 910, 1200, 1120, 1130, 1900, 2000 };

		// int arrTimes[] = new int[] { 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600,
		// 1700, 1800 };
		// int depTimes[] = new int[] { 910, 1010, 1110, 1210, 1310, 1410, 1510, 1810,
		// 1710, 1810 };

		int arrTimes[] = new int[] { 900, 920, 950, 1000, 1230 };
		int depTimes[] = new int[] { 930, 1200, 1200, 1200, 1300 };

		int ansSorting = findPlatformSorting(arrTimes, depTimes, arrTimes.length);
		int ansStack = findPlatformStack(arrTimes, depTimes, arrTimes.length);

		System.out.println(ansSorting);
		System.out.println(ansStack);
	}

	// O(N)
	static int findPlatformStack(int arrTimes[], int depTimes[], int n) {
		Stack<Integer> arrivaldeparturestack = new Stack<>();
		int occupiedplatforms = arrivaldeparturestack.size();
		for (int i = 0, j = 0; i < n && j <= n;) {
			if (arrTimes[i] <= depTimes[j]) {
				arrivaldeparturestack.push(arrTimes[i]);
				i++;
			} else {
				arrivaldeparturestack.pop();
				j++;
			}
			occupiedplatforms = Math.max(occupiedplatforms, arrivaldeparturestack.size());
		}
		return occupiedplatforms;
	}

	// O(N logN)
	static int findPlatformSorting(int arr[], int dep[], int n) {
		// Sort arrival and departure arrays
		Arrays.sort(arr);
		Arrays.sort(dep);

		// plat_needed indicates number of platforms
		// needed at a time
		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		// Similar to merge in merge sort to process
		// all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival,
			// increment count of platforms needed
			if (arr[i] < dep[j]) {
				plat_needed++;
				i++;

				// Update result if needed
				if (plat_needed > result)
					result = plat_needed;
			}

			// Else decrement count of platforms needed
			else {
				plat_needed--;
				j++;
			}
		}
		return result;
	}

}
