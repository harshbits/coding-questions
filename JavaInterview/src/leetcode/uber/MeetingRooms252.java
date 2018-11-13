package leetcode.uber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * 
 * Given an array of meeting time intervals consisting of start and end times
 *  [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
 * @author habhavsar
 *
 */
public class MeetingRooms252 {
	
	public static void main(String[] args) {
		MeetingRooms252 m = new MeetingRooms252();
		
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		var ans = m.canAttendMeetings(intervals);
		System.out.println(ans);
		
		intervals = new Interval[2];
		intervals[0] = new Interval(7, 10);
		intervals[1] = new Interval(2, 4);
		
		ans = m.canAttendMeetings(intervals);
		System.out.println(ans);
		
		intervals = new Interval[2];
		intervals[0] = new Interval(5, 8);
		intervals[1] = new Interval(6, 8);

		ans = m.canAttendMeetings(intervals);
		System.out.println(ans);
		
	}
	
	public boolean canAttendMeetings1(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) return true;
		// Sort intervals by starting time.
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
	
		// check if previous meeting value is greater than, it;s false 
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		
		return true;
	}
	
	// Without changing input
	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
		int[] st = new int[intervals.length], ed = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            st[i] = intervals[i].start;
            ed[i] = intervals[i].end;
        }
        Arrays.sort(st);
        Arrays.sort(ed);
        for(int i = 1; i < st.length; i++){
            if(st[i] < ed[i - 1]) return false;
        }
        return true;
    }
	

}

class Interval {
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
