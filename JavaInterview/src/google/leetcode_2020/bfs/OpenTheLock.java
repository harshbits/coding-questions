package google.leetcode_2020.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    public static void main(String[] args) {

        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        int ans = new OpenTheLock().openLock(deadends, "0202");
        System.out.println(ans);
    }

    public int openLock(String[] deadends, String target) {

        // O(1) look up
        Set<String> deadEndSet = new HashSet<>();
        // Defining 2 sets for bi directional search
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();

        for (String de : deadends) {
            deadEndSet.add(de);
        }
        if (deadEndSet.add("0000")) {
            begin.add("0000");
        }
        if (deadEndSet.add(target)) {
            end.add(target);
        }

        int steps = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String current : begin) {
                char[] sc = current.toCharArray();
                for (int i = 0; i < sc.length; i++) {
                    char c = sc[i];
                    // this will give the next number less than 10.
                    // if number is 9 then will return 0.
                    sc[i] = (char) ((c - '0' + 1) % 10 + '0');
                    String next = new String(sc);

                    if (end.contains(next)) {
                        return steps + 1;
                    }
                    if (deadEndSet.add(next)) {
                        temp.add(next);
                    }

                    // this will give the previous number less than 10.
                    // if number is 0 then will return 9.
                    sc[i] = (char) ((c - '0' + 9) % 10 + '0');
                    next = new String(sc);
                    if (end.contains(next)) {
                        return steps + 1;
                    }
                    if (deadEndSet.add(next)) {
                        temp.add(next);
                    }

                    sc[i] = c;
                }
            }

            steps++;
            begin = end;
            end = temp;


            System.out.println(begin);
            System.out.println(end);
        }

        return -1;
    }
}
//
//
//// Why Swap?
//// By always picking a smaller set, this process could reduce a
//// little(since in this problem the scale on both sides are similar)
//// time complexity and memory complexity.
//            if (begin.size() > end.size()) {
//                    temp = begin;
//                    begin = end;
//                    end = temp;
//                    }
