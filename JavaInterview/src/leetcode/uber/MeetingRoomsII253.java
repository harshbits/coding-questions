package leetcode.uber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {

	
	public static void main(String[] args) {
		MeetingRoomsII253 m = new MeetingRoomsII253();
		
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		var ans = m.minMeetingRooms1(intervals);
		System.out.println(ans);
		
		intervals = new Interval[2];
		intervals[0] = new Interval(7, 10);
		intervals[1] = new Interval(2, 4);
		
		ans = m.minMeetingRooms1(intervals);
		System.out.println(ans);
		
		intervals = new Interval[2];
		intervals[0] = new Interval(5, 8);
		intervals[1] = new Interval(6, 8);

		ans = m.minMeetingRooms1(intervals);
		System.out.println(ans);
	}
	
	
	// we can also achieve using minheap, and over all size for the minheap is our
	// answer.
	public int minMeetingRooms1(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// minimum values first
				return o1 - o2;
			}
		});

		// Sort intervals by starting time.
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		// End time of first meeting
		minHeap.add(intervals[0].end);

		// check if previous meeting value is greater than, it;s false
		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i].start >= minHeap.peek()) {
				minHeap.poll();
			}

			minHeap.add(intervals[i].end);

		}
		return minHeap.size();
	}

	// using chronological sort
	public int minMeetingRooms(Interval[] intervals) {

		if(intervals == null || intervals.length == 0) return 0;
		
		int[] st = new int[intervals.length], ed = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			st[i] = intervals[i].start;
			ed[i] = intervals[i].end;
		}
		Arrays.sort(st);
		Arrays.sort(ed);
		
		// Meeting start pointer
		int startPointer = 0;
		
		// Meeting end pointer
		int endPointer = 0;
		
		int usedRooms = 0;
		
		// go by intervals over the intervals
		while (startPointer < intervals.length) {

			// if end pointer current value is less than the start values, which means room
			// is empty
			if (st[startPointer] >= ed[endPointer]) {
				usedRooms--;
				endPointer++;
			}

			// if room will get free in above condition, still we have to assign a new room
			// to upcoming meeting.
			usedRooms++;
			startPointer++;
		}
		
		return usedRooms;
	}
}
