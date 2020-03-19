package google.leetcode_2020.backtracking;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumberII {

    public static void main(String[] args) {
        int ans = new ConfusingNumberII().confusingNumberII(20);
        System.out.println(ans);

//        ans = new ConfusingNumberII().confusingNumberII1(20);
//        System.out.println(ans);

        int ans1 = new ConfusingNumberII().confusingNumberII(999);
        System.out.println(ans1);
//        ans1 = new ConfusingNumberII().confusingNumberII1(100);
//        System.out.println(ans1);
    }

//    int[] validNumbers = {0, 1, 6, 8, 9};
//
//    Map<Integer, Integer> mapping = new HashMap<>() {{
//        put(0, 0);
//        put(1, 1);
//        put(6, 9);
//        put(8, 8);
//        put(9, 6);
//    }};

    int[][] mapping = {{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};

    public int confusingNumberII(int N) {
        // start with current = 1.
        int[] count = new int[2];
        backtrack(0, 0, 1, N, count);

        System.out.println("total: calls ->  " + count[1]);
        return count[0];
    }

    // dfs
    private void backtrack(int num, int rotatedNum, int current, int limit, int[] count) {
        count[1]++;
        // termination condition
        if (num > limit) {
//            return 0;
            return;
        }

        if (num != rotatedNum) {
            count[0]++;
        }

        for (int[] map : mapping) {
            if (num == 0 && map[0] == 0) {
                continue;
            }
            int next = num * 10 + map[0];
            int nextRotatedNum = map[1] * current + rotatedNum;
            backtrack(next, nextRotatedNum, current * 10, limit, count);
        }
    }


//    public int confusingNumberII1(int N) {
//        // start with current = 1.
//        int[] count = new int[1];
//        backtrack1(0, 0, 1, N, count);
//        return count[0];
//    }
//
//    private void backtrack1(int num, int rotatedNum, int digit, int N, int[] count) {
//        if (num > N) {
//            return;
//        }
//        if (num != rotatedNum) {
//            count[0]++;
//        }
//
//        for (int[] map : mapping) {
//
//            backtrack1(num * 10 + map[0], map[1] * digit + rotatedNum, digit * 10, N, count);
//        }
//    }

}
