package microsoft.leetcode_2020.online;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LRCommands {

    public static void main(String[] args) {
        int n = -11;

        System.out.println(11 & 1);
        System.out.println(10 & 1);

        System.out.println(12 & 1);
        System.out.println(13 & 1);


        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
//            System.out.println(new LRCommands().solution(n));
            new LRCommands().solution(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            new LRCommands().solution1(n);
        }
//        System.out.println(new LRCommands().solution1(n));
        end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    public int solution(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        // Initial Pair
        Pair pair = new Pair(0, 1);

        // BFS
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);

        int commands = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                if (current.L == n || current.R == n) {
                    return commands;
                }

                // add new values
                int newL = 2 * current.L - current.R;
                int newR = 2 * current.R - current.L;
                queue.offer(new Pair(newL, current.R));
                queue.offer(new Pair(current.L, newR));
            }
            commands++;
        }
        return -1;
    }

    private class Pair {
        private int L;
        private int R;

        public Pair(int L, int R) {
            this.L = L;
            this.R = R;
        }

        public int getL() {
            return L;
        }

        public void setL(int l) {
            L = l;
        }

        public int getR() {
            return R;
        }

        public void setR(int r) {
            R = r;
        }
    }


    // This is faster than BFS
    // Time: O(log |n|)
    public int solution1(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int N = n;
        //Absolute when n is negative
        if (N < 0) {
            N = -N;
        }
        // n - 1 when it's positive
        // Right shift for positive number generates
        // one number above the n (target)
        // hence doing -1.
        else {
            N--;
        }
        int L = 0;
        int R = 1;

        int commands = 0;

        while (N != 0) {
            if ((N & 1) == 1) {
                if(n < 0){

                }else {

                }
                L = moveLeft(L, R);
            } else {
                R = moveRight(L, R);
            }
            //Signed right shift
            N >>= 1;
            commands++;
        }


        // For negative number:
        // Get their absolute value, and
        // start shifting towards the right until it becomes zero
        if (n < 0) {
            while (N != 0) {
                if ((N & 1) == 1) {
                    L = moveLeft(L, R);
                } else {
                    R = moveRight(L, R);
                }
                //Signed right shift
                N >>= 1;
                commands++;
            }
        }
        // For positive number:
        // Will do similar steps except swapping moveLeft and MoveRight methods
        // If we use the same methods then it will give negative result.
        else {
            while (N != 0) {
                // if odd number
                if ((N & 1) == 1) {
                    R = moveRight(L, R);
                } else {
                    L = moveLeft(L, R);
                }
                //Signed right shift
                N >>= 1;
                commands++;
            }
        }
//        System.out.println(commands);
        return commands;
    }

    private int moveLeft(int L, int R) {
        return 2 * L - R;
    }

    private int moveRight(int L, int R) {
        return 2 * R - L;
    }

    private int moveLeft(int L, int R, List<String> commands) {
        commands.add("L");
        return 2 * L - R;
    }

    private int moveRight(int L, int R, List<String> commands) {
        commands.add("R");
        return 2 * R - L;
    }
}
