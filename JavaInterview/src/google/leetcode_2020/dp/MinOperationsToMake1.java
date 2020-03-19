package google.leetcode_2020.dp;

import java.util.*;

public class MinOperationsToMake1 {

    public static void main(String[] args) {
        int n1 = 10, n2 = 999;
//        System.out.println(reduceTo1(n1));
//        System.out.println(reduceTo1(n2));

        System.out.println(reduceTo1BFS(n1));
        System.out.println(reduceTo1BFS(n2));
    }

    // faster than bfs
    private static int reduceTo1(int n) {
        if (n < 2) {
            return 0;
        }

        int[] dp = new int[n + 1];
        // start with 2.
        // if n = 1, it will be 0 steps.
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    private static int reduceTo1BFS(int n) {
        if (n < 2) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        int steps = 0;
        int count = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            max = Math.max(max, queue.size());
            for (int i = 0; i < sz; i++) {
                int current = queue.poll();
                if (current == 1) {
                    System.out.println("total :" + count);
                    System.out.println("max :" + max);
                    return steps;
                }

                if (!visited[current - 1]) {
                    queue.offer(current - 1);
                    visited[current - 1] = true;
                }

                if (current % 2 == 0 && !visited[current / 2]) {
                    queue.offer(current / 2);
                    visited[current / 2] = true;
                }

                if (current % 3 == 0 && !visited[current / 3]) {
                    queue.offer(current / 3);
                    visited[current / 3] = true;
                }

                count++;
            }
//            System.out.println(queue);
            steps++;
        }

//        System.out.println("total :" + count);
        return 0;
    }

    public static String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder(s);

        int open = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                open++;
                continue;
            }
            if (sb.charAt(i) == ')') {
                if (open == 0) {
                    sb.deleteCharAt(i);
                } else {
                    open--;
                }
            }
        }

        int close = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == ')') {
                close++;
                continue;
            }
            if (sb.charAt(i) == '(') {
                if (close == 0) {
                    sb.deleteCharAt(i);
                } else {
                    close--;
                }
            }
        }

        return sb.toString();
    }


    //
    private static int reduceTo1II(int n) {

        int[] dp = new int[n + 1];
        List<Integer> primeFactors = findPrimeFactorials(n);

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;


        }

        return 0;
    }


    private static List<Integer> findPrimeFactorials(int n) {
        // remove all even
        while (n % 2 == 0) {
            n /= 2;
        }
        List<Integer> factors = new ArrayList<>();
        // Skip 1 element to avoid even numbers
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }
}


// abc((d)e


// open count
// open == 0
// remove )

// close count;
// close == 0
// remove (




