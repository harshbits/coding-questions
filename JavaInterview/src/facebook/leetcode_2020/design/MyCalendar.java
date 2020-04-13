package facebook.leetcode_2020.design;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    public static void main(String[] args) {

        MyCalendar my = new MyCalendar();
        System.out.println(my.book(10, 20)); // returns true
        System.out.println(my.book(15, 25)); // returns false
        System.out.println(my.book(20, 30)); // returns true
    }

    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    // Time: O(log n)
    // Overall: O(n log n)
    public boolean book(int start, int end) {
        Integer floorKey = calendar.floorKey(start);
        if (floorKey != null && calendar.get(floorKey) > start) {
            return false;
        }
        Integer ceilingKey = calendar.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }


    // My Calendar 2
    private Map<Integer, Integer> map = new TreeMap<>();

    public boolean book2(int s, int e) {
        map.put(s, map.getOrDefault(s, 0) + 1);
        map.put(e, map.getOrDefault(e, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            k = Math.max(k, cnt += v);
            if (k > 2) {
                map.put(s, map.get(s) - 1);
                map.put(e, map.get(e) + 1);
                return false;
            }
        }
        return true;
    }

    // My Calendar 3

    private Map<Integer, Integer> map2 = new TreeMap<>();

    public int book3(int start, int end) {
        map2.put(start, map.getOrDefault(start, 0) + 1);
        map2.put(end, map.getOrDefault(end, 0) - 1);

        int cnt = 0, k = 0;
        for (int v : map.values()) {
            cnt += v;
            k = Math.max(k, cnt);
        }
        return k;
    }

}
