package leetcode.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {

	public static void main(String[] args) {

	}

	// beats 99.68 % 
	public List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() < 2) {
			return intervals;
		}
		List<Interval> answer = new ArrayList<>();

		int[] stA = new int[intervals.size()];
		int[] edA = new int[intervals.size()];

		// O (n)
		for (int i = 0; i < intervals.size(); i++) {
			stA[i] = intervals.get(i).start;
			edA[i] = intervals.get(i).end;
		}

		// O (n)
//		int count = 0;
//		for (Interval i : intervals) {
//			stA[count] = i.start;
//			edA[count] = i.end;
//			count++;
//		}

		// O (n log n)
		Arrays.sort(stA);
		Arrays.sort(edA);

		int j = 0;
		// O (n)
		for (int i = 0; i < stA.length; i++) {

			// if it's last element or next start is greater than current end
			// we do not have overlapping interval anymore
			if (i == stA.length - 1 || stA[i + 1] > edA[i]) {
				answer.add(new Interval(stA[j], edA[i]));
				// next start is current index plus last i.
				j = i + 1;
			}
		}

		return answer;

	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
