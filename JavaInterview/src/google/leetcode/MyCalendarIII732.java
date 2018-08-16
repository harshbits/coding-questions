package google.leetcode;

import java.util.TreeMap;

public class MyCalendarIII732 {
	
	public static void main(String[] args) {
		MyCalendarIII732 m = new MyCalendarIII732();
		System.out.println(m.book(10, 20));
		System.out.println(m.book(50, 60));
		System.out.println(m.book(10, 40));
		System.out.println(m.book(5, 15));
		System.out.println(m.book(5, 10));
		System.out.println(m.book(25, 55));
	}

	private TreeMap<Integer, Integer> timeline;

	public MyCalendarIII732() {
		this.timeline = new TreeMap<>();

	}

	public int book(int start, int end) {
		
		timeline.put(start, timeline.getOrDefault(start, 0) + 1);
		timeline.put(end, timeline.getOrDefault(end, 0) - 1);
		
		int ongoing = 0;
		int k = 0;
		for(int v: timeline.values()) {
			k = Math.max(k, ongoing += v);
		}
		
		return k;
	}

}
